package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRentVO;
import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepVO;

public class Rentbl{

	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO){
		payRepVO.rent = payRepRentRepVO;
	}
	
	public Vector<Object> initRentTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayRentVO> payRentVOs = payRepVO.rent.rentVOs;
		if(payRentVOs==null)
			return data;
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
