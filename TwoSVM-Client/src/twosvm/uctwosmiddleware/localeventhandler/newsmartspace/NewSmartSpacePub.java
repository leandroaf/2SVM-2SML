package twosvm.uctwosmiddleware.localeventhandler.newsmartspace;

import java.net.UnknownHostException;

import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.eventhandler.newsmartspace.NewSmartSpaceMsg;
import twosvm.uctwosmiddleware.eventhandler.newsmartspace.NewSmartSpaceMsgDataWriter;
import twosvm.uctwosmiddleware.eventhandler.newsmartspace.NewSmartSpaceMsgTypeSupport;

import com.toc.coredx.DDS.DataWriterListener;
import com.toc.coredx.DDS.DataWriterQos;
import com.toc.coredx.DDS.DomainParticipant;
import com.toc.coredx.DDS.DomainParticipantFactory;
import com.toc.coredx.DDS.Publisher;
import com.toc.coredx.DDS.PublisherListener;
import com.toc.coredx.DDS.PublisherQos;
import com.toc.coredx.DDS.ReturnCode_t;
import com.toc.coredx.DDS.Topic;

/**
 * Classe responsavel por publicar eventos relacionados a entrada de entidades
 * no SS
 * 
 * 2SVM-Client
 * 
 * @author leandroalexandre
 *
 */
public class NewSmartSpacePub {

	public void newElement(ContextChange contextChange)
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

		int i = 0;

		while (i < 10) {

			NewSmartSpaceMsg data = new NewSmartSpaceMsg();

			User user = new User();
			user = contextChange.getUser();

			data.deviceName = new String(user.deviceNameSS());
			data.deviceIP = new String(user.deviceIP());
			data.softwareResource = new String(user.softwareResourceSS());
			data.hardwareResource = new String(user.hardwareResourceSS());
			data.userName = new String(user.userNameSS());

			// DDS_HANDLE_NIL (or null) says datawriter should compute handle
			retval = dw.write(data, null);

			if (retval != ReturnCode_t.RETCODE_OK)
				System.out.println("   ====  DDS_DataWriter_write() error... ");

			try {
				Thread.currentThread().sleep(3000); // 1 second sleep
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}

	}
};
