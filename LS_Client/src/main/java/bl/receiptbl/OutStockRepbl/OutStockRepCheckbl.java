package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.Receipt.OutStockRepPO;
import PO.Receipt.ReceiptPO;
import VO.ReceiptVO.OutStockRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;
import util.enumData.ShipForm;

public class OutStockRepCheckbl {
	
	private Receiptbl receiptbl = new Receiptbl();
	private OutStockRepbl outStockRepbl = new OutStockRepbl();

	public OutStockRepVO getRepByNum(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.OutStockRep);
		if(receiptPO==null)
			throw new NumNotFoundException();
		return new OutStockRepVO((OutStockRepPO)receiptPO);
	}

	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<OutStockRepVO> outStockRepVOs = outStockRepbl.getAllRep(office);
		Vector<Object> data = new Vector<Object>();
		for(int i = 0;i < outStockRepVOs.size();i++){
			OutStockRepVO outStockRepVO = outStockRepVOs.get(i);
			Vector<String> arr = new Vector<String>();
			arr.add(outStockRepVO.date);
			arr.add(outStockRepVO.num);
			arr.add(outStockRepVO.rep.getChineseName());
			arr.add(outStockRepVO.num);
			arr.add(outStockRepVO.destination);
			arr.add(ShipForm.toFrendlyString(outStockRepVO.form));
			data.add(arr);
		}
		return data;
	}

}
