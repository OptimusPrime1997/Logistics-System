package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayBonusVO;
import VO.Receipt.PayRepBonusRepVO;
import VO.Receipt.PayRepVO;
import bl.managementbl.accountbl.Accountbl;

public class Bonusbl{
	
	private Accountbl accountbl = new Accountbl();
	
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO){
		payRepVO.bonus = payRepBonusRepVO;
	}
	
	public Vector<Object> initBonusTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		PayRepBonusRepVO payRepBonusRepVO = payRepVO.bonus;
		if(payRepBonusRepVO==null)
			return data;
		ArrayList<PayBonusVO> payBonusVOs = payRepBonusRepVO.bonusVOs;
		if(payBonusVOs==null)
			return data;
		PayBonusVO payBonusVO;
		for(int i = 0;i < payBonusVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payBonusVO = payBonusVOs.get(i);
			arr.add(payBonusVO.getterName);
			arr.add(payBonusVO.getterNum);
			arr.add(payBonusVO.money+"");
			arr.add(payBonusVO.remark);
			data.add(arr);
		}
		return data;
	}
	
	public String getReceiverName(String num) 
			throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException, 
			NumNotFoundException, IOException{
		return accountbl.findByAccountNum(num).accountName;
	}
	
}
