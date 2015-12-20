package bl.loginbl;

import java.io.IOException;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import bl.managementbl.accountbl.Accountbl;

public class Loginbl {
	private static String currentOptorId = "02500106027";
	private static String currentOptorName = "李四";

	public ResultMessage login(String accountNum, String key) {
		currentOptorId = accountNum;
		Accountbl accountbl = new Accountbl();
		ResultMessage r = accountbl.login(accountNum, key);
		if (r == ResultMessage.SUCCESS) {
			try {
				currentOptorName = accountbl.findByAccountNum(accountNum).accountName;
			} catch (ClassNotFoundException | NumNotFoundException
					| IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return r;
	}

	public Authority loginChoose(String accountNum) {
		// TODO Auto-generated method stub
		int num = Integer.parseInt(accountNum.charAt(4) + "");
		currentOptorId = accountNum;
		switch (num) {
		case 1:
			return Authority.BUSSINESSOFFICER;
		case 2:
			return Authority.WAREHOUSEMAN;
		case 3:
			return Authority.ADMINISTRATOR;
		case 4:
			return Authority.COURIER;
		case 5:
			return Authority.TRANSFERCTROFFICER;
		case 6:
			return Authority.FINANCIALSTAFF_C;
		case 7:
			return Authority.MANAGER;
		case 8:
			return Authority.FINANCIALSTAFF_V;
		default:
			return null;
		}
	}

	public static String getCurrentOptorId() {
		return currentOptorId;
	}

	public static String getCurrentOptorName() {
		return currentOptorName;
	}
}
