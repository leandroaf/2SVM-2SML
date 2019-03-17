package twosvm.uctwosmiddleware.eventhandler.newsmartspace;

import java.net.UnknownHostException;

import com.toc.coredx.DDS.*;

/**
 * Classe responsavel por publicar eventos relacionados a entrada de entidades
 * no SS
 * 
 * 2SVM-Controller
 * 
 * @author leandroalexandre
 *
 */
public class NewSmartSpacePub {

	public void newEntity(String deviceName, String deviceIP,
			String softwareResource, String hardwareResource, String userName)
			throws UnknownHostException {
		// System.out.println("STARTING -------------------------");
		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		// System.out.println("CREATE PARTICIPANT ---------------");
		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		// System.out.println("REGISTERING TYPE -----------------");
		NewSmartSpaceMsgTypeSupport ts = new NewSmartSpaceMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg");

		// System.out.println("CREATE TOPIC ---------------------");
		Topic top = dp.create_topic("helloTopic", ts.get_type_name(), null, // default
																			// qos
				null, 0); // no listener

		// System.out.println("CREATE PUBLISHER -----------------");
		PublisherQos pub_qos = null;
		PublisherListener pub_listener = null;
		Publisher pub = dp.create_publisher(pub_qos, pub_listener, 0);

		// System.out.println("CREATE DATAWRITER ----------------");
		DataWriterQos dw_qos = new DataWriterQos();
		pub.get_default_datawriter_qos(dw_qos);
		dw_qos.entity_name.value = "JAVA_DW";
		DataWriterListener dw_listener = null;
		NewSmartSpaceMsgDataWriter dw = (NewSmartSpaceMsgDataWriter) pub
				.create_datawriter(top, dw_qos, dw_listener, 0);

		int i = 1;

		NewSmartSpaceMsg data = new NewSmartSpaceMsg();

		// Simulando a entrada de um dispositivo com as seguintes
		// caracteristicas
		data.deviceName = new String(deviceName);
		data.deviceIP = new String(deviceIP);
		data.softwareResource = new String(softwareResource);
		data.hardwareResource = new String(hardwareResource);
		data.userName = new String(userName);

		// DDS_HANDLE_NIL (or null) says datawriter should compute handle
		retval = dw.write(data, null);

		if (retval != ReturnCode_t.RETCODE_OK)
			System.out.println("   ====  DDS_DataWriter_write() error... ");

		try {
			Thread.currentThread().sleep(1000); // 1 second sleep
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
};
