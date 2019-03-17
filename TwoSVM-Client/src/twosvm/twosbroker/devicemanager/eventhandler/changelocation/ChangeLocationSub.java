package twosvm.twosbroker.devicemanager.eventhandler.changelocation;

import java.net.UnknownHostException;
import java.util.ArrayList;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.service.Serv;
import twosvm.model.instance.user.User;
import twosvm.twosbroker.manager.TwosBrokerManager;

import com.toc.coredx.DDS.*;

public class ChangeLocationSub {

	public void changeLocation() {
		
		class TestDataReaderListener implements DataReaderListener {
			public long get_nil_mask() {
				return 0;
			}

			public void on_requested_deadline_missed(DataReader dr,
					RequestedDeadlineMissedStatus status) {
			};

			public void on_requested_incompatible_qos(DataReader dr,
					RequestedIncompatibleQosStatus status) {
			};

			public void on_sample_rejected(DataReader dr,
					SampleRejectedStatus status) {
			};

			public void on_liveliness_changed(DataReader dr,
					LivelinessChangedStatus status) {
				TopicDescription td = dr.get_topicdescription();
			}

			public void on_subscription_matched(DataReader dr,
					SubscriptionMatchedStatus status) {
				TopicDescription td = dr.get_topicdescription();
			}

			public void on_sample_lost(DataReader dr, SampleLostStatus status) {
			};

			public void on_data_available(DataReader dr) {
				
				TopicDescription td = dr.get_topicdescription();

				ChangeLocationMsgDataReader string_dr = (ChangeLocationMsgDataReader) dr;
				ChangeLocationMsgSeq samples = new ChangeLocationMsgSeq();
				SampleInfoSeq si = new SampleInfoSeq();
				ReturnCode_t retval = string_dr.take(samples, si, 100,
						coredx.DDS_ANY_SAMPLE_STATE, coredx.DDS_ANY_VIEW_STATE,
						coredx.DDS_ANY_INSTANCE_STATE);

				if (retval == ReturnCode_t.RETCODE_OK) {
					if (samples.value == null)
						System.out
								.println(" @@@@@@@@@@@        samples.value = null");
					else {
						for (int i = 0; i < samples.value.length; i++) {
							// conteudo da mensagem
							if (si.value[i].valid_data) {
								
								System.err.println("\nMudanca da contexto detectada!\n");
								
								// encaminhar evento para camada de Broker
								final String eventName = samples.value[i].eventName;
								final String newLocation = samples.value[i].newLocation;
								System.out.println("Evento: " +eventName);
								System.out.println("Nova localizacao: " +newLocation);

								// Thread para lidar com a mensagem a ser
								// enviada para a camada de Broker
								new Thread() {
									public void run() {
										// faz chamada a NewContextChange do mw.handler.event.newcontextchangehandler
										try {
											newContextChange(eventName, newLocation);
										} catch (UnknownHostException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} catch (Exception e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
								}.start();

							}

						}
					}
					string_dr.return_loan(samples, si);
				} else {
				}
			};

			/**
			 * Metodo para enviar a camada de Broker novo evento de mudanca de
			 * contexto detectado
			 * @param eName
			 * @param nLocation
			 * @throws Exception 
			 */
			public void newContextChange(String eName, String nLocation) throws Exception {
				
				TwosBrokerManager twosBrokerManager = new TwosBrokerManager();

				String eventName = eName;
				String newLocation = nLocation;

				// Criando objeto do tipo ContextChange
				ContextChange contextChange = new ContextChange();
				User user = new User();
				ArrayList<Serv> serviceAL = new ArrayList<Serv>();
				
				contextChange.setEventName(eventName);
				user.setDeviceLocation(newLocation);
				user.setUserLocation(newLocation);
				contextChange.setUser(user);

				// faz chamada a metodo na camada de mw, em event handler
				// class: newContextChangeHandler
				twosBrokerManager.sendEvent(contextChange);

			} // fim do metodo

		}
		;

		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		ChangeLocationMsgTypeSupport ts = new ChangeLocationMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg"

		Topic top = dp.create_topic("contextChangeTopic", ts.get_type_name(),
				null, // default qos
				null, 0); // no listener

		SubscriberQos sub_qos = null;
		SubscriberListener sub_listener = null;
		Subscriber sub = dp.create_subscriber(sub_qos, sub_listener, 0);

		DataReaderQos dr_qos = new DataReaderQos();
		sub.get_default_datareader_qos(dr_qos);
		dr_qos.entity_name.value = "JAVA_DR";
		dr_qos.history.depth = 10;
		DataReaderListener dr_listener = new TestDataReaderListener();
		ChangeLocationMsgDataReader dr = (ChangeLocationMsgDataReader) sub.create_datareader(top,
				dr_qos, dr_listener, coredx.getDDS_ALL_STATUS());

		while (true) {
			try {
				Thread.currentThread().sleep(5000); // 5 second sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
};
