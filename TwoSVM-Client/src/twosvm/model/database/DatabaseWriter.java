package twosvm.model.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseWriter {
	
	/**
	 * 
	 * @param userName
	 * @throws IOException
	 */
	public void writeUserDatabase(String userName) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/UserDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.append(userName + "\n");
		buffWrite.close();

	} // fim do metodo writeUser
	
	/**
	 * 
	 * @param deviceName
	 * @throws IOException
	 */
	public void writeDeviceDatabase(String deviceName) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/DeviceDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.append(deviceName + "\n");
		buffWrite.close();
		
		buffWrite.close();

	} // fim do metodo writeDeviceDatabase
	
	/**
	 * 
	 * @param deviceIP
	 * @throws IOException
	 */
	public void writeDeviceIPDatabase(String deviceIP) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/DeviceIPDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.append(deviceIP + "\n");
		buffWrite.close();
		
		buffWrite.close();

	} // fim do metodo writeDeviceIPDatabase
	
	/**
	 * 
	 * @param softwareResourceAL
	 * @throws IOException
	 */
	public void writeSoftwareDatabase(ArrayList<String> softwareResourceAL) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/SoftwareDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		
		int size = softwareResourceAL.size();
		for (int index = 0; index < size; index++) {
			buffWrite.append(softwareResourceAL.get(index) + "\n");
		}
		
		buffWrite.close();

	} // fim do metodo writeSoftwareResource

	/**
	 * 
	 * @param hardwareResourceAL
	 * @throws IOException
	 */
	public void writeHardwareResource(ArrayList<String> hardwareResourceAL) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/HardwareDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		
		int size = hardwareResourceAL.size();
		for (int index = 0; index < size; index++) {
			buffWrite.append(hardwareResourceAL.get(index) + "\n");
		}
		
		buffWrite.close();

	} // fim do metodo writeHardwareResource
	
	/**
	 * 
	 * @param deviceName
	 * @throws IOException
	 */
	public void writeDeviceRegistryDatabase(String deviceName) throws IOException {
		
		String path = "./src/twosvm/twosbroker/userresourcedatabase/deviceRegistryDatabase.txt";

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
		buffWrite.append(deviceName + "\n");
		buffWrite.close();

	} // fim do metodo writeUser
	
}
