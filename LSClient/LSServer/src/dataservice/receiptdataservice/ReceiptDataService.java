package dataservice.receiptdataservice;

import java.util.ArrayList;
import PO.ReceiptPO;
import util.enumData.*;;

public interface ReceiptDataService {
	
	public ArrayList<ReceiptPO> getRep();
	
	public String saveRep(ReceiptPO po);
	
	public String delete(Rep rep, int n);
	
	public String delete(Rep rep, String num);
	
	public ArrayList<ReceiptPO> show(Rep rep);
	
	public ReceiptPO find (Rep rep, String num);

}
