package bl.receiptbl.DeliverRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.GoodsNotFound;
import PO.Receipt.ReceiptPO;
import VO.Receipt.DeliverRepVO;
import VO.Receipt.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.CurrentTime;
import util.enumData.GoodsLogisticState;
import util.enumData.LogType;
import util.enumData.Rep;

public class DeliverRepbl {
	
	private Receiptbl receiptbl = new Receiptbl();
	private Goodsbl goodsbl = new Goodsbl();
	private LoginblController login = new LoginblController();

	public String createNum(String date, String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		String num = receiptbl.createNum(date, Rep.DeliverRep, office);
		int k = num.length();
		for (int i = 4; i > k; i--)
			num = "0" + num;
		return num;
	}

	public void submit(ReceiptVO vo) 
			throws RemoteException, MalformedURLException, IOException, NotBoundException {
		receiptbl.submit(DeliverRepVO.toPO((DeliverRepVO) vo), Rep.DeliverRep);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.DELIVER, operatorID, CurrentTime.getTime());
	}

	public String getNameByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return goodsbl.findByListNum(order).receiverName;
	}

	public String getPhoneByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return goodsbl.findByListNum(order).receiverPhone;
	}

	public String getAddressByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return goodsbl.findByListNum(order).receiverAddress;
	}

	public ArrayList<DeliverRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.DeliverRep, office);
		return DeliverRepVO.toArrayVO(receiptPOs);
	}
	
	public boolean isTrueAccount(String num){
		return receiptbl.isTrueAccount(num);
	}
	
	public void changeLogistic(String num){
		goodsbl.setLogisticState(num, GoodsLogisticState.DELIVERING, receiptbl.getDate());
	}
	
}
