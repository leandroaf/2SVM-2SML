package twosvm.twosbroker.adapter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;

public class Adapter {
	
	private static Adapter instance = null;

	/**
	 * Construtor
	 */
	public Adapter() {
	}

	/**
	 * 
	 * @return
	 */
	public static Adapter getInstance() {
		if (instance == null) {
			instance = new Adapter();
		}
		return instance;
	}
	
	/**
	 * Metodo para obter o nome do usuario do sistema
	 * @return
	 */
	public String queryUserData() {
		return System.getProperty("user.name").toLowerCase();
	}
	
	/**
	 * Obtem informacao do Sistema Operacional
	 * 
	 * @throws UnknownHostException
	 */
	public String getOperatingSystemInfo() {
		return System.getProperty("os.name", "generic").toLowerCase(
				Locale.ENGLISH);
	}

	/**
	 * 
	 * @return
	 */
	public String getOSArch() {
		return "os.arch";
	}

	/**
	 * Obtem informacao do host
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public String getHostName() throws UnknownHostException {
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		return ip.getHostName();
	}

	/**
	 * Obtem versao do sistema operacional
	 * 
	 * @return
	 */
	public String getVersionOperatingSystem() {
		return System.getProperty("os.version");
	}

	/**
	 * Obtem IP do dispositivo
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public String getDeviceIP() throws UnknownHostException {
		InetAddress ip;
		ip = InetAddress.getLocalHost();
		
		return ip.getHostAddress();
	} // fim getDeviceIP

}
