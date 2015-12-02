package util;

import java.text.ParseException;
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
	 * 日期a早于b则返回true
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean ifearlier(String a,String b){
		try {
			Date x=df.parse(a);
			Date y=df.parse(b);
			if(x.before(y)){
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
		
	}
	/**
	 * 返回减一天的日期
	 * @param Cdate
	 * @return
	 */
	public static String minusDate(String Cdate,int t){
		return df.format(new Date(d.getTime()-t*24*3600*1000));
	}
	/**
	 * 返回加一天的日期
	 * @param Cdate
	 * @return
	 */
	public static String addDate(String Cdate,int t){
		return df.format(new Date(d.getTime()+t*24*3600*1000)); 
	}
	
}
