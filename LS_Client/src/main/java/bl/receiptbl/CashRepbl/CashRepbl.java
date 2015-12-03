package bl.receiptbl.CashRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import util.enumData.Rep;
import util.enumData.ResultMessage;
import VO.GoodsVO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.ReceiptVO;
import bl.goodsbl.Goodsbl;
import bl.receiptbl.Receiptbl.Receiptbl;
import Exception.*;
import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.ReceiptPO;

public class CashRepbl {

	public static void main(String[] args) {
		ArrayList<CashVO> cashVOs = new ArrayList<CashVO>();
		cashVOs.add(new CashVO(1, "141250001", "a", "aaa"));
		cashVOs.add(new CashVO(2, "141250002", "b", "bbb"));
		CashRepbl cashRepbl = new CashRepbl();
		try {
			cashRepbl.submit(new CashRepVO("1234567890", "2015-12-2", cashVOs, 3));
		} catch (NotBoundException | IOException e) {
			e.printStackTrace();
		}
	}

	Goodsbl goodsbl = new Goodsbl();
//	Accountbl accountbl = new Accountbl();
	Receiptbl receiptbl = new Receiptbl();

	public ResultMessage checkCourierNum(String courierNum) {
		if (courierNum.length() < 11)
			return ResultMessage.REPNUM_LENGTH_LACKING;
		else if (courierNum.length() > 11)
			return ResultMessage.REPNUM_LENGTH_OVER;
		return ResultMessage.SUCCESS;
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
		CashRepVO cashRepVO = getRepByDate(date).get(0);
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
