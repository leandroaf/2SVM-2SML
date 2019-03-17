package twosvm.twosbroker.applicationmanager.startapplication;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.twosbroker.manager.TwosBrokerManager;

import com.toc.coredx.DDS.*;

public class StartApplicationSub {

	public void startApplication() {

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

				StartApplicationMsgDataReaderSA string_dr = (StartApplicationMsgDataReaderSA) dr;
				StartApplicationMsgSeqSA samples = new StartApplicationMsgSeqSA();
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

								// encaminhar evento para camada de Broker
								final String eventName = samples.value[i].eventName;
								final String applicationName = samples.value[i].applicationName;
								final String applicationType = samples.value[i].applicationType;
								System.out.println("Evento: " + eventName);
								System.out.println("Aplicacao Ubiqua: "
										+ applicationName);

								// Thread para lidar com a mensagem a ser
								// enviada para a camada de Broker
								new Thread() {
									public void run() {
										// faz chamada a NewContextChange do
										// mw.handler.event.newcontextchangehandler
										try {
											startApplicationInDevice(eventName,
													applicationName, applicationType);
										} catch (RemoteException
												| NotBoundException e) {
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
			 * @param appName
			 * @throws NotBoundException 
			 * @throws RemoteException 
			 */
			public void startApplicationInDevice(String eName, String appName, String appType) throws RemoteException, NotBoundException {

				String eventName = eName;
				String applicationName = appName;
				String applicationType = appType;

				// Criando objeto do tipo ContextChange
				ContextChange contextChange = new ContextChange();
				User user = new User();
				
				contextChange.setEventName(eventName);
				user.setAppName(applicationName);
				user.setAppType(applicationType);
				contextChange.setUser(user);

				// -------------------------------------------------------- //
				// Evento de inicializacao de uma aplicacao //
				// -------------------------------------------------------- //
				TwosBrokerManager twosBrokerManager = new TwosBrokerManager();
				twosBrokerManager.startApplicationInDevice(contextChange);

			} // fim do metodo

		}
		;

		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		StartApplicationMsgTypeSupportSA ts = new StartApplicationMsgTypeSupportSA();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg"

		Topic top = dp.create_topic("startApplicationTopic",
				ts.get_type_name(), null, // default qos
				null, 0); // no listener

		SubscriberQos sub_qos = null;
		SubscriberListener sub_listener = null;
		Subscriber sub = dp.create_subscriber(sub_qos, sub_listener, 0);

		DataReaderQos dr_qos = new DataReaderQos();
		sub.get_default_datareader_qos(dr_qos);
		dr_qos.entity_name.value = "JAVA_DR";
		dr_qos.history.depth = 10;
		DataReaderListener dr_listener = new TestDataReaderListener();
		StartApplicationMsgDataReaderSA dr = (StartApplicationMsgDataReaderSA) sub.create_datareader(
				top, dr_qos, dr_listener, coredx.getDDS_ALL_STATUS());
		
		while (true) {
			try {
				Thread.currentThread().sleep(5000); // 5 second sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
};
