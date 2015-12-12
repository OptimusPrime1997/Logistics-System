package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.stockbl.StockDivisionbl;
import util.enumData.City;
import util.enumData.Rep;

public class InStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private StockDivisionbl stockDivisionbl = new StockDivisionbl();

	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.InStockRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(InStockRepVO.toPO((InStockRepVO) vo), Rep.InStockRep);
	}

	public ArrayList<InStockRepVO> getRepByDate(String date, String office) throws ClassNotFoundException, 
	NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.InStockRep, office);
		if(receiptPOs==null)
			return null;
		return InStockRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<InStockRepVO> getAllRep(String office) throws ClassNotFoundException, NotBoundException,
	IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.InStockRep, office);
		return InStockRepVO.toArrayVO(receiptPOs);
	}
	
	public ArrayList<StockDivisionVO> getBlock(City destination) throws NotBoundException, IOException{
		return stockDivisionbl.getBlock(destination);
	}
	
	public String getCity(String order){
		
	}

}
