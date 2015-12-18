package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import PO.Receipt.ShipmentRepPO;

public class ShipmentRepVO extends ShipRepVO {

	public ShipmentRepVO(String num, String date, String depart, String plateNum, String driverNum,
			ArrayList<String> goods) {
		super(num, date, depart, plateNum, driverNum, goods);
		// TODO Auto-generated constructor stub
	}
	public ShipmentRepVO(ShipmentRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.depart = po.getDepart();
		this.plateNum = po.getPlateNum();
		this.driverNum = po.getDriverNum();
		this.goods = po.getGoods();
	}
	public static ShipmentRepPO toPO(ShipmentRepVO vo){
		return new ShipmentRepPO(vo.num, vo.date, vo.depart, vo.plateNum, vo.driverNum, vo.goods);
	}
	public static ArrayList<ShipmentRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<ShipmentRepVO> shipmentRepVOs = new ArrayList<ShipmentRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			shipmentRepVOs.add(new ShipmentRepVO((ShipmentRepPO) receiptPO));
		return shipmentRepVOs;
	}
	
	public static ArrayList<ShipmentRepPO> toArrayPO(ArrayList<ShipmentRepVO> shipmentRepVOs) {
		ArrayList<ShipmentRepPO> shipmentRepPOs = new ArrayList<ShipmentRepPO>();
		for (ShipmentRepVO shipmentRepVO : shipmentRepVOs)
			shipmentRepPOs.add(toPO(shipmentRepVO));
		return shipmentRepPOs;
	}
}
