package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.Rep;
import util.enumData.place;

public class ArriveRepPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6327438898744664207L;
	
	private Rep rep;
	private String shipNum;
	private place place;
	private ArrayList<ArrivePO> getArrivePOs;
	public ArriveRepPO(String num, String date, Rep rep, String shipNum, util.enumData.place place,
			ArrayList<ArrivePO> getArrivePOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.place = place;
		this.getArrivePOs = getArrivePOs;
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
	public ArrayList<ArrivePO> getArrivePOs() {
		return getArrivePOs;
	}
}
