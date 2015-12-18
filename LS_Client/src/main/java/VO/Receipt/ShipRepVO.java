package VO.Receipt;

import java.util.ArrayList;

public class ShipRepVO extends ReceiptVO{
	
	public String depart;
	public String plateNum;
	public String driverNum;
	public ArrayList<String> goods;
	
	public ShipRepVO(String num, String date, String depart, String plateNum, String driverNum,
			ArrayList<String> goods) {
		super(num, date);
		this.depart = depart;
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.goods = goods;
	}

	public ShipRepVO(){
		
	}
}
