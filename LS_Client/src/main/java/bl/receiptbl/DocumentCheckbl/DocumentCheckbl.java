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
import ui.receiptui.ReceiptDetailUI.Shipment;
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
		data.addAll(cashCheck());
		data.addAll(deliverCheck());
		data.addAll(getCheck());
		data.addAll(inStockCheck());
		data.addAll(outStockCheck());
		data.addAll(payCheck());
		data.addAll(receptionCheck());
		data.addAll(shipmentCheck());
		data.addAll(shippingCheck());
		data.addAll(transferCheck());
		return data;
	}

	private Vector<Object> cashCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.CashRep);
		if(receiptPOs==null)
			return data;
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		for (CashRepVO cashRepVO : cashRepVOs) {
			if (cashRepVO.date.equals(receiptbl.getDate())) {
				cashRepVOs.remove(cashRepVO);
			}
			else {
				Vector<String> arr = new Vector<String>();
				arr.add(cashRepVO.date);
				arr.add(cashRepVO.num);
				arr.add("收款单");
				data.add(arr);
			}
		}
		return data;
	}

	private Vector<Object> deliverCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.DeliverRep);
		if(receiptPOs==null)
			return data;
		ArrayList<DeliverRepVO> deliverRepVOs = DeliverRepVO.toArrayVO(receiptPOs);
		for(DeliverRepVO deliverRepVO : deliverRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(deliverRepVO.date);
			arr.add(deliverRepVO.num);
			arr.add("派件单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> getCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.GetRep);
		if(receiptPOs==null)
			return data;
		ArrayList<GetRepVO> getRepVOs = GetRepVO.toArrayVO(receiptPOs);
		for(GetRepVO getRepVO : getRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(getRepVO.date);
			arr.add(getRepVO.num);
			arr.add("营业厅到达单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> inStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.InStockRep);
		if(receiptPOs==null)
			return data;
		ArrayList<InStockRepVO> inStockRepVOs = InStockRepVO.toArrayVO(receiptPOs);
		for(InStockRepVO inStockRepVO : inStockRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(inStockRepVO.date);
			arr.add(inStockRepVO.num);
			arr.add("入库单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> outStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.OutStockRep);
		if(receiptPOs==null)
			return data;
		ArrayList<OutStockRepVO> outStockRepVOs = OutStockRepVO.toArrayVO(receiptPOs);
		for(OutStockRepVO outStockRepVO : outStockRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(outStockRepVO.date);
			arr.add(outStockRepVO.num);
			arr.add("出库单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> payCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.PayRep);
		if(receiptPOs==null)
			return data;
		PayRepPO payRepPO = (PayRepPO)receiptPOs.get(0);
		PayRepVO payRepVO = new PayRepVO(payRepPO);
		String date = receiptbl.getDate();
		String[] strings = date.split("-");
		date = strings[0]+strings[1];
		if(payRepVO.num.equals(date)){
			return null;
		}
		Vector<String> arr = new Vector<String>();
		arr.add(payRepVO.date);
		arr.add(payRepVO.num);
		arr.add("付款单");
		data.add(arr);
		return data;
	}

	private Vector<Object> receptionCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ReceptionRep);
		if(receiptPOs==null)
			return data;
		ArrayList<ReceptionRepVO> receptionRepVOs = ReceptionRepVO.toArrayVO(receiptPOs);
		for(ReceptionRepVO receptionRepVO : receptionRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(receptionRepVO.date);
			arr.add(receptionRepVO.num);
			arr.add("中转中心到达单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> shipmentCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShipmentRep);
		if(receiptPOs==null)
			return data;
		ArrayList<ShipmentRepVO> shipmentRepVOs = ShipmentRepVO.toArrayVO(receiptPOs);
		for(ShipmentRepVO shipmentRepVO : shipmentRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(shipmentRepVO.date);
			arr.add(shipmentRepVO.num);
			arr.add("营业厅装车单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> shippingCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShippingRep);
		if(receiptPOs==null)
			return data;
		ArrayList<ShippingRepVO> shippingRepVOs = ShippingRepVO.toArrayVO(receiptPOs);
		for(ShippingRepVO shippingRepVO : shippingRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(shippingRepVO.date);
			arr.add(shippingRepVO.num);
			arr.add("中转中心装车单");
			data.add(arr);
		}
		return data;
	}

	private Vector<Object> transferCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.TransferRep);
		if(receiptPOs==null)
			return data;
		ArrayList<TransferRepVO> transferRepVOs = TransferRepVO.toArrayVO(receiptPOs);
		for(TransferRepVO transferRepVO : transferRepVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(transferRepVO.date);
			arr.add(transferRepVO.num);
			arr.add("中转单");
			data.add(arr);
		}
		return data;
	}
}
