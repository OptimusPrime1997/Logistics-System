package bl.receiptbl;

import java.util.ArrayList;
import PO.CashRepPO;
import bl.goodsbl.Goodsbl;
import VO.CashRepVO;
import VO.GoodsVO;
import blservice.receiptblservice.CashRepblService;

public class CashRepblImpl extends ReceiptblImpl implements CashRepblService{
	public ArrayList<CashRepVO> get() {
		return null;
	}

	@Override
	public String submit(String num, String date, double money, String getCourierNum) {
		// TODO Auto-generated method stub
		ArrayList<GoodsVO> goods = (new Goodsbl()).getGoodsByCourier(getCourierNum);
		submit(num, date, money, getCourierNum, goods);
		return null;
	}

	public String submit(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods) {
		// TODO Auto-generated method stub
		CashRepPO po = new CashRepPO(num, date, money, getCourierNum, goods);
		System.out.println("Hey,朱德");
		return null;
	}

}
