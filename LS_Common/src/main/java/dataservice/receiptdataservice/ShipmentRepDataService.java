package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ShipmentRepPO;
import util.enumData.ResultMessage;

public interface ShipmentRepDataService extends Serializable{
	public ResultMessage submit(ShipmentRepPO po);
	
	public ResultMessage save(ShipmentRepPO po);
	
	public ArrayList<ShipmentRepPO> getAllRep();
	
	public ArrayList<ShipmentRepPO> getRepByDate(String date);
	
	public ShipmentRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
