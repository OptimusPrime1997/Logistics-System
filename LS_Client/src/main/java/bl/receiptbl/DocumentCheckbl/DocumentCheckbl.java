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
import bl.receiptbl.Receiptbl.Receiptbl;
import util.enumData.Rep;

public class DocumentCheckbl {

	Receiptbl receiptbl = new Receiptbl();
	
	public void submitSaveRep(ReceiptVO vo, Rep rep) 
			throws RemoteException, MalformedURLException, IOException, NotBoundException {
		// TODO Auto-generated method stub
		ReceiptPO po = null;
		switch (rep) {
		case ShipmentRep:
			po = ShipmentRepVO.toPO((ShipmentRepVO) vo);
			break;
		case GetRep:
			po = GetRepVO.toPO((GetRepVO) vo);
			break;
		case DeliverRep:
			po = DeliverRepVO.toPO((DeliverRepVO) vo);
			break;
		case InStockRep:
			po = InStockRepVO.toPO((InStockRepVO) vo);
			break;
		case OutStockRep:
			po = OutStockRepVO.toPO((OutStockRepVO) vo);
			break;
		case ShippingRep:
			po = ShippingRepVO.toPO((ShippingRepVO) vo);
			break;
		case ReceptionRep:
			po = ReceptionRepVO.toPO((ReceptionRepVO) vo);
			break;
		case TransferRep:
			po = TransferRepVO.toPO((TransferRepVO) vo);
			break;
		case CashRep:
			po = CashRepVO.toPO((CashRepVO) vo);
			break;
		case PayRep:
			po = PayRepVO.toPO((PayRepVO) vo);
			break;
		}
		receiptbl.submitSave(po, rep);
	}

	public Vector<Object> initTable()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> nums = new ArrayList<String>();

		dates.addAll(getDate(cashCheck()));
		nums.addAll(getNum(cashCheck()));

		dates.addAll(getDate(deliverCheck()));
		nums.addAll(getNum(deliverCheck()));

		dates.addAll(getDate(getCheck()));
		nums.addAll(getNum(getCheck()));

		dates.addAll(getDate(inStockCheck()));
		nums.addAll(getNum(inStockCheck()));

		dates.addAll(getDate(outStockCheck()));
		nums.addAll(getNum(outStockCheck()));

		dates.addAll(getDate(receptionCheck()));
		nums.addAll(getNum(receptionCheck()));

		dates.addAll(getDate(shipmentCheck()));
		nums.addAll(getNum(shipmentCheck()));

		dates.addAll(getDate(shippingCheck()));
		nums.addAll(getNum(shippingCheck()));

		dates.addAll(getDate(transferCheck()));
		nums.addAll(getNum(transferCheck()));

		if(payCheck()!=null){
			dates.add(payCheck().date);
			nums.add(payCheck().num);
		}

		for (int i = 0; i < dates.size(); i++) {
			Vector<String> arr = new Vector<String>();
			arr.add(dates.get(i));
			arr.add(nums.get(i));
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

	public ArrayList<CashRepVO> cashCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.CashRep);
		ArrayList<CashRepVO> cashRepVOs = CashRepVO.toArrayVO(receiptPOs);
		for (CashRepVO cashRepVO : cashRepVOs) {
			if (!cashRepVO.date.equals(receiptbl.getDate())) {
				cashRepVOs.remove(cashRepVO);
			}
		}
		return cashRepVOs;
	}

	public ArrayList<DeliverRepVO> deliverCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.DeliverRep);
		ArrayList<DeliverRepVO> deliverRepVOs = DeliverRepVO.toArrayVO(receiptPOs);
		return deliverRepVOs;
	}

	public ArrayList<GetRepVO> getCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.GetRep);
		ArrayList<GetRepVO> getRepVOs = GetRepVO.toArrayVO(receiptPOs);
		return getRepVOs;
	}

	public ArrayList<InStockRepVO> inStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.InStockRep);
		ArrayList<InStockRepVO> inStockRepVOs = InStockRepVO.toArrayVO(receiptPOs);
		return inStockRepVOs;
	}

	public ArrayList<OutStockRepVO> outStockCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.OutStockRep);
		ArrayList<OutStockRepVO> outStockRepVOs = OutStockRepVO.toArrayVO(receiptPOs);
		return outStockRepVOs;
	}

	public PayRepVO payCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.PayRep);
		PayRepVO payRepVO = new PayRepVO((PayRepPO) receiptPOs.get(0));
		String date = receiptbl.getDate();
		String[] strings = date.split("-");
		date = strings[0]+strings[1];
		if(payRepVO.num.equals(date)){
			return null;
		}
		return payRepVO;
	}

	public ArrayList<ReceptionRepVO> receptionCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ReceptionRep);
		ArrayList<ReceptionRepVO> receptionRepVOs = ReceptionRepVO.toArrayVO(receiptPOs);
		return receptionRepVOs;
	}

	public ArrayList<ShipmentRepVO> shipmentCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShipmentRep);
		ArrayList<ShipmentRepVO> shipmentRepVOs = ShipmentRepVO.toArrayVO(receiptPOs);
		return shipmentRepVOs;
	}

	public ArrayList<ShippingRepVO> shippingCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.ShippingRep);
		ArrayList<ShippingRepVO> shippingRepVOs = ShippingRepVO.toArrayVO(receiptPOs);
		return shippingRepVOs;
	}

	public ArrayList<TransferRepVO> transferCheck()
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.forCheck(Rep.TransferRep);
		ArrayList<TransferRepVO> transferRepVOs = TransferRepVO.toArrayVO(receiptPOs);
		return transferRepVOs;
	}
}
