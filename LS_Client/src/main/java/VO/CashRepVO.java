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
	
<<<<<<< HEAD
	public static ArrayList<CashRepVO> toVOArray(ArrayList<CashRepPO> cashRepPOs){
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for(CashRepPO cashRepPO : cashRepPOs)
			cashRepVOs.add(new CashRepVO(cashRepPO));
		return cashRepVOs;
	}
	
=======
>>>>>>> origin/master
	public static ArrayList<CashRepPO> toArrayPO(ArrayList<CashRepVO> cashRepVOs){
		ArrayList<CashRepPO> cashRepPOs = new ArrayList<CashRepPO>();
		for(CashRepVO cashRepVO : cashRepVOs)
			cashRepPOs.add(CashRepVO.toPO(cashRepVO));
		return cashRepPOs;
		
	}
<<<<<<< HEAD

	public CashRepVO(CashRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.money = po.getMoney();
		this.courierNum = po.getCourierNum();
		this.courierName = po.getCourierName();
		this.goods = po.getGoods();  					//转arraylist
	}
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, vo.money, vo.courierNum, vo.courierName, vo.goods);     
		//转arraylist
=======

	public CashRepVO(CashRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.money = po.getMoney();
		this.courierNum = po.getCourierNum();
		this.courierName = po.getCourierName();
		this.goods = po.getGoods();  					//转arraylist
	}
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, vo.money, vo.courierNum, vo.courierName, vo.goods);     
		//转arraylist

	public static ArrayList<CashRepPO> toPOArray(ArrayList<CashRepVO> vos){
		ArrayList<CashRepPO> pos=new ArrayList<CashRepPO>();
		//TODO
		return pos;
	}
	public static ArrayList<CashRepVO> toVOArray(ArrayList<CashRepPO> pos){
		ArrayList<CashRepVO> vos=new ArrayList<CashRepVO>();
		//TODO
		return vos;
	}

	public static CashRepVO toVO(CashRepPO po){
		return new CashRepVO(po.getNum(), po.getDate(), po.getMoney(), po.getCourierNum(), po.getCourierName(), GoodsVO.toVOArray(po.getGoods()));
	}
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, vo.money, vo.courierNum, vo.courierName, GoodsVO.toPOArray(vo.goods));
>>>>>>> origin/master
>>>>>>> origin/master
	}
}
