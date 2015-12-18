package bl.receiptbl.DocumentCheckbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import PO.Receipt.ReceiptPO;
import VO.Receipt.CashRepVO;
import VO.Receipt.DeliverRepVO;
import VO.Receipt.GetRepVO;
import VO.Receipt.InStockRepVO;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import VO.Receipt.ShipmentRepVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class DocumentCheckbl{
	Receiptbl receiptbl = new Receiptbl();
	
	public String saveRep(ReceiptVO vo, Rep rep) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector<Object> checkAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CashRepVO> cashCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.CashRep);
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		return null;
	}

	public ArrayList<DeliverRepVO> deliverCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GetRepVO> getCheck() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<InStockRepVO> getInStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OutStockRepVO> getOutStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayRepVO> getPay() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceptionRepVO> getReception() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ShipmentRepVO> getShipment() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ShippingRepVO> getShipping() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransferRepVO> getTransfer() {
		// TODO Auto-generated method stub
		return null;
	}
}
