package bl.receiptbl.TransferRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.ConstNotFoundException;
import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import PO.Receipt.TransferRepPO;
import RMIClient.ReceiptClient;
import VO.Receipt.ReceiptVO;
import VO.Receipt.TransferRepVO;
import bl.goodsbl.Goodsbl;
import bl.managementbl.constbl.Constbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.Receiptbl.ReceiptblController;
import dataservice.receiptdataservice.TransferRepDataService;
import util.enumData.City;
import util.enumData.Rep;
import util.enumData.ShipForm;

public class TransferRepbl extends ReceiptblController{
	
	private Receiptbl receiptbl = new Receiptbl();
	private Goodsbl goodsbl = new Goodsbl();
	private Constbl constbl = new Constbl();
	private static TransferRepDataService transferRepDataService = null;
	private ReceiptClient client = new ReceiptClient();
	
	private TransferRepDataService getTransferRepDataService()
			throws MalformedURLException, RemoteException, NotBoundException{
		if(transferRepDataService==null)
			transferRepDataService = client.getTransferRepDataService();
		return transferRepDataService;
	}
	
	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.TransferRep, office);
	}

	public TransferRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.TransferRep);
		return new TransferRepVO((TransferRepPO)receiptPO);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(TransferRepVO.toPO((TransferRepVO) vo), Rep.TransferRep);
	}

	public ArrayList<TransferRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.TransferRep, office);
		return TransferRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<TransferRepVO> getRepByDate(String date, String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.TransferRep, office);
		return TransferRepVO.toArrayVO(receiptPOs);
	}
	
	public boolean isTrueOrder(String order){
		return receiptbl.isTrueOrder(order);
	}
	
	public double getFreightMoney(String depart, String destination, double weight, ShipForm form) 
			throws FileNotFoundException, ClassNotFoundException, ConstNotFoundException, IOException{
		City c1 = City.getCity(depart);
		City c2 = City.getCity(destination);
		return constbl.computeFare(c1, c2, form, weight);
	}
	
	public double getWeightByOrder(String order) throws GoodsNotFound{
		return goodsbl.findByListNum(order).weight;
	}
	
	public ArrayList<TransferRepVO> getMonthRep(String date) 
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException,
			NotBoundException{
		ArrayList<ReceiptPO> receiptPOs = getTransferRepDataService().getMonthRep(date);
		return TransferRepVO.toArrayVO(receiptPOs);
	}
}
