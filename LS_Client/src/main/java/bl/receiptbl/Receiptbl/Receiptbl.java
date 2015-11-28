package bl.receiptbl.Receiptbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import PO.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.CashRepVO;
import VO.LogVO;
import VO.ReceiptVO;
import bl.logbl.Logbl;
import dataservice.receiptdataservice.CashRepDataService;
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
	
	public ResultMessage submit(ReceiptPO po, Rep rep) throws NotBoundException, IOException{
		return getReceiptDataService().submit(po, rep);
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
	
	public ResultMessage delete(int n, Rep rep) throws ClassNotFoundException, IOException, NotBoundException{
		return getReceiptDataService().delete(n, rep);
	}
	
	public ResultMessage delete(String num, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().delete(num, rep);
	}
	
	public String createNum(String date, Rep rep) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().createNum(date, rep);
	}
}
