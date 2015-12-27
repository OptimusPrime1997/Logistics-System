/**
 * 
 */
package util;

import java.rmi.RemoteException;

import util.enumData.City;
import bl.loginbl.LoginblController;

/**
 * @author G
 *
 */
public class CurrentCity {
	
	public static City getCurrentCity() throws RemoteException{
		
		LoginblController login = new LoginblController();
		String s = login.getCurrentOptorId();
		
		String string = s.substring(0, 3);
		switch (string) {
		case "025":
			City city = City.NANJING;
			return city;			
		case "010":
			return City.BEIJING;
		case "020":
			return City.GUANGZHOU;
		case "021":
			return City.SHANGHAI;
		default:
			return null;
		}
	}
	
	public static String getCurrentOptorID(String office){
		switch (office) {
		case "北京":
			return "010";
		case "南京":
			return "025";
		case "广州":
			return "020";
		case "上海":
			return "021";
		default:
			return null;
		}
	}
	
	
}
