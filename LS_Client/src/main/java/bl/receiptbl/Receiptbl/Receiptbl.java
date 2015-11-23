package bl.receiptbl.Receiptbl;

import java.util.Calendar;

import PO.ReceiptPO;
import dataservice.receiptdataservice.ReceiptDataService;
import util.enumData.*;

public class Receiptbl{

	public ResultMessage addLog(String operationName, String operatorID, String time){
//		LogVO log = new LogVO(operationName, operatorID, time);
//		Logbl logbl = new Logbl();
//		logbl.add(log);
		return null;
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
