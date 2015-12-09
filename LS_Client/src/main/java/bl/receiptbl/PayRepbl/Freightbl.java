package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayFreightVO;
import VO.ReceiptVO.PayRepFreightRepVO;
import VO.ReceiptVO.PayRepVO;

public class Freightbl{
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
			Vector<Object> arr = new Vector<Object>();
			payFreightVO = payFreightVOs.get(i);
			arr.add(payFreightVO.transferRepNum);
			arr.add(payFreightVO.money);
			arr.add(payFreightVO.remark);
			data.add(arr);
		}
		return data;
	}
}
