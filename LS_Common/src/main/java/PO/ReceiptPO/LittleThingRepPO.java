package PO.ReceiptPO;

import java.util.ArrayList;

public class LittleThingRepPO {
	private double sum;
	private String date;
	private ArrayList<LittleThingPO> littleThingPOs;
	private String bankAccountNum;
	public LittleThingRepPO(double sum, String date, ArrayList<LittleThingPO> littleThingPOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.littleThingPOs = littleThingPOs;
		this.bankAccountNum = bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	public String getDate() {
		return date;
	}
	public ArrayList<LittleThingPO> getLittleThingPOs() {
		return littleThingPOs;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	
}
