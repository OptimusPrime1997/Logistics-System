package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.PayRepPO;
import util.enumData.ResultMessage;

public interface PayRepDataService extends Serializable{
	public ResultMessage submit(PayRepPO po);
	
	public ResultMessage save(PayRepPO po);
	
	public ArrayList<PayRepPO> getAllRep();
	
	public ArrayList<PayRepPO> getRepByDate(String date);
	
	public PayRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
