package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.OutStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import bl.stockbl.StockController;
import ui.receiptui.ReceiptDetailUI.Shipping;
import util.enumData.Rep;

public class OutStockRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private ShippingRepbl shippingRepbl = new ShippingRepbl();
	private TransferRepbl transferRepbl = new TransferRepbl();
	private StockController stockController = new StockController();

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

	public Vector<Object> initTable(Rep shipRep, String shipNum) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> orders = new ArrayList<String>();
		if(shipRep==Rep.ShippingRep)
			orders = shippingRepbl.getRepByNum(shipNum).goods;
		else
			orders = transferRepbl.getRepByNum(shipNum).goods;
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < orders.size();i++){
			data.add(orders.get(i));
		}
		return data;
	}

}
