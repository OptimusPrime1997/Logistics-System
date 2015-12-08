package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayBonusVO;
import VO.ReceiptVO.PayRepBonusRepVO;
import VO.ReceiptVO.PayRepVO;

public class Bonusbl{
	
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO){
		payRepVO.bonus = payRepBonusRepVO;
	}
	
	public Vector<Object> initBonusTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayBonusVO> payBonusVOs = payRepVO.bonus.bonusVOs;
		if(payBonusVOs==null)
			return data;
		PayBonusVO payBonusVO;
		for(int i = 0;i < payBonusVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			payBonusVO = payBonusVOs.get(i);
			arr.add(payBonusVO.getterName);
			arr.add(payBonusVO.getterNum);
			arr.add(payBonusVO.money);
			arr.add(payBonusVO.remark);
			data.add(arr);
		}
		return data;
	}
	
}
