package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRefundVO;
import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepVO;

public class Refundbl{
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO){
		ArrayList<PayRepRefundRepVO> payRepRefundRepVOs = payRepVO.refund;
		for(PayRepRefundRepVO payRepRefundRepVO2 : payRepRefundRepVOs){
			if((payRepRefundRepVO.date).equals((payRepRefundRepVO2.date))){
				payRepRefundRepVOs.remove(payRepRefundRepVO2);
				break;
			}
		}
		payRepVO.refund.add(payRepRefundRepVO);
	}
	
	public PayRepRefundRepVO getRefundByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date){
		for(int i = 0;i < payRepRefundRepVOs.size();i++){
			PayRepRefundRepVO payRepRefundRepVO = payRepRefundRepVOs.get(i);
			if(payRepRefundRepVO.date.equals(date))
				return payRepRefundRepVO;
		}
		return null;
	}
	
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date){
		Vector<Object> data = new Vector<Object>();
		PayRepRefundRepVO payRepRefundRepVO = getRefundByDate(payRepVO.refund, date);
		if(payRepRefundRepVO==null)
			return data;
		ArrayList<PayRefundVO> payRefundVOs = payRepRefundRepVO.refundVOs;
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
	
	public String getRefundTime(String type){
		type = type.split("(")[1];
		type = type.split(")")[0];
		return type;
	}
}
