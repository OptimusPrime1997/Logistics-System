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
		//TODO
		
		return null;
	}
	
}
