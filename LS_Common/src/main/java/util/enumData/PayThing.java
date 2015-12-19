package util.enumData;

public enum PayThing {
	Refund("退款"),
	StaffSalary("人员工资"), 
	Freight("运费"), 
	Rent("租金"), 
	DriverSalary("司机工资"), 
	CourierSalary("快递员工资"), 
	Bonus("奖金");
	
	private String ChineseName;
	
	private PayThing(String ChineseName){
		this.ChineseName = ChineseName;
	}
	
	public String getChineseName(){
		return ChineseName;
	}
	public static String toFriendlyString(PayThing p){
		switch(p){
		case Refund:return "退款";
		case StaffSalary:return "人员工资"; 
		case Freight:return "运费"; 
		case Rent:return "租金"; 
		case DriverSalary:return "司机工资"; 
		case CourierSalary:return "快递员工资"; 
		case Bonus:return "奖金";
		default:return null;
		}
	}
	public static PayThing getPayThing(String ChineseName){
		switch (ChineseName) {
		case "退款":
			return Refund;
		case "人员工资":
			return StaffSalary;
		case "运费":
			return Freight;
		case "租金":
			return Rent;
		case "司机工资":
			return DriverSalary;
		case "快递员工资":
			return CourierSalary;
		case "奖金":
			return Bonus;
		default:
			return null;
			
		}
	}
}
