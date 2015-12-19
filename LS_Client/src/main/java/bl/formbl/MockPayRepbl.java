package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.PayThing;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepVO;
import VO.Receipt.PayVO;
import bl.receiptbl.Receiptbl.ReceiptblController;

public class MockPayRepbl extends ReceiptblController{
	ArrayList<PayRepVO> vos=new ArrayList<PayRepVO>();
	ArrayList<PayVO> payVOs=new ArrayList<PayVO>();
	
	public ArrayList<PayRepVO> getAllRep() throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
	NotBoundException{
		//10,20,30,40,50=150
		for(int i=1;i<6;i++){
			PayRepVO vo=new PayRepVO("1111", "2015-4-7", i*10, payVOs, "4444", null, null, null, null, null, null, null);
			vos.add(vo);
		}
		return vos;
	}
	public PayRepVO getRepByNum(String tempT) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
	NotBoundException,NumNotFoundException{
			for(int j=11;j<14;j++){
				/*
				 * 
				 */
				PayVO vo=new PayVO(PayThing.Bonus, j, "", "");
				payVOs.add(vo);
			}
			PayRepVO vo = new PayRepVO("111*","2015-4-7", 10, payVOs,
					"4444", null, null, null, null, null, null, null);
		return vo;
	}


}
