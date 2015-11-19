package bl.receiptbl.ReceptionRepbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import util.enumData.Rep;
import util.enumData.goodsState;
import util.enumData.place;

public class ReceptionRepbl extends Receiptbl{

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

	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

}
