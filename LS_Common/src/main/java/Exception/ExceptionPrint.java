package Exception;

public class ExceptionPrint {
	public static String print(Exception e){
		switch(e.getClass().getSimpleName()){
			case ("NameNotFoundException"):
				return "名字未找到";
			case ("RemoteException"):
				return "网络故障";
			case ("MalformedURLException"):
				return "网络故障";
			case ("NotBoundException"):
				return "网络故障";
			case("ExistException"):
				return "已存在";
			case("GoodsNotFound"):
				return "不存在该订单";
			case("AddMoneyInBankException"):
				return "账户余额增加错误";
			default:
				return null;
		}
	}
}
