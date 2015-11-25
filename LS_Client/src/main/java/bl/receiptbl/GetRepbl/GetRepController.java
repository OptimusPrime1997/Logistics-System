package bl.receiptbl.GetRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import VO.ShipmentRepVO;
import VO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.GetRepblService;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class GetRepController extends ReceiptblController implements GetRepblService{
	GetRepbl GetRep = new GetRepbl();

	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return GetRep.updateShip(rep, num);
	}

	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return GetRep.getShipmentRep(num);
	}

	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return GetRep.getShippingRep(num);
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
