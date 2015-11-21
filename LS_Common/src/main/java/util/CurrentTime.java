package util;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CurrentTime {
	public static String getTime(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
}
