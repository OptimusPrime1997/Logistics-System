package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.City;
import util.enumData.Rep;

public class ReceptionRepPO extends ArriveRepPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -12245612735691435L;
	
	City city;

	public ReceptionRepPO(String num, String date, Rep rep, String shipNum, ArrayList<ArrivePO> getArrivePOs,
			City city) {
		super(num, date, rep, shipNum, getArrivePOs);
		this.city = city;
	}

	public City getCity() {
		return city;
	}
	
}
