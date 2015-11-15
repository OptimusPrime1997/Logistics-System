package bl.receiptbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import VO.TransferRepVO;
import blservice.receiptblservice.ReceptionRepblService;
import state.Rep;
import state.*;

public class ReceptionRepblImpl extends ReceiptblImpl implements ReceptionRepblService{

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ShipmentRepVO getShipmentRep(String num){
		ShipmentRepblImpl shipment = new ShipmentRepblImpl();
		return shipment.getShipmentRep(num);
	}
	
	public TransferRepVO getTransferRep(String num){
		TransferRepblImpl transfer = new TransferRepblImpl();
		return transfer.getTransferRep(num);
	}

	@Override
	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}

}
