package bl.receiptbl.DeliverRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.DeliverRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.DeliverRepblService;
import util.enumData.ResultMessage;

public class DeliverController extends ReceiptblController implements DeliverRepblService{
	DeliverRepbl DeliverRep = new DeliverRepbl();

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

	@Override
	public ArrayList<DeliverRepVO> forPay() {
		// TODO Auto-generated method stub
		return null;
	}

}
