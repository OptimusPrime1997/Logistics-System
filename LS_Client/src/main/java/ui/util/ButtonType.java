package ui.util;

public enum ButtonType {
	SEARCH,LOGIN,EXIT,BIG,
	/**
	 * 输入库存初始数据
	 */
	STOCK_INPUT,
	STOCK_OUT,
	STOCK_IN,
	STOCK_CHECK,
	STOCK_SHOW,
	STOCK_CHANGE,
	
	/**
	 * 财务人员的
	 */
	FORM_BUSINESS,
	FORM_PROFIT,
	/**
	 * 生成付款单
	 */
	PAY_REP,
	NEW_BANK_ACCOUNT,
	NEW_DISTANCE,
	NEW_SALARY,
	NEW_INSTITUTE,
	/**
	 * 最小化按钮
	 */
	SHRINK,
	/**
	 * 名称查找
	 */
	SEARCH_NAME,
	/**
	 * 编号查找
	 */
	SEARCH_NUMBER,
	/**
	 * 姓名查找
	 */
	SEARCH_PERSON_NAME,
	SEARCH_ACCOUNT,
	
	SUBMIT,
	
	ADD,
	/**
	 * 确定
	 */
	OK,CANCEL,BACK,
	/**
	 * 盘点 小的按钮 是在盘点界面，具体执行盘点的按钮
	 */
	STOCK_SHOW_LITTLE,
	/**
	 * 导出Excel
	 */
	EXCEL_OUT,
	/**
	 * 新订单
	 */
	NEWGOODS,
	/**
	 * 已签收
	 */
	SIGNED,
	/**
	 * 快件到达
	 */
	ARRIVE,
	/**
	 * 中转中心界面上面的 大按钮
	 */
	ARRIVE_BIG,
	CAR_MANAGEMENT,DRIVER_MANAGEMENT,
	/**
	 * 派件
	 */
	DELIVER,
	/**
	 * 发往中转中心/营业厅
	 */
	TO_TRS_CTR_OR_YYT,
	/**
	 * 发往中转中心
	 */
	TO_TRANSFER_CTR,
	/**
	 * 发往营业厅
	 */
	TO_YYT,
	/**
	 * 记账
	 */
	MONEY_IN_RECORD, 
}
