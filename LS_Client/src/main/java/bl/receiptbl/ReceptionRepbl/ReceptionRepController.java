package bl.receiptbl.ReceptionRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import VO.ShipmentRepVO;
import VO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class ReceptionRepController extends ReceiptblController implements ReceptionRepblService{
	ReceptionRepbl ReceptionRep = new ReceptionRepbl();

	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.updateShip(rep, num);
	}

	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.getShipmentRep(num);
	}

	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return ReceptionRep.getTransferRep(num);
	}

	@Override
	public String createNum(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReceiptVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(CashRepVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashRepVO> getAllCashRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CashRepVO> getRepBydate(String date) {
		// TODO Auto-generated method stub
		return null;
	}


}
