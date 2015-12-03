package PO.ReceiptPO;

import java.util.ArrayList;

public class InStockRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1305646238552043945L;
	
	private ArrayList<InStockPO> inStockPOs;

	public InStockRepPO(String num, String date, ArrayList<InStockPO> inStockPOs) {
		super(num, date);
		this.inStockPOs = inStockPOs;
	}

	public ArrayList<InStockPO> getInStockPOs() {
		return inStockPOs;
	}
	
}
