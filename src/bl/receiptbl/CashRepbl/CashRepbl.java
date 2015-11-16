package bl.receiptbl.CashRepbl;

import java.util.ArrayList;
import PO.CashRepPO;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import VO.CashRepVO;
import VO.GoodsVO;

public class CashRepbl extends Receiptbl{
	//得到所有收款单，为其他类提供的
	public ArrayList<CashRepVO> get() {
		return null;
	}

	public String submit(String num, String date, double money, String courierNum, ArrayList<GoodsVO> goods) {
		// TODO Auto-generated method stub
		CashRepPO po = new CashRepPO(num, date, money, courierNum, goods);
		return null;
	}
	
	public ArrayList<GoodsVO> getGoods(String courierNum){
		ArrayList<GoodsVO> goods = (new Goodsbl()).getGoodsByCourier(courierNum);
		return goods;
	}
	
	public String getCourierName(String courierNum){
		return "刘琴";
	}

}
