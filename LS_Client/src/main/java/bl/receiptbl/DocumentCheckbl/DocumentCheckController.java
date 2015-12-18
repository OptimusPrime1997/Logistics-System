package bl.receiptbl.DocumentCheckbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

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
import blservice.receiptblservice.DocumentCheckblService;
import util.enumData.Rep;

public class DocumentCheckController implements DocumentCheckblService{
	DocumentCheckbl documentCheckbl = new DocumentCheckbl();

	@Override
	public String saveRep(ReceiptVO vo, Rep rep) {
		// TODO Auto-generated method stub
		return documentCheckbl.saveRep(vo, rep);
	}

	@Override
	public Vector<Object> checkAllRep() {
		// TODO Auto-generated method stub
		return documentCheckbl.checkAllRep();
	}

	@Override
	public ArrayList<CashRepVO> cashCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.cashCheck();
	}

	@Override
	public ArrayList<DeliverRepVO> deliverCheck() {
		// TODO Auto-generated method stub
		return documentCheckbl.deliverCheck();
	}

	@Override
	public ArrayList<GetRepVO> getCheck() {
		// TODO Auto-generated method stub
		return documentCheckbl.getCheck();
	}

	@Override
	public ArrayList<InStockRepVO> getInStock() {
		// TODO Auto-generated method stub
		return documentCheckbl.getInStock();
	}

	@Override
	public ArrayList<OutStockRepVO> getOutStock() {
		// TODO Auto-generated method stub
		return documentCheckbl.getOutStock();
	}

	@Override
	public ArrayList<PayRepVO> getPay() {
		// TODO Auto-generated method stub
		return documentCheckbl.getPay();
	}

	@Override
	public ArrayList<ReceptionRepVO> getReception() {
		// TODO Auto-generated method stub
		return documentCheckbl.getReception();
	}

	@Override
	public ArrayList<ShipmentRepVO> getShipment() {
		// TODO Auto-generated method stub
		return documentCheckbl.getShipment();
	}

	@Override
	public ArrayList<ShippingRepVO> getShipping() {
		// TODO Auto-generated method stub
		return documentCheckbl.getShipping();
	}

	@Override
	public ArrayList<TransferRepVO> getTransfer() {
		// TODO Auto-generated method stub
		return documentCheckbl.getTransfer();
	}

}
