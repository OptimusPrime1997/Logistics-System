package bl.receiptbl.ReceptionRepbl;

import java.util.ArrayList;

import VO.ReceiptVO;
import VO.ReceptionRepVO;
import VO.ShipmentRepVO;
import VO.TransferRepVO;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import util.enumData.Rep;

public class ReceptionRepbl{

	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ShipmentRepVO getShipmentRep(String num){
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getShipmentRep(num);
	}
	
	public TransferRepVO getTransferRep(String num){
		TransferRepbl transfer = new TransferRepbl();
		return transfer.getTransferRep(num);
	}

	public String createNum(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int n) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
		
	}

	public ReceptionRepVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public void submit(ReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReceptionRepVO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceptionRepVO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
