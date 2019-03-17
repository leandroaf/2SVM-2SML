package twosvm.uctwosmiddleware.localeventhandler.ubiquitousapplication;


import twosvm.model.instance.contextchange.ContextChange;
import twosvm.model.instance.user.User;
import twosvm.uctwosmiddleware.localmodelinterpreter.LocalModelInterpreter;

import com.toc.coredx.DDS.*;

public class UbiAppPub {

	public void newEvent(ContextChange cChange) throws Exception {
		
		ContextChange contextChange = new ContextChange();
		contextChange = cChange;
		
		User user = new User();

		user = contextChange.getUser();
		
		//System.out.println("STARTING -------------------------");
		DomainParticipantFactory dpf = DomainParticipantFactory.get_instance();
		DomainParticipant dp = null;

		// System.out.println("CREATE PARTICIPANT ---------------");
		dp = dpf.create_participant(0, /* domain Id */
				null, /* default qos */
				null, /* no listener */
				0);

		// System.out.println("REGISTERING TYPE -----------------");
		UbiAppMsgTypeSupport ts = new UbiAppMsgTypeSupport();
		ReturnCode_t retval = ts.register_type(dp, null); // "StringMsg");

		// System.out.println("CREATE TOPIC ---------------------");
		Topic top = dp.create_topic("ubiquitousApplicationTopic", ts.get_type_name(), null, // default
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
		UbiAppMsgDataWriter dw = (UbiAppMsgDataWriter) pub.create_datawriter(
				top, dw_qos, dw_listener, 0);
		
		UbiAppMsg data = new UbiAppMsg();
		
		// enriquece o evento, adicionando informacoes relativas ao M@RT local
		LocalModelInterpreter modelInterpreter = new LocalModelInterpreter();
		contextChange = modelInterpreter.enrichingEvent(contextChange);
		
		data.eventName = new String(contextChange.getEventName());
		data.userLocationSS = new String(user.userLocationSS());
		
		data.deviceID = new String(user.deviceID());
		data.devLocationSS = new String(user.deviceLocationSS());
		data.deviceTypeSS = new String(user.deviceTypeAL().get(0));
		data.deviceNameSS = new String(user.deviceNameSS());
		data.deviceIP = new String(user.deviceIP());
		
		data.userID = new String(user.userID());
		data.userTypeSS = new String(user.userTypeSS()); 
		data.userNameSS = new String(user.userNameSS());
		
		data.appID = new String(user.applicationID()); // envia todos os IDs das aplicacoes, separados por virgula
		data.appTypeSS = new String(user.appTypeSS()); // envia todos os tipos de aplicacoes, separados por virgula
		data.appNameSS = new String(user.applicationNameSS()); // envia todos os nomes das aplicacoes, separados por virgula
		
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
