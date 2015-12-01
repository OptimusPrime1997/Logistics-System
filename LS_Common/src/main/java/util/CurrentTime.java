package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	static Date d=new Date();// new Date()为获取当前系统时间
	static SimpleDateFormat df;
	public static String getTime() {
		// 设置日期格式
		df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return df.format(d);
	}
	public static String getDate() {
		// 设置日期格式
		df = new SimpleDateFormat("yyyy/MM/dd");
		return df.format(d);
	}
	/**
	 * 返回减一天的日期
	 * @param Cdate
	 * @return
	 */
	public static String minus(String Cdate,int t){
		return df.format(new Date(d.getTime()-t*24*3600*1000));
	}
}
