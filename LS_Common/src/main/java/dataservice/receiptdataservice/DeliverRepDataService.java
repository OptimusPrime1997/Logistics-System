package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.DeliverRepPO;
import util.enumData.ResultMessage;

public interface DeliverRepDataService extends Serializable{
	public ResultMessage submit(DeliverRepPO po);
	
	public ResultMessage save(DeliverRepPO po);
	
	public ArrayList<DeliverRepPO> getAllRep();
	
	public ArrayList<DeliverRepPO> getRepByDate(String date);
	
	public DeliverRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
