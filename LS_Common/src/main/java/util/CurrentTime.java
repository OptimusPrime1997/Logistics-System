package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {
	// 设置日期格式
	static SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	// new Date()为获取当前系统时间
	static String currentTime=df.format(new Date());
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
	public static String minusOneDay(String Cdate){
		String date=Cdate;
		int day=Integer.parseInt(date.substring(8,10));
		if(--day>0){
			date=date.substring(0, 8)+day;
		}
		return date;
	}

}
