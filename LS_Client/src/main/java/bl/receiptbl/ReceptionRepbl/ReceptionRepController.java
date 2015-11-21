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

	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.updateShip(rep, num);
	}

	public String submit(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return ReceptionRep.submit(num, date, place, shipNum, state, goods);
	}

	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.getShipmentRep(num);
	}

	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.getTransferRep(num);
	}


}
