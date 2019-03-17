package twosvm.model.instance.service.moveapps;

import java.io.IOException;
import java.rmi.NotBoundException;

import twosvm.model.instance.application.Application;
import twosvm.model.instance.resource.Hardware;
import twosvm.model.instance.resource.Resource;
import twosvm.model.instance.resource.Software;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.matching.Matching;

import com.toc.coredx.DDS.*;

/**
 * 
 * @author marcelogoncalves
 *
 */
public class AppSub {

	public static void main(String[] args) {

		final Resource resource = new Resource();

		DomainParticipantFactory dpfa = DomainParticipantFactory.get_instance();
		DomainParticipant dpa = null;

		dpa = dpfa.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		AppMsgTypeSupport tsa = new AppMsgTypeSupport();
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
		final AppMsg data = new AppMsg();
		data.msg = new String("Mensagem foi recebida pelo sub");
		final AppMsgDataWriter dw = (AppMsgDataWriter) pub
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

				// System.out.println("topico:" + td.get_name());

				AppMsgDataReader string_dr = (AppMsgDataReader) dr;
				AppMsgSeq samples = new AppMsgSeq();
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
								// OBTENDO A MENSAGEM E O ID DO DISPOSITIVO QUE
								// A ENVIOU
								System.out.println("Recursos de hardware: "
										+ samples.value[i].hardwareResource);
								System.out.println("Recursos de software:"
										+ samples.value[i].softwareResource);
								System.out
										.println("ID do dispositivo: "
												+ samples.value[i].identificador
												+ "\n");
								
								// Identificar do dispositivo
								resource.setResourceID(samples.value[i].identificador);

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
										//System.out.println(hardware
											//	.getHardwareName());
										nomeHardware = "";
										resource.setHardwareResource(hardware);
									}

								}

								// Percorrendo a string que contém os nomes dos
								// atributos de software, fazendo o parsing
								// e setando os atributos do objeto software
								String nomeSoftware = "";
								percorreString = atributos_Software.charAt(0);
								nomeSoftware += percorreString;

								// loop para Software
								for (i = 1; i < atributos_Software.length(); i++) {
									if (atributos_Software.charAt(i) != '+') {
										nomeSoftware += atributos_Software
												.charAt(i);
									} else {
										// Criando um novo objeto do tipo
										// software e setando seus atributos
										Software software = new Software();
										software.setSoftwareName(nomeSoftware);
										software.setLiteralFeature(nomeSoftware);
										//System.out.println(software
											//	.getSoftwareName());
										nomeSoftware = "";
										resource.setSoftwareResource(software);
									}

								}

								// Envia confirmacao do recebimento da mensagem
								new Thread() {
									public void run() {
										
										User user = new User();

										user.setUserName("Alexandre Berndt");
										//user.setUserRoleName("father");
										
										// Criando novo objeto Application
										Application application = new Application();
									
										application.setAppName("mail");
										application.setOperatingSystem("android");
										application.setProgLanguage("java");
										

										Matching matching = Matching.getInstance();
										
										// Alerta de novo resource no SS
										System.err.println("AppSub - Novo smart object encontrado no espaco inteligente!\n");
										
										try {
											matching.matchingResource(resource);
										} catch (NotBoundException
												| IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
					
										// Alerta de novo resource no SS
										System.err.println("AppSub - Novo usuario no espaco inteligente!\n");
										
										try {
											matching.matchingUser(user);
										} catch (ClassNotFoundException
												| InstantiationException
												| IllegalAccessException
												| IOException
												| NotBoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
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
		}
		;

		System.out.println("STARTING -------------------------");
		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		System.out.println("CREATE PARTICIPANT ---------------");
		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		System.out.println("REGISTERING TYPE -----------------");
		AppMsgTypeSupport ts = new AppMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg");

		System.out.println("CREATE TOPIC ---------------------");
		Topic top = dp.create_topic("helloTopic", ts.get_type_name(), null, // default
																			// qos
				null, 0); // no listener

		System.out.println("CREATE SUBSCRIBER ----------------");
		SubscriberQos sub_qos = null;
		SubscriberListener sub_listener = null;
		Subscriber sub = dp.create_subscriber(sub_qos, sub_listener, 0);

		System.out.println("CREATE DATAREADER ----------------\n\n");
		DataReaderQos dr_qos = new DataReaderQos();
		sub.get_default_datareader_qos(dr_qos);
		dr_qos.entity_name.value = "JAVA_DR";
		dr_qos.history.depth = 10;
		DataReaderListener dr_listener = new TestDataReaderListener();
		AppMsgDataReader dr = (AppMsgDataReader) sub
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
