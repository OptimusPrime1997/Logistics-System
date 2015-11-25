package bl.receiptbl.ShippingRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import VO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShippingRepblService;
import util.enumData.ResultMessage;

public class ShippingRepController extends ReceiptblController implements ShippingRepblService{
	ShippingRepbl ShippingRep = new ShippingRepbl();

	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return ShippingRep.getShippingRep(num);
	}

	public ArrayList<ShippingRepVO> forpay() {
		// TODO Auto-generated method stub
		return ShippingRep.forpay();
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
