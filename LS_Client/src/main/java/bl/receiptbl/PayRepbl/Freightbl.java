package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import PO.Receipt.ReceiptPO;
import VO.Receipt.PayFreightVO;
import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.TransferRepVO;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class Freightbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO){
		payRepVO.freight = payRepFreightRepVO;
	}
	
	public Vector<Object> initFreightTable(PayRepVO payRepVO) 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException{
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		receiptPOs = receiptbl.forCheck(Rep.TransferRep);
		ArrayList<TransferRepVO> transferRepVOs = TransferRepVO.toArrayVO(receiptPOs);
		for(TransferRepVO transferRepVO : transferRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(transferRepVO.num);
			arr.add(transferRepVO.money+"");
			data.add(arr);
		}
		return data;
	}
	
	public Vector<Object> initFreightCheck(PayRepVO payRepVO){
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
