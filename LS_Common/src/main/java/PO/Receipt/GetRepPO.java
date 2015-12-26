package PO.Receipt;

import java.util.ArrayList;

import util.enumData.Rep;

public class GetRepPO extends ArriveRepPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8377757294341536716L;

	String depart;

	public GetRepPO(String num, String date, Rep rep, String shipNum, ArrayList<ArrivePO> arrivePOs, String depart) {
		super(num, date, rep, shipNum, arrivePOs);
		this.depart = depart;
	}

	public String getDepart() {
		return depart;
	}

}
