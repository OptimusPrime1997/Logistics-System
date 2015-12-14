package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayRefundVO;
import VO.ReceiptVO.PayRepRefundRepVO;
import VO.ReceiptVO.PayRepVO;

public class Refundbl{
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO){
		payRepVO.refund.add(payRepRefundRepVO);
	}
	
	public PayRepRefundRepVO getRepByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date){
		for(int i = 0;i < payRepRefundRepVOs.size();i++){
			PayRepRefundRepVO payRepRefundRepVO = payRepRefundRepVOs.get(i);
			if(payRepRefundRepVO.date.equals(date))
				return payRepRefundRepVO;
		}
		return null;
	}
	
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date){
		Vector<Object> data = new Vector<Object>();
		PayRepRefundRepVO payRepRefundRepVO = getRepByDate(payRepVO.refund, date);
		ArrayList<PayRefundVO> payRefundVOs = payRepRefundRepVO.refundVOs;
		if(payRefundVOs==null)
			return data;
		PayRefundVO payRefundVO;
		for(int i = 0;i < payRefundVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payRefundVO = payRefundVOs.get(i);
			arr.add(payRefundVO.money+"");
			arr.add(payRefundVO.reason);
			data.add(arr);
		}
		return data;
	}
}
