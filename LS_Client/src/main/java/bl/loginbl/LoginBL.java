package bl.loginbl;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import PO.AccountPO;
import bl.managementbl.accountbl.Accountbl;
import blservice.loginblservice.LoginBLService;

public class Loginbl{

	
	public ResultMessage login(String accountNum, String key) {
		// TODO Auto-generated method stub
		Accountbl accountbl=new Accountbl();
		return accountbl.login(accountNum, key);
	}

	
	public Authority loginChoose(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}

}
