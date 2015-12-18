package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import PO.Receipt.ShippingRepPO;

public class ShippingRepVO extends ShipRepVO {
	public String destination;

	public ShippingRepVO(String num, String date, String depart, String plateNum, String driverNum,
			ArrayList<String> goods, String destination) {
		super(num, date, depart, plateNum, driverNum, goods);
		this.destination = destination;
	}
	
	public ShippingRepVO(ShippingRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.depart = po.getDepart();
		this.plateNum = po.getPlateNum();
		this.driverNum = po.getDriverNum();
		this.goods = po.getGoods();
		this.destination = po.getDestination();
	}
	
	public static ShippingRepPO toPO(ShippingRepVO vo){
		return new ShippingRepPO(vo.num, vo.date,vo.depart, vo.plateNum, vo.driverNum, vo.goods, vo.destination);
	}
	
	public static ArrayList<ShippingRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<ShippingRepVO> shippingRepVOs = new ArrayList<ShippingRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			shippingRepVOs.add(new ShippingRepVO((ShippingRepPO) receiptPO));
		return shippingRepVOs;
	}
	
	public static ArrayList<ShippingRepPO> toArrayPO(ArrayList<ShippingRepVO> shippingRepVOs) {
		ArrayList<ShippingRepPO> shippingRepPOs = new ArrayList<ShippingRepPO>();
		for (ShippingRepVO shippingRepVO : shippingRepVOs)
			shippingRepPOs.add(toPO(shippingRepVO));
		return shippingRepPOs;
	}
	
}
