package bl.receiptbl.CashRepbl;

import java.util.ArrayList;
import PO.CashRepPO;
import RMI.ReceiptClient;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import VO.CashRepVO;
import VO.GoodsVO;

public class CashRepbl extends Receiptbl{
	ReceiptClient client = new ReceiptClient();
	Goodsbl goodsbl = new Goodsbl();
	
	//得到所有收款单，为其他类提供的
	public ArrayList<CashRepVO> get() {
		return null;
	}

	public String submit(String num, String date, double money, String courierNum, ArrayList<GoodsVO> goods) {
		CashRepPO po = new CashRepPO(num, date, money, courierNum, goods);
		return null;
	}
	
	public ArrayList<GoodsVO> getGoods(String courierNum){
		ArrayList<GoodsVO> goods = goodsbl.getGoodsByCourier(courierNum);
		return goods;
	}
	
	//使用mock
	public String getCourierName(String courierNum){
		return (new MockCourierName()).getCourierName(courierNum);
	}
	
}
