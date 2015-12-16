package PO.Receipt;

import java.util.ArrayList;

import util.enumData.Rep;

public class GetRepPO extends ArriveRepPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8377757294341536716L;
	
	String destination;

	public GetRepPO(String num, String date, Rep rep, String shipNum, ArrayList<ArrivePO> getArrivePOs,
			String destination) {
		super(num, date, rep, shipNum, getArrivePOs);
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}
	
}
