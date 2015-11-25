package bl.receiptbl.InStockRepbl;

import java.util.ArrayList;

import VO.CashRepVO;
import VO.InStockRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.InStockRepblService;
import util.enumData.ResultMessage;

public class InStockRepController extends ReceiptblController implements InStockRepblService{
	InStockRepbl InStockRep = new InStockRepbl();

	public InStockRepVO update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return InStockRep.update(num, listNum, area, loc);
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

	@Override
	public int[] getTwoPosition(String destination) {
		// TODO Auto-generated method stub
		return null;
	}
}
