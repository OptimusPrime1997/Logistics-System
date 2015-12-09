package util.enumData;

public enum Rep {
	ShipmentRep("营业厅装车单"),
	GetRep("营业厅到达单"),
	DeliverRep("派件单"),
	InStockRep("入库单"),
	OutStockRep("出库单"),
	ShippingRep("中转中心装车单"),
	ReceptionRep("中转中心到达单"),
	TransferRep("中转单"),
	CashRep("收款单"),
	PayRep("付款单"),
	PayRepBonus("奖金付款单"),
	PayRepCourierSalary("快递员付款单"),
	PayRepDriverSalary("司机付款单"),
	PayRepFreight("运费付款单"),
	PayRepRefund("退款付款单"),
	PayRepRent("租金付款单"),
	PayRepStaffSalary("工资付款单");
	
	private String ChineseName;
	
	private Rep(String ChineseName){
		this.ChineseName = ChineseName;
	}
	
	public String getChineseName(){
		return ChineseName;
	}
	
	public static Rep getRep(String ChineseName){
		switch (ChineseName) {
		case "营业厅装车单":
			return ShipmentRep;
		case "营业厅到达单":
			return GetRep;
		case "派件单":
			return DeliverRep;
		case "入库单":
			return InStockRep;
		case "出库单":
			return OutStockRep;
		case "中转中心装车单":
			return ShippingRep;
		case "中转中心到达单":
			return ReceptionRep;
		case "中转单":
			return TransferRep;
		case "收款单":
			return CashRep;
		case "付款单":
			return PayRep;
		case "奖金付款单":
			return PayRepBonus;
		case "快递员付款单":
			return PayRepCourierSalary;
		case "司机付款单":
			return PayRepDriverSalary;
		case "运费付款单":
			return PayRepFreight;
		case "退款付款单":
			return PayRepRefund;
		case "租金付款单":
			return PayRepRent;
		case "工资付款单":
			return PayRepStaffSalary;
		default:
			return null;
		}
	}
}
