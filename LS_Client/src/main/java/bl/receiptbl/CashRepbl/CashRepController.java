package bl.receiptbl.CashRepbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.CashRepVO;
import VO.GoodsVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.CashRepblService;
import dataservice.receiptdataservice.CashRepDataService;
import util.Excetion.NameNotFoundException;
import util.enumData.ResultMessage;

public class CashRepController extends ReceiptblController implements CashRepblService{
	private CashRepbl CashRep = new CashRepbl();

	@Override
	public ArrayList<GoodsVO> getGoods(String courierNum) {
		// TODO Auto-generated method stub
		return CashRep.getGoods(courierNum);
	}

	@Override
	public String getCourierName(String courierNum) throws NameNotFoundException, RemoteException{
		// TODO Auto-generated method stub
		return CashRep.getCourierName(courierNum);
	}

	@Override
	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		// TODO Auto-generated method stub
		return CashRep.getMoneySum(arrGoods);
	}

	@Override
	public Vector<Object> initTable(String date) throws RemoteException{
		// TODO Auto-generated method stub
		return CashRep.initTable(date);
	}
	
	public CashRepDataService getService() throws RemoteException{
		return CashRep.getCashRepDataService();
	}

	@Override
	public ResultMessage submit(CashRepVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return CashRep.submit(vo);
	}

	@Override
	public ArrayList<CashRepVO> getAllCashRep() throws RemoteException {
		// TODO Auto-generated method stub
		return CashRep.getAllRep();
	}

	@Override
	public ArrayList<CashRepVO> getRepBydate(String date) throws RemoteException {
		// TODO Auto-generated method stub
		return CashRep.getRepByDate(date);
	}

	@Override
	public String createNum(String date) {
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

	@Override
	public ReceiptVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

}
