package twosvm.uctwosmiddleware.eventhandler.newsmartspace;

import java.net.InetAddress;
import java.net.UnknownHostException;

import twosvm.model.instance.resource.Hardware;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.resource.Software;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.eventhandler.EventHandler;

import com.toc.coredx.DDS.*;

/**
 * 
 * @author marcelogoncalves
 *
 */
public class NewSmartSpaceSub {
	
	/**
	 * Metodo para receber novas entidades no espaco intelingete
	 * 
	 * @throws UnknownHostException
	 */
	public void newEntityInSmartSpace() throws UnknownHostException {

		final Resource resource = new Resource();

		DomainParticipantFactory dpfa = DomainParticipantFactory.get_instance();
		DomainParticipant dpa = null;

		dpa = dpfa.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		NewSmartSpaceMsgTypeSupport tsa = new NewSmartSpaceMsgTypeSupport();
		ReturnCode_t retvala = tsa.register_type(dpa, null); // "StringMsg");

		Topic topa = dpa.create_topic("novoTopico", tsa.get_type_name(), null,
				null, 0);
		PublisherQos pub_qos = null;
		PublisherListener pub_listener = null;
		Publisher pub = dpa.create_publisher(pub_qos, pub_listener, 0);

		DataWriterQos dw_qos = new DataWriterQos();
		pub.get_default_datawriter_qos(dw_qos);
		dw_qos.entity_name.value = "JAVA_DW";
		DataWriterListener dw_listener = null;

		int i = 0;
		final NewSmartSpaceMsg data = new NewSmartSpaceMsg();
		data.deviceIP = new String(InetAddress.getLocalHost().getHostAddress());
		final NewSmartSpaceMsgDataWriter dw = (NewSmartSpaceMsgDataWriter) pub
				.create_datawriter(topa, dw_qos, dw_listener, 0);

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
				//long tempoInicio = System.currentTimeMillis();

				NewSmartSpaceMsgDataReader string_dr = (NewSmartSpaceMsgDataReader) dr;
				NewSmartSpaceMsgSeq samples = new NewSmartSpaceMsgSeq();
				SampleInfoSeq si = new SampleInfoSeq();
				final ReturnCode_t retval = string_dr.take(samples, si, 100,
						coredx.DDS_ANY_SAMPLE_STATE, coredx.DDS_ANY_VIEW_STATE,
						coredx.DDS_ANY_INSTANCE_STATE);

				if (retval == ReturnCode_t.RETCODE_OK) {

					if (samples.value == null)
						System.out.println(" samples.value = null");
					else {
						for (int i = 0; i < samples.value.length; i++) {

							if (si.value[i].valid_data) {
								// Obtendo a mensagem que o dispositivo enviou
								final String deviceName = samples.value[i].deviceName;
								final String userName = samples.value[i].userName;
								final String deviceIP = samples.value[i].deviceIP;

								System.out.println("Nome do dispositivo: "
										+ deviceName + "");
								System.out.println("Nome do usuario: "
										+ userName + "");
								System.out.println("IP do dispositivo: "
										+ deviceIP + "\n");

								// Identificar do dispositivo
								resource.setResourceName(samples.value[i].deviceName);
								resource.setUserName(samples.value[i].userName);

								// Percorrendo a string que contém os nomes dos
								// atributos de hardware, fazendo o parsing
								// e setando os atributos do objeto hardware
								String atributos_Hardware = samples.value[i].hardwareResource;
								String atributos_Software = samples.value[i].softwareResource;
								String nomeHardware = "";
								char percorreString;
								percorreString = atributos_Hardware.charAt(0);
								nomeHardware += percorreString;

								// loop para Hardware
								for (i = 1; i < atributos_Hardware.length(); i++) {
									if (atributos_Hardware.charAt(i) != '+') {
										nomeHardware += atributos_Hardware
												.charAt(i);

									} else {
										// Criando um novo objeto do tipo
										// hardware e setando seus atributos
										Hardware hardware = new Hardware();
										hardware.setHardwareName(nomeHardware);
										hardware.setLiteralFeature(nomeHardware);
										resource.setHardwareResource(hardware);
									}

								}

								// Percorrendo a string que contém os nomes dos
								// atributos de software, fazendo o parsing
								// e setando os atributos do objeto software
								String softwareName = "";
								percorreString = atributos_Software.charAt(0);
								softwareName += percorreString;

								// loop para Software
								for (i = 1; i < atributos_Software.length(); i++) {
									if (atributos_Software.charAt(i) != '+') {
										softwareName += atributos_Software
												.charAt(i);
									} else {
										// Criando um novo objeto do tipo
										// software e setando seus atributos
										Software software = new Software();
										software.setSoftwareName(softwareName);
										software.setLiteralFeature(softwareName);
										softwareName = "";
										resource.setSoftwareResource(software);
									}

								}

								resource.setResourceIP(deviceIP);

								// Envia confirmacao do recebimento da mensagem
								new Thread() {
									public void run() {

										User user = new User();

										user.setUserName(userName);
										user.setDeviceIP(deviceIP);

										EventHandler eventHandler = new EventHandler();
										eventHandler.newSmartSpace(user,
												resource);

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
				.println("Esperando por eventos relacionados a entrada de novos Usuarios/SmartObjects no Espaco Inteligente...");
		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		NewSmartSpaceMsgTypeSupport ts = new NewSmartSpaceMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg");

		Topic top = dp.create_topic("helloTopic", ts.get_type_name(), null, // default
																			// qos
				null, 0); // no listener

		SubscriberQos sub_qos = null;
		SubscriberListener sub_listener = null;
		Subscriber sub = dp.create_subscriber(sub_qos, sub_listener, 0);

		DataReaderQos dr_qos = new DataReaderQos();
		sub.get_default_datareader_qos(dr_qos);
		dr_qos.entity_name.value = "JAVA_DR";
		dr_qos.history.depth = 10;
		DataReaderListener dr_listener = new TestDataReaderListener();
		NewSmartSpaceMsgDataReader dr = (NewSmartSpaceMsgDataReader) sub
				.create_datareader(top, dr_qos, dr_listener,
						coredx.getDDS_ALL_STATUS());

		while (true) {
			try {
				Thread.currentThread().sleep(200); // 0,2 seconds sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
};
