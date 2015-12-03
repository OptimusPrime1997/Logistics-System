package PO.ReceiptPO;

import java.util.ArrayList;

public class LittleThingRepPO {
	private String date;
	private ArrayList<LittleThingPO> littleThingPOs;
	private String bankAccountNum;
	public LittleThingRepPO(String date, ArrayList<LittleThingPO> littleThingPOs, String bankAccountNum) {
		super();
		this.date = date;
		this.littleThingPOs = littleThingPOs;
		this.bankAccountNum = bankAccountNum;
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
