package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRentVO;
import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;

public class Rentbl{
	
	Receiptbl receiptbl = new Receiptbl();

	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO){
		payRepVO.rent = payRepRentRepVO;
	}
	
	public Vector<Object> initRentTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		PayRepRentRepVO payRepRentRepVO = payRepVO.rent;
		if(payRepRentRepVO==null)
			return data;
		ArrayList<PayRentVO> payRentVOs = payRepRentRepVO.rentVOs;
		if(payRentVOs==null)
			return null;
		PayRentVO payRentVO;
		for(int i = 0;i < payRentVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payRentVO = payRentVOs.get(i);
			arr.add(payRentVO.getterName);
			arr.add(payRentVO.phoneNum);
			arr.add(payRentVO.money+"");
			arr.add(payRentVO.remark);
			data.add(arr);
		}
		return data;
	}
	
}
