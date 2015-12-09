package ui.util;

import util.enumData.LogType;

public class StrToLogType {
	public static LogType strToLogTye(String str){
		switch(str){
		case "薪水制定":
			return LogType.DECISION_SALARYPOLICY;
		case "常量制定":
			return LogType.DECISION_CONST;
		case "审批单据":
			return LogType.DOCUMENT_CHECK;
		case "用户账户管理":
			return LogType.USER_ACCOUNT_MANAGEMENT;
		case "银行账户管理":
			return LogType.BANKACCOUNT_MANAGEMENT;
		case "创建订单":
				return LogType.ADD_A_GOODS;
		case "司机管理":
		        return LogType.DRIVER_MANAGEMENT;
		case "车辆管理":
			return LogType.CAR_MANAGEMENT;
		case "人员机构管理":
			return LogType.PERSONNEL_INSTITUTION_MANAGEMENT;
		case "权限管理":
			return LogType.AUTHORITY_MANAGEMENT;
		case "查看报表":
			return LogType.CHECK_FORM;
		case "派件":
			return LogType.DELIVER;
		case "签收订单":
			return LogType.END_A_GOODS;
		default:
				return LogType.ALL;
		}
	}
}
