package bl.formbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.Receipt.CashRepVO;
import VO.Receipt.CashVO;
import bl.receiptbl.Receiptbl.ReceiptblController;

public class MockCashRepbl extends ReceiptblController{

	ArrayList<CashRepVO> vos=new ArrayList<CashRepVO>();
	ArrayList<CashVO> cashVOs=new ArrayList<CashVO>();
	public ArrayList<CashRepVO> getAllRep() throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
	NotBoundException{
		//50,60,70,80,90=350
		for(int i=5;i<10;i++){
			CashRepVO vo=new CashRepVO("0000", "2015-12-12", i*10, "大玉儿", cashVOs);
			vos.add(vo);
		}
		return vos;
	}
	public ArrayList<CashRepVO> getAllRepByDate(String tempT) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, 
	NotBoundException{
		
		//50,60,70,80,90=350
		for (int i = 5; i < 10; i++) {
			for(int j=1;j<4;j++){
				/*
				 *5,10,15,
				 *6,12,18,
				 *7,14,21,
				 *8,16,24,
				 *9,18,27,
				 */
				CashVO vo=new CashVO(i*j, "0251540622"+j, "快递小哥", "");
				cashVOs.add(vo);
			}
			CashRepVO vo = new CashRepVO("000" + i, "2015-12-" + i, i * 10, "", cashVOs);
			vos.add(vo);
			
		}
		return vos;
	}

}
