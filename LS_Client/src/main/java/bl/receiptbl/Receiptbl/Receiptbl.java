package bl.receiptbl.Receiptbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.LogVO;
import bl.goodsbl.Goodsbl;
import bl.logbl.Logbl;
import bl.managementbl.accountbl.Accountbl;
import dataservice.receiptdataservice.ReceiptDataService;
import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class Receiptbl {
	
	private static ReceiptDataService receiptDataService = null;
	private ReceiptClient client = new ReceiptClient();
	private Accountbl accountbl = new Accountbl();
	private Goodsbl goodsbl = new Goodsbl();
	
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
		return CurrentTime.getDate();
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
	
	public ArrayList<ReceiptPO> getAllRep(Rep rep, String office) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().getAllRep(rep, office);
	}
	
	public ReceiptPO getSubmitRep(Rep rep, String office) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException{
		return getReceiptDataService().getSubmitRep(rep, office);
	}
	
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep, String office) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().getRepByDate(date, rep, office);
	}
	
	public ReceiptPO getRepByNum(String num, Rep rep) throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException{
		return getReceiptDataService().getRepByNum(num, rep);
	}
	
	public String createNum(String date, Rep rep, String office) throws NotBoundException, ClassNotFoundException, IOException{
		return getReceiptDataService().createNum(date, rep, office);
	}
	
	public void clearSubmit(Rep rep, String office) throws RemoteException, MalformedURLException, IOException, NotBoundException, ClassNotFoundException{
		getReceiptDataService().clearSubmit(rep, office);
	}
	
	public void clearSave(Rep rep, String office) throws RemoteException, MalformedURLException, IOException, NotBoundException, ClassNotFoundException{
		getReceiptDataService().clearSave(rep, office);
	}
	
	public ArrayList<ReceiptPO> forCheck(Rep rep) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException{
		return getReceiptDataService().forCheck(rep);
	}
	
	public void submitSave(String num, Rep rep) throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException{
		getReceiptDataService().submitSave(num, rep);
	}
	
	public String checkNum(String string, int n, String info){
		if (string.length() < n)
			return info + "长度过短";
		if (string.length() > n)
			return info + "长度过长";
		return "添加成功";
	}
	
	public boolean isTrueOrder(String order){
		try {
			goodsbl.findByListNum(order);
		} catch (GoodsNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
