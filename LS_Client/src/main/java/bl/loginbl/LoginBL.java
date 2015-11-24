package bl.loginbl;


import util.enumData.Authority;
import util.enumData.ResultMessage;
import bl.logbl.Logbl;
import bl.managementbl.accountbl.Accountbl;

public class LoginBL {
	private static String currentOptorId;
	
	public ResultMessage login(String accountNum, String key) {
		// TODO Auto-generated method stub
		Accountbl accountbl = new Accountbl();
		return accountbl.login(accountNum, key);
	}

	public Authority loginChoose(String accountNum) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(accountNum.charAt(4) + "");
		currentOptorId=accountNum;
		switch (num) {
		case 1:return Authority.BUSSINESSOFFICER;
		case 2:return Authority.WAREHOUSEMAN;
		case 3:return Authority.ADMINISTRATOR;
		case 4:return Authority.COURIER;
		case 5:return Authority.TRANSFERCTROFFICER;
		case 6:return Authority.FINANCIALSTAFF_C;
		case 7:return Authority.MANAGER;
		case 8:return Authority.FINANCIALSTAFF_V;
		default:return null;
		}
	}

	public static String getCurrentOptorId() {
		return currentOptorId;
	}
}
