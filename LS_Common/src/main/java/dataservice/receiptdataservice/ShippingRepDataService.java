package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ShippingRepPO;
import util.enumData.ResultMessage;

public interface ShippingRepDataService extends Serializable{
	public ResultMessage submit(ShippingRepPO po);
	
	public ResultMessage save(ShippingRepPO po);
	
	public ArrayList<ShippingRepPO> getAllRep();
	
	public ArrayList<ShippingRepPO> getRepByDate(String date);
	
	public ShippingRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
