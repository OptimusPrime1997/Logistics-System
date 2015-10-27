package bl.receiptbl;

import java.util.ArrayList;
import bl.goodsbl.Goodsbl;
import VO.CashRepVO;
import VO.GoodsVO;
import blservice.receiptblservice.CashRepblService;

public class CashRepblImpl extends ReceiptRepblImpl implements CashRepblService{
	public ArrayList<CashRepVO> get() {
		return null;
	}

	@Override
	public String submit(String num, String date, int money, String getCourierNum) {
		// TODO Auto-generated method stub
		ArrayList<GoodsVO> goods = (new Goodsbl()).getGoodsByCourier(getCourierNum);
		submit(num, date, money, getCourierNum, goods);
		return null;
	}

	@Override
	public String submit(String num, String date, int money, String getCourierNum, ArrayList<GoodsVO> goods) {
		// TODO Auto-generated method stub
		return null;
	}

}
