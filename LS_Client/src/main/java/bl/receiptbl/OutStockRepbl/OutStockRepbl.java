package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import bl.stockbl.StockController;
import dataservice.receiptdataservice.OutStockRepDataService;
import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.Rep;

public class OutStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private ShippingRepbl shippingRepbl = new ShippingRepbl();
	private TransferRepbl transferRepbl = new TransferRepbl();
	private StockController stockController = new StockController();
	private LoginblController login = new LoginblController();
	private ReceiptClient client = new ReceiptClient();
	
	private OutStockRepDataService getOutStockRepDataService()
			throws MalformedURLException, RemoteException, NotBoundException{
		return client.getOutStockRepDataService();
	}

	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		return receiptbl.createNum(date, Rep.OutStockRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(OutStockRepVO.toPO((OutStockRepVO)vo), Rep.OutStockRep);
		stockController.update((OutStockRepVO)vo);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.OUTSTOCK_MANAGEMENT, operatorID, CurrentTime.getTime());
	}

	public ArrayList<OutStockRepVO> getRepByDate(String date, String office) throws ClassNotFoundException, 
	NotBoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.OutStockRep, office);
		if(receiptPOs==null)
			return null;
		return OutStockRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<OutStockRepVO> getAllRep(String office) throws ClassNotFoundException, NotBoundException, 
	IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.OutStockRep, office);
		if(receiptPOs==null)
			return null;
		return OutStockRepVO.toArrayVO(receiptPOs);
	}
	
	public ShippingRepVO getShippingRepVO(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		return shippingRepbl.getRepByNum(num);
	}

	public TransferRepVO getTransferRepVO(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		return transferRepbl.getRepByNum(num);
	}
	
	public ArrayList<OutStockRepVO> getAllRepByDate(String date) 
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
			NotBoundException{
		ArrayList<ReceiptPO> receiptPOs = getOutStockRepDataService().getAllRepByDate(date);
		if(receiptPOs==null)
			return null;
		return OutStockRepVO.toArrayVO(receiptPOs);
	}
}
