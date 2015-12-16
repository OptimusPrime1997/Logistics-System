package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import RMIClient.ReceiptClient;
import VO.ReceiptVO.OutStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import bl.stockbl.StockController;
import dataservice.receiptdataservice.OutStockRepDataService;
import util.enumData.Rep;

public class OutStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private ShippingRepbl shippingRepbl = new ShippingRepbl();
	private TransferRepbl transferRepbl = new TransferRepbl();
	private StockController stockController = new StockController();
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
		return OutStockRepVO.toArrayVO(getOutStockRepDataService().getAllRepByDate(date));
	}
}
