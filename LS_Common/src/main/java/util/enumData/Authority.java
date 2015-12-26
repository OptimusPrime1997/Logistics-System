package util.enumData;

//case OVERRIDE_DATA:
//	return "覆盖数据";
public enum Authority {
	MANAGER("01", "总经理"), FINANCIALSTAFF_C("02", "普通财务人员"), BUSSINESSOFFICER(
			"03", "营业厅业务员"), TRANSFERCTROFFICER("04", "中转中心业务员"), WAREHOUSEMAN(
			"05", "仓库管理员"), COURIER("06", "快递员"), DRIVER("07", "司机"), ADMINISTRATOR("08", "管理员"), FINANCIALSTAFF_V(
			"09", "高级财务人员");
	final private String numStr;
	final private String value;
	final public static int PERSON_NUM = 9;

	private Authority(String numStr, String value) {
		this.numStr = numStr;
		this.value = value;
	}

	public String getNumStr() {
		return numStr;
	}

	public String getValue() {

		/*
		 * new MyFrame(panel2); panel2.setFrame(this.frame);
		 */
		return value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Enum#toString() 重构tostring方法
	 */
	@Override
	public String toString() {
		return value;
	}

	public static String value(Authority authority) {
		String result = "";
		switch (authority) {
		case MANAGER:
			result = "01";
			break;
		case FINANCIALSTAFF_C:
			result = "02";
			break;
		case BUSSINESSOFFICER:
			result = "03";
			break;
		case TRANSFERCTROFFICER:
			result = "04";
			break;
		case WAREHOUSEMAN:
			result = "05";
			break;
		case COURIER:
			result = "06";
			break;
		case DRIVER:
			result = "07";
			break;
		case ADMINISTRATOR:
			result = "08";
			break;
		case FINANCIALSTAFF_V:
			result = "09";
			break;
		default:
			break;
		}
		return result;
	}

	public static String toString(Authority authority) {
		if (authority == null) {
			return "";
		}
		String result = "";
		switch (authority) {
		case MANAGER:
			result = "总经理";
			break;
		case FINANCIALSTAFF_C:
			result = "普通财务人员";
			break;
		case BUSSINESSOFFICER:
			result = "营业厅业务员";
			break;
		case TRANSFERCTROFFICER:
			result = "中转中心业务员";
			break;
		case WAREHOUSEMAN:
			result = "仓库管理员";
			break;
		case COURIER:
			result = "快递员";
			break;
		case DRIVER:
			result = "司机";
			break;
		case ADMINISTRATOR:
			result = "管理员";
			break;
		case FINANCIALSTAFF_V:
			result = "高级财务人员";
			break;
		default:
			result = "";
			break;
		}
		return result;
	}

	public static Authority toAuthority(String str) {
		assert (str != null) : ("由于string为空，String to Authority失败");
		assert (str.length() > 0) : ("String 空白，String to Authority失败");
		Authority result = null;
		switch (str) {
		case "总经理":
			result = MANAGER;
			break;
		case "普通财务人员":
			result = FINANCIALSTAFF_C;
			break;
		case "营业厅业务员":
			result = BUSSINESSOFFICER;
			break;
		case "中转中心业务员":
			result = TRANSFERCTROFFICER;
			break;
		case "仓库管理员":
			result = WAREHOUSEMAN;
			break;
		case "快递员":
			result = COURIER;
			break;
		case "司机":
			result = DRIVER;
			break;
		case "管理员":
			result = ADMINISTRATOR;
			break;
		case "高级财务人员":
			result = FINANCIALSTAFF_V;
			break;
		default:
			break;
		}
		return result;
	}

	public static Authority getAuthority(int index) {
		switch (index) {
		case 1:
			return Authority.MANAGER;
		case 2:
			return Authority.FINANCIALSTAFF_C;
		case 3:
			return Authority.BUSSINESSOFFICER;
		case 4:
			return Authority.TRANSFERCTROFFICER;
		case 5:
			return Authority.WAREHOUSEMAN;
		case 6:
			return Authority.COURIER;
		case 7:
			return Authority.DRIVER;
		case 8:
			return Authority.ADMINISTRATOR;
		case 9:
			return Authority.FINANCIALSTAFF_V;
		default:
			return null;
		}

	}
}
