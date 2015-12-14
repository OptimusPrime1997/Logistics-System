package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.PayFreightVO;
import VO.ReceiptVO.PayRepFreightRepVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.TransferRepbl.TransferRepbl;

public class Freightbl{
	
	private TransferRepbl transferRepbl = new TransferRepbl();
	
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO){
		payRepVO.freight = payRepFreightRepVO;
	}
	
	public Vector<Object> initFreightTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayFreightVO> payFreightVOs = payRepVO.freight.payFreightVOs;
		if(payFreightVOs==null)
			return data;
		PayFreightVO payFreightVO;
		for(int i = 0;i < payFreightVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payFreightVO = payFreightVOs.get(i);
			arr.add(payFreightVO.transferRepNum);
			arr.add(payFreightVO.money+"");
			arr.add(payFreightVO.remark);
			data.add(arr);
		}
		return data;
	}
	
	public double getFreightMoney(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		TransferRepVO transferRepVO = transferRepbl.getRepByNum(num);
		return transferRepVO.money;
	}
}
