package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class GetRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2286679760970210712L;
	
	private Rep rep;
	private String shipNum;
	private place place;
	private ArrayList<GetPO> getPOs;
	public GetRepPO(String num, String date, Rep rep, String shipNum, util.enumData.place place,
			ArrayList<GetPO> getPOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.place = place;
		this.getPOs = getPOs;
	}
	public Rep getRep() {
		return rep;
	}
	public String getShipNum() {
		return shipNum;
	}
	public place getPlace() {
		return place;
	}
	public ArrayList<GetPO> getGetPOs() {
		return getPOs;
	}
	
}
