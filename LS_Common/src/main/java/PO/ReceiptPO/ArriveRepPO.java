package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.Rep;
import util.enumData.City;

public class ArriveRepPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6327438898744664207L;
	
	private Rep rep;
	private String shipNum;
	private City City;
	private ArrayList<ArrivePO> getArrivePOs;
	public ArriveRepPO(String num, String date, Rep rep, String shipNum, util.enumData.City City,
			ArrayList<ArrivePO> getArrivePOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.City = City;
		this.getArrivePOs = getArrivePOs;
	}
	public Rep getRep() {
		return rep;
	}
	public String getShipNum() {
		return shipNum;
	}
	public City getCity() {
		return City;
	}
	public ArrayList<ArrivePO> getArrivePOs() {
		return getArrivePOs;
	}
}
