package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import util.enumData.Rep;

public class ReceptionRepbl{
	
	Receiptbl receiptbl = new Receiptbl();

	public ShipmentRepVO getShipmentRep(String num){
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getShipmentRep(num);
	}
	
	public TransferRepVO getTransferRep(String num){
		TransferRepbl transfer = new TransferRepbl();
		return transfer.getTransferRep(num);
	}

	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ReceptionRep);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ArriveRepVO.toPO((ArriveRepVO) vo), Rep.ReceptionRep);
	}

	public ArrayList<ArriveRepVO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

}
