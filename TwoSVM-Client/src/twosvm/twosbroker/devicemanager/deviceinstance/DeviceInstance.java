package twosvm.twosbroker.devicemanager.deviceinstance;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Locale;

import twosvm.model.database.DatabaseWriter;
import twosvm.model.mrt.SmartObjectMRT;
import twosvm.twosbroker.adapter.Adapter;
import twosvm.twosbroker.devicemanager.eventhandler.changelocation.ChangeLocationSub;
import twosvm.twosbroker.devicemanager.eventhandler.newsmartspace.SmartSpaceSub;

public class DeviceInstance {

	private static DeviceInstance instance = null;

	Adapter adapter = new Adapter();

	/**
	 * Construtor
	 */
	public DeviceInstance() {
	}

	/**
	 * 
	 * @return
	 */
	public static DeviceInstance getInstance() {
		if (instance == null) {
			instance = new DeviceInstance();
		}
		return instance;
	}

	/**
	 * Inicia gerenciador do dispositivo, obtendo informacoes do recurso
	 * 
	 * @return
	 * @throws IOException
	 */
	public void startDeviceManager() throws IOException {
		// Servico responsavel por receber eventos relacionados a entrada de
		// usuario no espaco inteligente
		new Thread() {
			public void run() {
				SmartSpaceSub smartSpaceSub = new SmartSpaceSub();
				smartSpaceSub.newSmartSpace();
			}
		}.start();

		DatabaseWriter databaseWriter = new DatabaseWriter();

		String deviceName;
		String deviceIP;
		ArrayList<String> softwareResourceAL = new ArrayList<String>();
		ArrayList<String> hardwareResourceAL = new ArrayList<String>();

		// Device Name
		deviceName = adapter.getHostName();
		databaseWriter.writeDeviceDatabase(deviceName);

		// IP
		deviceIP = adapter.getDeviceIP();
		databaseWriter.writeDeviceIPDatabase(deviceIP);

		// Software
		softwareResourceAL.add(adapter.getOperatingSystemInfo());
		databaseWriter.writeSoftwareDatabase(softwareResourceAL);

		// Hardware
		hardwareResourceAL.add("retinaDisplay");
		hardwareResourceAL.add("nvidiaGeforce");
		databaseWriter.writeHardwareResource(hardwareResourceAL);

	} // fim do metodo startDeviceManager

	/**
	 * 
	 * @param smartObjectMRT
	 * @throws IOException
	 */
	public void activateSmartObject(SmartObjectMRT smartObjectMRT)
			throws IOException {
		String smartObjectName = smartObjectMRT.getSmartObjectName();
		DatabaseWriter databaseWriter = new DatabaseWriter();
		databaseWriter.writeDeviceRegistryDatabase(smartObjectName);
	} // fim do metodo deviceRegistry

	/**
	 * 
	 */
	public void startListeners() {
		// Servico responsavel por receber eventos relacionados a mudanca de
		// localizacao do usuario
		new Thread() {
			public void run() {
				System.out.println("Listener relacionado a mudanca de localizacao do Usuario/SmartObject...");
				ChangeLocationSub changeLocationSub = new ChangeLocationSub();
				changeLocationSub.changeLocation();
			}
		}.start();
	}

}
