package bl.receiptbl.CashRepbl;

import java.util.ArrayList;
import PO.CashRepPO;
import RMIClient.Receipt.CashRepRMI;
import RMIClient.Receipt.ReceiptClient;
import bl.goodsbl.Goodsbl;
import bl.managementbl.accountbl.Accountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.ResultMessage;
import VO.CashRepVO;
import VO.GoodsVO;

public class CashRepbl extends Receiptbl{
	ReceiptClient client = new ReceiptClient();
	CashRepRMI CashRepclient = new CashRepRMI();
	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	
	/**
	 * 得到所有收款单CashRep
	 * @return
	 */
	public ArrayList<CashRepVO> getAllCashRep() {
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		ArrayList<CashRepPO> cashRepPOs = CashRepclient.getCashRepPO();
		for(int i = 0;i<cashRepPOs.size();i++){
			CashRepPO po = cashRepPOs.get(i);
			CashRepVO vo = new CashRepVO(po.getNum(), po.getDate(), po.getMoney(), po.getGetCourierNum(), po.getGoods());
			cashRepVOs.add(vo);
		}
		return cashRepVOs;
	}

	public ResultMessage submit(String num, String date, double money, String courierNum, ArrayList<GoodsVO> goods) {
		CashRepPO po = new CashRepPO(num, date, money, courierNum, goods);
		return client.submit(po);
	}
	
	public ArrayList<GoodsVO> getGoods(String courierNum){
		return goodsbl.getGoodsByGetCourier(courierNum);
	}
	
	public String getCourierName(String courierNum){
		return accountbl.findByNum(courierNum).accountName;
	}
	
	public double getMoneySum(ArrayList<GoodsVO> arrGoods){
		double moneysum = 0;
		for(int i = 0;i<arrGoods.size();++i){
        	moneysum += arrGoods.get(i).moneyTotal;
    	}
		return moneysum;
	}
	
}
