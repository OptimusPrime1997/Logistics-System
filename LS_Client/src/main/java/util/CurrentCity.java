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
			return City.NANJING;			
		case "010":
			return City.BEIJING;
		case "020":
			return City.GUANGZHOU;
		case "021":
			return City.SHANGHAI;

		default:
			break;
		}
		
		return null;
	}
	
	
}
