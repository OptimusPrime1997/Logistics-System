package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.ShipRepPO;

public class ShipRepVO extends ReceiptVO{
	public String plateNum;
	public String driverNum;
	public boolean arriveAlready;
	public ArrayList<String> goods;
	public ShipRepVO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods) {
		super(num, date);
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public ShipRepVO(ShipRepPO po){
		this.plateNum = po.getPlateNum();
		this.driverNum = po.getDriverNum();
		this.arriveAlready = po.isArriveAlready();
		this.goods = po.getGoods();
	}
	public static ShipRepPO toPO(ShipRepVO vo){
		return new ShipRepPO(vo.num, vo.date, vo.plateNum, vo.driverNum, vo.arriveAlready, vo.goods);
	}
}
