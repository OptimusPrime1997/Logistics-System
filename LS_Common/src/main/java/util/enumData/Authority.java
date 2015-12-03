package util.enumData;

public enum Authority {
	MANAGER, FINANCIALSTAFF_V, FINANCIALSTAFF_C, COURIER, ADMINISTRATOR, WAREHOUSEMAN, BUSSINESSOFFICER, TRANSFERCTROFFICER, DRIVER;
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
		case FINANCIALSTAFF_V:
			result = "08";
			break;
		case ADMINISTRATOR:
			result = "09";
			break;
		default:
			break;
		}
		return result;
	}
	public static String toString(Authority authority){
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
		case FINANCIALSTAFF_V:
			result = "高级财务人员";
			break;
		case ADMINISTRATOR:
			result = "管理员";
			break;
		default:
			break;
		}
		return result;
	}
}
