package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.GoodsNotFound;
import PO.Receipt.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.stockbl.StockDivisionbl;
import dataservice.receiptdataservice.InStockRepDataService;
import util.enumData.City;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class InStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private StockDivisionbl stockDivisionbl = new StockDivisionbl();
	private Goodsbl goodsbl = new Goodsbl();
	private ReceiptClient client = new ReceiptClient();
	
	private InStockRepDataService getInStockRepDataService()
			throws MalformedURLException, RemoteException, NotBoundException{
		return client.getInStockRepDataService();
	}

	public String createNum(String date, String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.InStockRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(InStockRepVO.toPO((InStockRepVO) vo), Rep.InStockRep);
	}

	public ArrayList<InStockRepVO> getRepByDate(String date, String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.InStockRep, office);
		if(receiptPOs==null)
			return null;
		return InStockRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<InStockRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException,
	IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.InStockRep, office);
		return InStockRepVO.toArrayVO(receiptPOs);
	}
	
	public String getCity(String order) throws GoodsNotFound{
		return goodsbl.findByListNum(order).destinationCity;
	}
	
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException{ 
		return stockDivisionbl.getAvailableDivision(des);
	}
	
	public ResultMessage delete(String listNum) 
			throws RemoteException, MalformedURLException, NotBoundException{
		return stockDivisionbl.delete(listNum);
	}
	
	public ResultMessage update(InStockRepVO vo) 
			throws MalformedURLException, RemoteException, NotBoundException{
		return stockDivisionbl.update(vo);
	}
	
	public ArrayList<InStockRepVO> getAllRepByDate(String date) 
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
			NotBoundException{
		return InStockRepVO.toArrayVO(getInStockRepDataService().getAllRepByDate(date));
	}

}
