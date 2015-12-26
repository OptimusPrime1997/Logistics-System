package Exception;

public class ExceptionPrint {
	public static String print(Exception e) {
		switch (e.getClass().getSimpleName()) {
		case ("RemoteException"):
			return "网络故障";
		case ("MalformedURLException"):
			return "网络故障";
		case ("NotBoundException"):
			return "网络故障";
		case ("ClassNotFoundException"):
			return "网络故障";
		case ("IOException"):
			return "文件读取错误";
		case ("NameNotFoundException"):
			return "名字未找到";
		case ("NumNotFoundException"):
			return "编号未找到";
		case ("ExistException"):
			return "已存在";
		case ("GoodsNotFound"):
			return "不存在该订单";
		case ("SalaryPolicyNotFoundException"):
			return "薪水策略未制定";
		case ("ConstNotFoundException"):
			return "策略未制定";
		default:
			return null;
		}
	}
}
