package bl.loginbl;

import java.rmi.RemoteException;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import blservice.loginblservice.LoginBLService;

public class LoginblController implements LoginBLService {
	Loginbl loginbl = new Loginbl();

	public ResultMessage login(String accountNum, String key)
			throws RemoteException {
		return loginbl.login(accountNum, key);
	}

	public Authority loginChoose(String accountNum) throws RemoteException {
		return loginbl.loginChoose(accountNum);
	}

	@Override
	public String getCurrentOptorId() throws RemoteException {
		return loginbl.getCurrentOptorId();
	}

	@Override
	public String getCurrentName() throws RemoteException {
		return loginbl.getCurrentOptorName();
	}

	@Override
	public Authority getCurrentAuthority() throws RemoteException {
		return loginbl.getCurrentAuthority();
	}

	public String getCurrentOfficeNum() throws RemoteException {
		// TODO Auto-generated method stub
		return loginbl.getCurrentOfficeNum();
	}
	

}
