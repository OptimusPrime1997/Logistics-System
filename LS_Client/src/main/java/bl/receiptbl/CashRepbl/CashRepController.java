package bl.receiptbl.CashRepbl;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.CashRepblService;
import util.enumData.ResultMessage;

public class CashRepController extends ReceiptController implements CashRepblService{
	private CashRepbl CashRep = new CashRepbl();

	public ResultMessage submit(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods) {
		// TODO Auto-generated method stub
		return CashRep.submit(num, date, money, getCourierNum, goods);
	}

	public ArrayList<GoodsVO> getGoods(String courierNum) {
		// TODO Auto-generated method stub
		return CashRep.getGoods(courierNum);
	}

	public String getCourierName(String courierNum) {
		// TODO Auto-generated method stub
		return CashRep.getCourierName(courierNum);
	}

	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		// TODO Auto-generated method stub
		return CashRep.getMoneySum(arrGoods);
	}
	
}
