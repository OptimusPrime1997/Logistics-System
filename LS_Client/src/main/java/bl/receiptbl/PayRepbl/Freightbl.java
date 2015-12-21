package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayFreightVO;
import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.TransferRepVO;
import bl.receiptbl.TransferRepbl.TransferRepbl;

public class Freightbl{
	
	private TransferRepbl transferRepbl = new TransferRepbl();
	
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO){
		payRepVO.freight = payRepFreightRepVO;
	}
	
	public Vector<Object> initFreightTable(String date) 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException{
		Vector<Object> data = new Vector<Object>();
		ArrayList<TransferRepVO> transferRepVOs = transferRepbl.getMonthRep(date);
		if(transferRepVOs==null)
			return null;
		for(TransferRepVO transferRepVO : transferRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(transferRepVO.num);
			arr.add(transferRepVO.money+"");
			data.add(arr);
		}
		return data;
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
	
}
