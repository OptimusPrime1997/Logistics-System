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
import VO.Receipt.InStockRepVO;
import VO.Receipt.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.stockbl.Stock;
import bl.stockbl.StockController;
import bl.stockbl.StockDivisionbl;
import dataservice.receiptdataservice.InStockRepDataService;
import util.CurrentTime;
import util.enumData.City;
import util.enumData.LogType;
import util.enumData.Rep;

public class InStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private StockDivisionbl stockDivisionbl = new StockDivisionbl();
	private Stock stock = new Stock();
	private Goodsbl goodsbl = new Goodsbl();
	private LoginblController login = new LoginblController();
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
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.INSTOCK_MANAGEMENT, operatorID, CurrentTime.getTime());
		
	}

	public ArrayList<InStockRepVO> getRepByDate(String date, String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.InStockRep, office);
		return InStockRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<InStockRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
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
	
	public void delete(String listNum) 
			throws NotBoundException, ClassNotFoundException, IOException{
		stockDivisionbl.delete(listNum);
		stock.delete(listNum);
	}
	
	public void update(InStockRepVO vo) 
			throws MalformedURLException, RemoteException, NotBoundException{
		stockDivisionbl.update(vo);
		stock.update(vo);
	}
	
	public ArrayList<InStockRepVO> getAllRepByDate(String date) 
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
			NotBoundException{
		ArrayList<ReceiptPO> receiptPOs = getInStockRepDataService().getAllRepByDate(date);
		return InStockRepVO.toArrayVO(receiptPOs);
	}
	
	public ArrayList<Integer> checkOver(int block) throws NotBoundException, IOException{
		return stockDivisionbl.getOverBlock(block);
	}
}
