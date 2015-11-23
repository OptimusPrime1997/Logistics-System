package dataimpl.receiptdata;

import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.GetRepPO;
import dataservice.receiptdataservice.GetRepDataService;

public class GetRepData implements GetRepDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<GetRepPO> GetRepSave = new ArrayList<GetRepPO>();

	@Override
	public ResultMessage submit(GetRepPO po) {
		// TODO Auto-generated method stub
		GetRepSave.add(po);
		return null;
	}
	
	@Override
	public ResultMessage save(GetRepPO po) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<GetRepPO> getAllRep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GetRepPO> getRepByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetRepPO getRepByNum(String num) {
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
