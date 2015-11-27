package bl.receiptbl.Receiptbl;

import java.util.Calendar;

import VO.LogVO;
import bl.logbl.Logbl;
import util.enumData.LogType;
import util.enumData.ResultMessage;

public class Receiptbl {
	public ResultMessage addLog(LogType operationName, String operatorID, String time){
		LogVO log = new LogVO(operationName, operatorID, time);
		Logbl logbl = new Logbl();
		return logbl.add(log);
	}
	
	public String getDate(){
		int y,m,d;
		Calendar cal=Calendar.getInstance();   
		y=cal.get(Calendar.YEAR);   
		m=cal.get(Calendar.MONTH);   
		d=cal.get(Calendar.DATE);  
		return y+"-"+m+"-"+d;
	}
}
