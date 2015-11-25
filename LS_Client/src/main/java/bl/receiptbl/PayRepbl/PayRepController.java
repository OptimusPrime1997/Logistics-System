package bl.receiptbl.PayRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PayRepblService;
import util.enumData.ResultMessage;

public class PayRepController extends ReceiptblController implements PayRepblService{
	PayRepbl PayRep = new PayRepbl();

	public ArrayList<ReceiptVO> forPay() {
		// TODO Auto-generated method stub
		return PayRep.forPay();
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
