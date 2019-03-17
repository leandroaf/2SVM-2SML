package twosvm.uctwosmiddleware.eventhandler.contextchange;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.eventhandler.EventHandler;

import com.toc.coredx.DDS.*;

public class ContextChangeSub {

	public void newEvents() {

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

				ContextChangeMsgDataReader string_dr = (ContextChangeMsgDataReader) dr;
				ContextChangeMsgSeq samples = new ContextChangeMsgSeq();
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
								final String deviceLocationSS = samples.value[i].devLocationSS;
								final String userID = samples.value[i].userID;
								final String userLocationSS = samples.value[i].userLocationSS;
								final String userNameSS = samples.value[i].userNameSS;
								final String userTypeSS = samples.value[i].userTypeSS;
								final String appID = samples.value[i].appID;
								final String appNameSS = samples.value[i].appNameSS;
								final String appTypeSS = samples.value[i].appTypeSS;
								final String deviceID = samples.value[i].deviceID;
								final String deviceNameSS = samples.value[i].deviceNameSS;
								final String deviceTypeSS = samples.value[i].deviceTypeSS;
								final String deviceIP = samples.value[i].deviceIP;

								// Thread para lidar com a mensagem a ser
								// enviada para a camada de Broker
								new Thread() {
									public void run() {

										ContextChange contextChange = new ContextChange();
										contextChange.setEventName(eventName);
										User user = new User();

										user.setUserID(userID);
										user.setUserName(userNameSS);
										user.setUserType(userTypeSS);
										user.setUserLocation(userLocationSS);

										user.setDeviceID(deviceID);
										user.setDeviceLocation(deviceLocationSS);
										user.setDeviceType(deviceTypeSS);
										user.setDeviceName(deviceNameSS);
										user.setDeviceIP(deviceIP);

										user.setAppID(appID);
										user.setAppName(appNameSS);
										user.setAppType(appTypeSS);

										contextChange.setUser(user);

										EventHandler eventHandler = new EventHandler();
										eventHandler
												.contextChange(contextChange);

									}
								}.start();

							}

						}
					}
					string_dr.return_loan(samples, si);
				} else {
				}
			};

		}
		;
		System.out
				.println("Esperando por eventos relacionados a mudancas de contexto no ambiente...");
		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		// System.out.println("CREATE PARTICIPANT ---------------");
		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		// System.out.println("REGISTERING TYPE -----------------");
		ContextChangeMsgTypeSupport ts = new ContextChangeMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg"

		// System.out.println("CREATE TOPIC ---------------------");
		Topic top = dp.create_topic("policyTopic", ts.get_type_name(), null, // default
																				// qos
				null, 0); // no listener

		// System.out.println("CREATE SUBSCRIBER ----------------");
		SubscriberQos sub_qos = null;
		SubscriberListener sub_listener = null;
		Subscriber sub = dp.create_subscriber(sub_qos, sub_listener, 0);

		// System.out.println("CREATE DATAREADER ----------------");
		DataReaderQos dr_qos = new DataReaderQos();
		sub.get_default_datareader_qos(dr_qos);
		dr_qos.entity_name.value = "JAVA_DR";
		dr_qos.history.depth = 10;
		DataReaderListener dr_listener = new TestDataReaderListener();
		ContextChangeMsgDataReader dr = (ContextChangeMsgDataReader) sub
				.create_datareader(top, dr_qos, dr_listener,
						coredx.getDDS_ALL_STATUS());
		

		while (true) {
			try {
				Thread.currentThread().sleep(1000); // 5 second sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
};
