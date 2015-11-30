package bl.receiptbl.Receiptbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import PO.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.LogVO;
import bl.logbl.Logbl;
import dataservice.receiptdataservice.ReceiptDataService;
import util.enumData.LogType;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class Receiptbl {
	
	private static ReceiptDataService receiptDataService = null;
	ReceiptClient client = new ReceiptClient();
	
	public ReceiptDataService getReceiptDataService() throws RemoteException, MalformedURLException, NotBoundException{
		if(receiptDataService==null)
			receiptDataService = client.getReceiptDataService();
		return receiptDataService;
	}
	
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
	
	public void submit(ReceiptPO po, Rep rep) throws NotBoundException, IOException{
		getReceiptDataService().submit(po, rep);
	}
	
	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().getAllRep(rep);
	}
	
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().getRepByDate(date, rep);
	}
	
	public ReceiptPO getRepByNum(String num, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().getRepByNum(num, rep);
	}
	
	public void delete(int n, Rep rep) throws ClassNotFoundException, IOException, NotBoundException{
		 getReceiptDataService().delete(n, rep);
	}
	
	public void delete(String num, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		 getReceiptDataService().delete(num, rep);
	}
	
	public String createNum(String date, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().createNum(date, rep);
	}
}
