package dataimpl.receiptdata;

import java.util.ArrayList;

import PO.*;
import dataservice.receiptdataservice.CashRepDataService;
import util.enumData.ResultMessage;

public class CashRepData implements CashRepDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String submitFile = "/Users/apple/Desktop/Logistics-System/LS_Server/submit.txt";
	String saveFile = "/Users/apple/Desktop/Logistics-System/LS_Server/save.txt";
	ReceiptData receiptData = new ReceiptData();

	@Override
	public ResultMessage submit(ReceiptPO po) {
		// TODO Auto-generated method stub
		return receiptData.submit(po,submitFile);
	}
	
	@Override
	public ResultMessage save(ReceiptPO po) {
		// TODO Auto-generated method stub
		return receiptData.save(po, saveFile);
	}

	@Override
	public ArrayList<ReceiptPO> getAllRep() {
		// TODO Auto-generated method stub
		return receiptData.getAllRep(saveFile);
	}

	@Override
	public ArrayList<ReceiptPO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return receiptData.getRepByDate(date, saveFile);
	}

	@Override
	public ReceiptPO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return receiptData.getRepByNum(num, saveFile);
	}

	@Override
	public ResultMessage delete(int n) {
		// TODO Auto-generated method stub
		return receiptData.delete(n, saveFile);
	}

	@Override
	public ResultMessage delete(String num) {
		// TODO Auto-generated method stub
		return receiptData.delete(num, saveFile);
	}

	@Override
	public String createNum(String date) {
		// TODO Auto-generated method stub
		return receiptData.createNum(date, saveFile);
	}

}