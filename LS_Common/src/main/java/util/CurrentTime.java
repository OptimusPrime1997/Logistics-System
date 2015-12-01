package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	static Date d=new Date();
	// 设置日期格式
	static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	// new Date()为获取当前系统时间
	static String currentTime=df.format(d);
	public static String getTime() {
		return currentTime;
	}
	public static String getDate() {
		return currentTime.substring(0, 10);
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
