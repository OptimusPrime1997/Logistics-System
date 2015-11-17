package bl.receiptbl.CashRepbl;

import java.util.ArrayList;

import VO.GoodsVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.CashRepblService;

public class CashRepController extends ReceiptController implements CashRepblService{
	private CashRepbl CashRep = new CashRepbl();
	
	@Override
	public String submit(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods){
		return CashRep.submit(num, date, money, getCourierNum, goods);
	}
	
	@Override
	public ArrayList<GoodsVO> getGoods(String courierNum){
		return CashRep.getGoods(courierNum);
	}
	
	@Override
	public String getCourierName(String courierNum){
//		return CashRep.getCourierName(courierNum);
		return "梁家诚";
	}
	
	public CashRepbl getCashRepbl(){
		return CashRep;
	}
}
