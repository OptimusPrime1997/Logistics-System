package bl.receiptbl.OutStockRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.OutStockRepblService;
import util.enumData.ResultMessage;
import util.enumData.ShipForm;
import util.enumData.place;

public class OutStockRepController extends ReceiptblController implements OutStockRepblService{
	OutStackRepbl OutStackRepbl = new OutStackRepbl();

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
