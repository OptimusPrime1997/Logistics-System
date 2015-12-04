package bl.receiptbl.CashRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import util.enumData.Rep;
import util.enumData.ResultMessage;
import VO.GoodsVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.managementbl.accountbl.Accountbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import Exception.*;
import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.ReceiptPO;

public class CashRepbl {

	Goodsbl goodsbl = new Goodsbl();
	Accountbl accountbl = new Accountbl();
	Receiptbl receiptbl = new Receiptbl();

	public ResultMessage checkCourierNum(String courierNum) {
		if (courierNum.length() < 11)
			return ResultMessage.REPNUM_LENGTH_LACKING;
		else if (courierNum.length() > 11)
			return ResultMessage.REPNUM_LENGTH_OVER;
		return ResultMessage.ADD_SUCCESS;
	}

	public String getCourierName(String courierNum) throws NameNotFoundException, FileNotFoundException, javax.naming.NameNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
//		return accountbl.findByAccountNum(courierNum).accountName;
		return null;
	}

	public ArrayList<GoodsVO> getGoods(String courierNum, String date) {
//		return goodsbl.getGoodsByGetCourier(courierNum, date);
		return null;
	}

	public double getMoneySum(ArrayList<GoodsVO> arrGoods) {
		double moneysum = 0;
		for (int i = 0; i < arrGoods.size(); ++i) {
			moneysum += arrGoods.get(i).moneyTotal;
		}
		return moneysum;
	}

	public void submit(ReceiptVO vo) throws NotBoundException, IOException{
		receiptbl.clearSubmit(Rep.CashRep);
		receiptbl.submit(CashRepVO.toPO((CashRepVO) vo), Rep.CashRep);
	}

	public ArrayList<CashRepVO> getAllRep() throws NotBoundException, ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getAllRep(Rep.CashRep);
		return CashRepVO.toArrayVO(receiptPOs);
	}

	public ArrayList<CashRepVO> getRepByDate(String date)
			throws NotBoundException, ClassNotFoundException, IOException {
		ArrayList<ReceiptPO> receiptPOs = receiptbl.getRepByDate(date, Rep.CashRep);
		if(receiptPOs==null)
			return null;
		return CashRepVO.toArrayVO(receiptPOs);
	}

	public CashRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		ReceiptPO receiptPO = receiptbl.getRepByNum(num, Rep.CashRep);
		return new CashRepVO((CashRepPO) receiptPO);
	}

	public void delete(int n) throws NotBoundException, ClassNotFoundException, IOException {
		receiptbl.delete(n, Rep.CashRep);
	}

	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException {
		receiptbl.delete(num, Rep.CashRep);
	}

	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		return receiptbl.createNum(date, Rep.CashRep);
	}

	public Vector<Object> initTable(String date) throws NotBoundException, ClassNotFoundException, IOException {
		
		Vector<Object> data = new Vector<Object>();
		ArrayList<CashRepVO> cashRepVOs = getRepByDate(date);
		if(cashRepVOs==null){
			return data;
		}
		CashRepVO cashRepVO = cashRepVOs.get(0);
		ArrayList<CashVO> cashs = cashRepVO.cashVOs;
		CashVO cash;
		for (int i = 0; i < cashs.size(); i++) {
			Vector<Object> arr = new Vector<Object>();
			cash = cashs.get(i);
			arr.add(cash.courierName);
			arr.add(cash.courierNum);
			arr.add(cash.money);
			arr.add(cash.remark);
			data.add(arr);
		}

		return data;
	}

}
