package bl.receiptbl.DocumentCheckbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;
import PO.Receipt.PayRepPO;
import PO.Receipt.ReceiptPO;
import VO.Receipt.CashRepVO;
import VO.Receipt.DeliverRepVO;
import VO.Receipt.GetRepVO;
import VO.Receipt.InStockRepVO;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import VO.Receipt.ShipmentRepVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;
import bl.loginbl.LoginblController;
import bl.receiptbl.Receiptbl.Receiptbl;
import util.CurrentTime;
import util.enumData.LogType;
import util.enumData.Rep;

public class DocumentCheckbl {

	private Receiptbl receiptbl = new Receiptbl();
	private LoginblController login = new LoginblController();
	
	public void submitSaveRep(String num, Rep rep) 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		receiptbl.submitSave(num, rep);
		String operatorID = login.getCurrentOptorId();
		receiptbl.addLog(LogType.DOCUMENT_CHECK, operatorID, CurrentTime.getTime());
		
	}

	public Vector<Object> initTable()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> nums = new ArrayList<String>();
		ArrayList<String> reps = new ArrayList<String>();
		
		ArrayList<CashRepVO> cashRepVOs = cashCheck();
		ArrayList<DeliverRepVO> deliverRepVOs = deliverCheck();
		ArrayList<GetRepVO> getRepVOs = getCheck();
		ArrayList<InStockRepVO> inStockRepVOs = inStockCheck();
		ArrayList<OutStockRepVO> outStockRepVOs = outStockCheck();
		ArrayList<ReceptionRepVO> receptionRepVOs = receptionCheck();
		ArrayList<ShipmentRepVO> shipmentRepVOs = shipmentCheck();
		ArrayList<ShippingRepVO> shippingRepVOs = shippingCheck();
		ArrayList<TransferRepVO> transferRepVOs = transferCheck();
 
		dates.addAll(getDate(cashRepVOs));
		nums.addAll(getNum(cashRepVOs));
		reps.addAll(getRep(cashRepVOs, "收款单"));

		dates.addAll(getDate(deliverRepVOs));
		nums.addAll(getNum(deliverRepVOs));
		reps.addAll(getRep(deliverRepVOs, "派件单"));

		dates.addAll(getDate(getRepVOs));
		nums.addAll(getNum(getRepVOs));
		reps.addAll(getRep(getRepVOs, "到达单"));

		dates.addAll(getDate(inStockRepVOs));
		nums.addAll(getNum(inStockRepVOs));
		reps.addAll(getRep(inStockRepVOs, "入库单"));

		dates.addAll(getDate(outStockRepVOs));
		nums.addAll(getNum(outStockRepVOs));
		reps.addAll(getRep(outStockRepVOs, "出库单"));

		dates.addAll(getDate(receptionRepVOs));
		nums.addAll(getNum(receptionRepVOs));
		reps.addAll(getRep(receptionRepVOs, "中转中心到达单"));

		dates.addAll(getDate(shipmentRepVOs));
		nums.addAll(getNum(shipmentRepVOs));
		reps.addAll(getRep(shipmentRepVOs, "营业厅装车单"));

		dates.addAll(getDate(shippingRepVOs));
		nums.addAll(getNum(shippingRepVOs));
		reps.addAll(getRep(shippingRepVOs, "中转中心装车单"));

		dates.addAll(getDate(transferRepVOs));
		nums.addAll(getNum(transferRepVOs));
		reps.addAll(getRep(transferRepVOs, "中转单"));

		if(payCheck()!=null){
			dates.add(payCheck().date);
			nums.add(payCheck().num);
			reps.add("付款单");
		}

		for (int i = 0; i < dates.size(); i++) {
			Vector<String> arr = new Vector<String>();
			arr.add(dates.get(i));
			arr.add(nums.get(i));
			arr.add(reps.get(i));
			data.add(arr);
		}
		return data;
	}

	private ArrayList<String> getDate(ArrayList<? extends ReceiptVO> receiptVOs) {
		ArrayList<String> strings = new ArrayList<String>();
		if(receiptVOs==null)
			return null;
		for (ReceiptVO receiptVO : receiptVOs) {
			strings.add(receiptVO.date);
		}
		return strings;
	}

	private ArrayList<String> getNum(ArrayList<? extends ReceiptVO> receiptVOs) {
		if(receiptVOs==null)
			return null;
		ArrayList<String> strings = new ArrayList<String>();
		for (ReceiptVO receiptVO : receiptVOs) {
			strings.add(receiptVO.num);
		}
		return strings;
	}
	
	private ArrayList<String> getRep(ArrayList<? extends ReceiptVO> receiptVOs, String repName) {
		ArrayList<String> strings = new ArrayList<String>();
		if(receiptVOs==null)
			return null;
		for(int i = 0;i < receiptVOs.size();i++){
			strings.add(repName);
		}
		return strings;
	}

	private ArrayList<CashRepVO> cashCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.CashRep);
		if(receiptPOs==null)
			return null;
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		for (CashRepVO cashRepVO : cashRepVOs) {
			if (!cashRepVO.date.equals(receiptbl.getDate())) {
				cashRepVOs.remove(cashRepVO);
			}
		}
		return cashRepVOs;
	}

	private ArrayList<DeliverRepVO> deliverCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.DeliverRep);
		ArrayList<DeliverRepVO> deliverRepVOs = DeliverRepVO.toArrayVO(receiptPOs);
		return deliverRepVOs;
	}

	private ArrayList<GetRepVO> getCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.GetRep);
		ArrayList<GetRepVO> getRepVOs = GetRepVO.toArrayVO(receiptPOs);
		return getRepVOs;
	}

	private ArrayList<InStockRepVO> inStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.InStockRep);
		ArrayList<InStockRepVO> inStockRepVOs = InStockRepVO.toArrayVO(receiptPOs);
		return inStockRepVOs;
	}

	private ArrayList<OutStockRepVO> outStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.OutStockRep);
		ArrayList<OutStockRepVO> outStockRepVOs = OutStockRepVO.toArrayVO(receiptPOs);
		return outStockRepVOs;
	}

	private PayRepVO payCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.PayRep);
		if(receiptPOs==null)
			return null;
		PayRepPO payRepPO = (PayRepPO)receiptPOs.get(0);
		PayRepVO payRepVO = new PayRepVO(payRepPO);
		String date = receiptbl.getDate();
		String[] strings = date.split("-");
		date = strings[0]+strings[1];
		if(payRepVO.num.equals(date)){
			return null;
		}
		return payRepVO;
	}

	private ArrayList<ReceptionRepVO> receptionCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ReceptionRep);
		ArrayList<ReceptionRepVO> receptionRepVOs = ReceptionRepVO.toArrayVO(receiptPOs);
		return receptionRepVOs;
	}

	private ArrayList<ShipmentRepVO> shipmentCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShipmentRep);
		ArrayList<ShipmentRepVO> shipmentRepVOs = ShipmentRepVO.toArrayVO(receiptPOs);
		return shipmentRepVOs;
	}

	private ArrayList<ShippingRepVO> shippingCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShippingRep);
		ArrayList<ShippingRepVO> shippingRepVOs = ShippingRepVO.toArrayVO(receiptPOs);
		return shippingRepVOs;
	}

	private ArrayList<TransferRepVO> transferCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.TransferRep);
		ArrayList<TransferRepVO> transferRepVOs = TransferRepVO.toArrayVO(receiptPOs);
		return transferRepVOs;
	}
}
