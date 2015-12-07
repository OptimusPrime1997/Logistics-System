package bl.receiptbl.Receiptbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import PO.ReceiptPO.ReceiptPO;
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
		m=cal.get(Calendar.MONTH)+1;   
		d=cal.get(Calendar.DATE);  
		return y+"-"+m+"-"+d;
	}
	
	public String getDateInNum(String string){
		String[] strings = string.split("-");
		if(strings[1].length()==1)
			strings[1] = "0"+strings[1];
		if(strings[2].length()==1)
			strings[2] = "0"+strings[2];
		return strings[0]+strings[1]+strings[2];
	}
	
	public void submit(ReceiptPO po, Rep rep) throws NotBoundException, IOException{
		getReceiptDataService().submit(po, rep);
	}
	
	public void save(ReceiptPO po, Rep rep) throws RemoteException, MalformedURLException, IOException, NotBoundException{
		getReceiptDataService().save(po, rep);
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
	
	public void clearSubmit(Rep rep) throws RemoteException, MalformedURLException, IOException, NotBoundException{
		getReceiptDataService().clearSubmit(rep);
	}
	
	public void clearSave(Rep rep) throws RemoteException, MalformedURLException, IOException, NotBoundException{
		getReceiptDataService().clearSave(rep);
	}
	
	public ResultMessage checkNum(String string, int n){
		if (string.length() < n)
			return ResultMessage.REPNUM_LENGTH_LACKING;
		if (string.length() > n)
			return ResultMessage.REPNUM_LENGTH_OVER;
		for(int i = 0;i<n;i++){
			if(string.charAt(i)<'0'||string.charAt(i)>'9')
				return ResultMessage.REPNUM_NOT_ALL_NUM;
		}
		return ResultMessage.ADD_SUCCESS;
	}
}
