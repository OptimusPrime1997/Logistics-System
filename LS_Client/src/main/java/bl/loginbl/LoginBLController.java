package bl.loginbl;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import blservice.loginblservice.LoginBLService;

public class LoginblController implements LoginBLService{
	Loginbl loginbl=new Loginbl();
	public ResultMessage login(String accountNum, String key) {
		// TODO Auto-generated method stub
		return loginbl.login(accountNum,key);
	}

	public Authority loginChoose(String accountNum) {
		// TODO Auto-generated method stub
		return loginbl.loginChoose(accountNum);
	}


}
