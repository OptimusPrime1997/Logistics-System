package VO;

import java.util.ArrayList;

import PO.CashRepPO;
import PO.GoodsPO;

public class CashRepVO extends ReceiptVO {
	public double money;
	public String courierNum;
	public String courierName;
	public ArrayList<GoodsVO> goods;
	
	/**
	 * 
	 * @param num
	 * @param date
	 * @param money
	 * @param courierNum
	 * @param courierName
	 * @param goods
	 */
	public CashRepVO(String num, String date, double money, String courierNum, String courierName,
			ArrayList<GoodsVO> goods) {
		super(num, date);
		this.money = money;
		this.courierNum = courierNum;
		this.courierName = courierName;
		this.goods = goods;
	}
	
	public CashRepVO(CashRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.money = po.getMoney();
		this.courierNum = po.getCourierNum();
		this.courierName = po.getCourierName();
		this.goods = GoodsVO.toVOArray(po.getGoods());  					
	}
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, vo.money, vo.courierNum, vo.courierName, GoodsVO.toPOArray(vo.goods));
	}
	
	public static ArrayList<CashRepVO> toVOArray(ArrayList<CashRepPO> cashRepPOs){
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for(CashRepPO cashRepPO : cashRepPOs)
			cashRepVOs.add(new CashRepVO(cashRepPO));
		return cashRepVOs;
	}
	
	public static ArrayList<CashRepPO> toArrayPO(ArrayList<CashRepVO> cashRepVOs){
		ArrayList<CashRepPO> cashRepPOs = new ArrayList<CashRepPO>();
		for(CashRepVO cashRepVO : cashRepVOs)
			cashRepPOs.add(CashRepVO.toPO(cashRepVO));
		return cashRepPOs;
		
	}
}
