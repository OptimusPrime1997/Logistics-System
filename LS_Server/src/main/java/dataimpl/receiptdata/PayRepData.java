package dataimpl.receiptdata;

import java.util.ArrayList;

import PO.*;

import dataservice.receiptdataservice.PayRepDataService;
import util.enumData.ResultMessage;

public class PayRepData implements PayRepDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage submit(PayRepPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(PayRepPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayRepPO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayRepPO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayRepPO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String num) {
		// TODO Auto-generated method stub
		return null;
	}


}
