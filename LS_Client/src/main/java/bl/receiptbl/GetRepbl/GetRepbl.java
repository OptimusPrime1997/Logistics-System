package bl.receiptbl.GetRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.ReceiptPO.ReceiptPO;
import VO.ReceiptVO.GetRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.ShippingRepbl.ShippingRepbl;
import util.enumData.Rep;

public class GetRepbl{
	
	private Receiptbl receiptbl = new Receiptbl();
	private Goodsbl goodsbl = new Goodsbl();

	public ShipmentRepVO getShipmentRep(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getRepByNum(num);
	}
	
	public ShippingRepVO getShippingRep(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		ShippingRepbl shipping = new ShippingRepbl();
		return shipping.getRepByNum(num);
	}

	public String createNum(String date) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.GetRep);
	}


	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(GetRepVO.toPO((GetRepVO) vo), Rep.GetRep);
	}

	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		Vector<Object> data = new Vector<Object>();
		ArrayList<String> orders;
		if(rep==Rep.ShipmentRep){
			orders = getShipmentRep(num).goods;
		}
		else {
			orders = getShippingRep(num).goods;
		}
		if(orders.size()>existOrders.size()){
			for(int i = 0;i < orders.size();i++){
				if(existOrders.contains(orders.get(i)))
					data.add(orders.get(i));
			}
		}
		return data;
	}

	public void transferOver(String num) {
		// TODO Auto-generated method stub
		goodsbl.end(num);
	}

	public ArrayList<GetRepVO> getAllRep() throws ClassNotFoundException, NotBoundException, 
	IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.GetRep);
		return GetRepVO.toArrayVO(receiptPOs);
	}
	
	public String getDepart(Rep rep, String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		
		if(rep==Rep.ShipmentRep){
			return getShipmentRep(num).depart;
		}
		else {
			return getShippingRep(num).depart;
		}
	}

}
