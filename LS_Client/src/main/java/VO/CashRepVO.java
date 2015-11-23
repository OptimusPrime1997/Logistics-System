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

	public static CashRepVO toVO(CashRepPO po){
		return new CashRepVO(po.getNum(), po.getDate(), po.getMoney(), po.getCourierNum(), po.getCourierName(), GoodsVO.toVOArray(po.getGoods()));
	}
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, vo.money, vo.courierNum, vo.courierName, GoodsVO.toPOArray(vo.goods));
	}
}
