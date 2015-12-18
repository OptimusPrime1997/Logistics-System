package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import PO.Receipt.ReceiptPO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import VO.Receipt.ShipmentRepVO;
import VO.Receipt.TransferRepVO;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import bl.receiptbl.ShipmentRepbl.ShipmentRepbl;
import bl.receiptbl.TransferRepbl.TransferRepbl;
import util.enumData.Rep;

public class ReceptionRepbl{
	
	Receiptbl receiptbl = new Receiptbl();
	Goodsbl goodsbl = new Goodsbl();

	public ShipmentRepVO getShipmentRep(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		ShipmentRepbl shipment = new ShipmentRepbl();
		return shipment.getRepByNum(num);
	}
	
	public TransferRepVO getTransferRep(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		TransferRepbl transfer = new TransferRepbl();
		return transfer.getRepByNum(num);
	}

	public String createNum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receiptbl.createNum(date, Rep.ReceptionRep, office);
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receiptbl.submit(ReceptionRepVO.toPO((ReceptionRepVO) vo), Rep.ReceptionRep);
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
			orders = getTransferRep(num).goods;
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

	public ArrayList<ReceptionRepVO> getAllRep(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.ReceptionRep, office);
		return ReceptionRepVO.toArrayVO(receiptPOs);
	}
	
	public String getDepart(Rep rep, String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException{
		
		if(rep==Rep.ShipmentRep){
			return getShipmentRep(num).depart;
		}
		else {
			return getTransferRep(num).depart;
		}
	}

	public boolean isTrueOrder(String order){
		return receiptbl.isTrueOrder(order);
	}
}
