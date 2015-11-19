package bl.receiptbl.ReceptionRepbl;

import java.util.ArrayList;

import VO.ShipmentRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.Rep;
import util.enumData.goodsState;
import util.enumData.place;

public class ReceptionRepController extends ReceiptController implements ReceptionRepblService{
	ReceptionRepbl ReceptionRep = new ReceptionRepbl();

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.updateShip(rep, num);
	}

	@Override
	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return ReceptionRep.submit(num, date, place, shipNum, state, goods);
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num){
		return ReceptionRep.getShipmentRep(num);
	}
	
	@Override
	public TransferRepVO getTransferRep(String num){
		return ReceptionRep.getTransferRep(num);
	}

}
