package twosvm.twosbroker.devicemanager.eventhandler.newsmartspace;

import java.io.IOException;

import twosvm.model.database.DatabaseReader;
import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.twosbroker.manager.TwosBrokerManager;

import com.toc.coredx.DDS.*;

/**
 * Esta classe recebe uma notificacao de entrada de dispositivo e usuario no Smart Space
 * Apos isso, coleta as informacoes locais do dispositivo e repassa para a camada de MW
 * @author leandroalexandre
 *
 */
public class SmartSpaceSub {

	public void newSmartSpace() {
		
		System.out.println("Esperando evento relacionado a entrada do Usuario/SmartObject em um Espaco Inteligente...");

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

				SmartSpaceMsgDataReader string_dr = (SmartSpaceMsgDataReader) dr;
				SmartSpaceMsgSeq samples = new SmartSpaceMsgSeq();
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
								
								System.out.println("New Smart Space detected!");

								// encaminhar evento para camada de Broker
								final String eventName = samples.value[i].eventName;
								final String location = samples.value[i].location;

								// Thread para lidar com a mensagem a ser
								// enviada para a camada de Broker
								new Thread() {
									public void run() {
										// faz chamada a NewContextChange do
										// mw.handler.event.newcontextchangehandler
										try {
											newContextChange(eventName,
													location);
										} catch (IOException e) {
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
			 * 
			 * @param eName
			 * @param nLocation
			 * @throws Exception 
			 */
			public void newContextChange(String eventName, String sSpacelocation)
					throws Exception {

				System.out.println("Event detected: " + eventName);
				System.out.println("Smart Space: " + sSpacelocation);

				// -------------------------------------------------------- //
				// Evento de entrada do dispositivo no Smart Space //
				// -------------------------------------------------------- //
				DatabaseReader databaseReader = new DatabaseReader();
				ContextChange contextChange = new ContextChange();
				User user = new User();

				// Obtem informacoes do usuario e do recurso
				user.setUserName(databaseReader.readUserDatabase());
				user.setDeviceName(databaseReader.readDeviceDatabase());
				user.setDeviceIP(databaseReader.readDeviceIPDatabase());
				user.setSoftwareResource(databaseReader.readSoftwareDatabase());
				user.setHardwareResource(databaseReader.readHardwareDatabase());

				contextChange.setEventName(eventName);
				contextChange.setUser(user);
				
				// envia para a camada de MW da 2SVM-Client
				TwosBrokerManager twosBrokerManager = new TwosBrokerManager();
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

		SmartSpaceMsgTypeSupport ts = new SmartSpaceMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg"

		Topic top = dp.create_topic("newSmartSpaceTopic", ts.get_type_name(),
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
		SmartSpaceMsgDataReader dr = (SmartSpaceMsgDataReader) sub
				.create_datareader(top, dr_qos, dr_listener,
						coredx.getDDS_ALL_STATUS());

		while (true) {
			try {
				Thread.currentThread().sleep(5000); // 5 second sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
};
