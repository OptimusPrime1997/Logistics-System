package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTime {

	public static void main(String[] args) {
		String a="2015-8";
		String b="2015-08";
		System.out.println(CurrentTime.ifsame(a,b));
	}
	static Date d=new Date();// new Date()为获取当前系统时间
	static SimpleDateFormat df;
	public static String getTime() {
//		设置日期格式
		df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(d);
	}
	public static String getDate() {
		// 设置日期格式
		df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(d);
	}
	/**
	 * 日期a早于b则返回true
	 * 
	 * @param a 形如 2015-07-21
	 * @param b
	 * @return
	 */
	public static boolean ifearlier(String a,String b){
		df=new SimpleDateFormat("yyyy-MM-dd");
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
	 * 是否是同一天   是的话返回true
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean ifsame(String a,String b){
		if(!ifearlier(a, b)&&!ifearlier(b, a)){
			return true;
		}else return false;		
	}
	/**
	 * 返回减t天的日期
	 * @param Cdate
	 * @return
	 */
	public static String minusDate(String Cdate,int t){
		String ans="";
		df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date x=df.parse(Cdate);
			ans=df.format(new Date(x.getTime()-t*24*3600*1000));
		} catch (ParseException e) {
		}
		return ans;
	}
	/**
	 * 返回加t天的日期
	 * @param Cdate
	 * @return
	 */
	public static String addDate(String Cdate,int t){
		String ans="";
		df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date x=df.parse(Cdate);
			ans=df.format(new Date(x.getTime()+t*24*3600*1000));
		} catch (ParseException e) {
		}
		return ans;
	}
	
}
