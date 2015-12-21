package bl.receiptbl.CashRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.CashRepVO;

public class CashRepCheckbl {
	
	private CashRepbl cashRepbl = new CashRepbl();

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		ArrayList<CashRepVO> cashRepVOs = cashRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		if(cashRepVOs==null)
			return null;
		for (int i = 0; i < cashRepVOs.size(); i++) {
			CashRepVO cashRepVO = cashRepVOs.get(i);
			Vector<String> arr = new Vector<String>();
			arr.add(cashRepVO.date);
			arr.add(cashRepVO.num);
			arr.add(cashRepVO.sum+"");
			arr.add(cashRepVO.bankAccount);
			data.add(arr);
		}
		return data;
	}
}
