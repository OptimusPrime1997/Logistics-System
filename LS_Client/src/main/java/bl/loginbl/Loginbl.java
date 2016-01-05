package bl.loginbl;

import java.io.IOException;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import Exception.NumNotFoundException;
import VO.ManagementVO.AccountVO;
import bl.managementbl.accountbl.Accountbl;

public class Loginbl {
	private static String currentOptorId = "02500106027";
	private static String currentOptorName = "大玉儿";
	private static Authority currentAuthority = Authority.COURIER;
	private String currentOfficeNum="025001";
	private static String ip = "127.0.0.1";

	/**
	 * 得到服务器的ip地址
	 * 
	 * @return
	 */
	public static String getIP() {
		return ip;
	}

	public static void setIP(String inputIP) {
		ip = inputIP;
	}

	public ResultMessage login(String accountNum, String key) {
		currentOptorId = accountNum;
		Accountbl accountbl = new Accountbl();
		ResultMessage r = accountbl.login(accountNum, key);
		AccountVO v = null;
		if (r == ResultMessage.SUCCESS) {
			try {
				v = accountbl.findByAccountNum(accountNum);
				currentOptorName = v.accountName;
				currentAuthority = v.authority;
				currentOfficeNum=v.institutionNum;
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

	public static Authority getCurrentAuthority() {
		return currentAuthority;
	}

	public String getCurrentOfficeNum() {
		// TODO Auto-generated method stub
		return currentOfficeNum;
	}
}
