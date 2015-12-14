package util.enumData;

import javax.sql.rowset.CachedRowSet;

public enum LogType {
	/**
	 * 所有操作
	 */
	ALL(1, "所有操作"),
	/**
	 * 派件
	 */
	DELIVER(2, "派件"),

	/**
	 * 司机管理
	 */
	DRIVER_MANAGEMENT(3, "司机管理"),
	/**
	 * 车辆管理
	 */
	CAR_MANAGEMENT(4, "车辆管理"),
	/**
	 * 入库管理
	 */
	INSTOCK_MANAGEMENT(5, "入库管理"),
	/**
	 * 库存管理
	 */
	STOCK_MANAGEMENT(6, "库存管理"),
	/**
	 * 出库管理
	 */
	OUTSTOCK_MANAGEMENT(7, "出库管理"),
	/**
	 * 权限管理
	 */
	AUTHORITY_MANAGEMENT(8, "权限管理"),
	/**
	 * 用户账户管理
	 */
	USER_ACCOUNT_MANAGEMENT(9, "用户账户管理"),
	/**
	 * 创建订单
	 */
	ADD_A_GOODS(10, "创建订单"),
	/**
	 * 签收订单
	 */
	END_A_GOODS(11, "签收订单"),
	/**
	 * 中转中心装车管理
	 */
	TRANSFER_CTR_SHIP_MANAGEMENT(12, "中转中心装车管理"),
	/**
	 * 中转中心接收
	 */
	TRANSFER_CTR_RECEPTION(13, "中转中心接收"),
	/**
	 * 收支管理
	 */
	MONEY_IN_AND_OUT_MANAGEMENT(14, "收支管理"),
	/**
	 * 银行账户管理
	 */
	BANKACCOUNT_MANAGEMENT(15, "银行账户管理"),
	/**
	 * 查看报表
	 */
	CHECK_FORM(16, "查看报表"),
	/**
	 * 查看银行账户
	 */
	CHECK_BANKACOUNT(17, "查看银行账户"),
	/**
	 * 人员机构管理
	 */
	PERSONNEL_INSTITUTION_MANAGEMENT(18, "人员机构管理"),
	/**
	 * 审批单据
	 */
	DOCUMENT_CHECK(19, "审批单据"),

	/**
	 * 常量制定
	 */
	DECISION_CONST(20, "常量制定"),
	/**
	 * 薪水制定
	 */
	DECISION_SALARYPOLICY(21, "薪水制定");
	final private int index;
	final private String value;

	private LogType(int index, String value) {
		this.index = index;
		this.value = value;
	}

	/*
	 * (non-Javadoc) override toString
	 * 
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return value;
	}

	public static LogType toLogType(int index) {
		try {
			assert (index >= 1 && index <= 21) : ("LogType index out of bounds");
		} catch (AssertionError e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		switch (index) {
		case 1:
			return LogType.ALL;
		case 2:
			return LogType.DELIVER;
		case 3:
			return LogType.DRIVER_MANAGEMENT;
		case 4:
			return LogType.CAR_MANAGEMENT;
		case 5:
			return LogType.INSTOCK_MANAGEMENT;
		case 6:
			return LogType.STOCK_MANAGEMENT;
		case 7:
			return LogType.OUTSTOCK_MANAGEMENT;
		case 8:
			return LogType.AUTHORITY_MANAGEMENT;
		case 9:
			return LogType.USER_ACCOUNT_MANAGEMENT;
		case 10:
			return LogType.ADD_A_GOODS;
		case 11:
			return LogType.END_A_GOODS;
		case 12:
			return LogType.TRANSFER_CTR_SHIP_MANAGEMENT;
		case 13:
			return LogType.TRANSFER_CTR_RECEPTION;
		case 14:
			return LogType.MONEY_IN_AND_OUT_MANAGEMENT;
		case 15:
			return LogType.BANKACCOUNT_MANAGEMENT;
		case 16:
			return LogType.CHECK_FORM;
		case 17:
			return LogType.CHECK_BANKACOUNT;
		case 18:
			return LogType.PERSONNEL_INSTITUTION_MANAGEMENT;
		case 19:
			return LogType.DOCUMENT_CHECK;
		case 20:
			return LogType.DECISION_CONST;
		case 21:
			return LogType.DECISION_SALARYPOLICY;
		default:
			return null;
		}
	}

}
