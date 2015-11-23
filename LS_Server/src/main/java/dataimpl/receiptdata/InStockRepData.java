package dataimpl.receiptdata;

import dataservice.receiptdataservice.InStockRepDataService;
import util.enumData.ResultMessage;

import java.util.ArrayList;
import PO.InStockRepPO;

public class InStockRepData implements InStockRepDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage submit(InStockRepPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage save(InStockRepPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InStockRepPO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InStockRepPO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InStockRepPO getRepByNum(String num) {
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
