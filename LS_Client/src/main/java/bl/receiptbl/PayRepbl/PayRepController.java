package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepBonusRepVO;
import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepRefundRepVO;
import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PayRepblService;
import blservice.receiptblservice.SubmitblService;
import util.enumData.PayThing;
import util.enumData.ShipForm;

public class PayRepController extends ReceiptblController implements PayRepblService, SubmitblService{
	private PayRepbl payRepbl = new PayRepbl();
	private PayRepCheckbl payRepCheckbl = new PayRepCheckbl();
	private Bonusbl bonusbl = new Bonusbl();
	private Courierbl courierbl = new Courierbl();
	private Driverbl driverbl = new Driverbl();
	private Freightbl freightbl = new Freightbl();
	private Refundbl refundbl = new Refundbl();
	private Rentbl rentbl = new Rentbl();
	private Staffbl staffbl = new Staffbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return payRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) 
			throws NotBoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		payRepbl.submit(vo);
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initTable() 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return payRepbl.initTable();
	}

	@Override
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO) {
		// TODO Auto-generated method stub
		bonusbl.submitBonus(payRepVO, payRepBonusRepVO);
	}

	@Override
	public Vector<Object> initBonusTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return bonusbl.initBonusTable(payRepVO);
	}

	@Override
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO) {
		// TODO Auto-generated method stub
		courierbl.submitCourier(payRepVO, payRepCourierSalaryRepVO);
	}

	@Override
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return courierbl.initCourierSalaryTable(payRepVO);
	}

	@Override
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO) {
		// TODO Auto-generated method stub
		driverbl.submitDriver(payRepVO, payRepDriverSalaryRepVO);
	}

	@Override
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return driverbl.initDriverSalaryTable(payRepVO);
	}

	@Override
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO) {
		// TODO Auto-generated method stub
		freightbl.submitFreight(payRepVO, payRepFreightRepVO);
	}

	@Override
	public Vector<Object> initFreightTable(PayRepVO payRepVO) 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		return freightbl.initFreightTable(payRepVO);
	}

	@Override
	public void submitRefund(PayRepVO payRepVO, PayRepRefundRepVO payRepRefundRepVO) {
		// TODO Auto-generated method stub
		refundbl.submitRefund(payRepVO, payRepRefundRepVO);
	}

	@Override
	public Vector<Object> initRefundTable(PayRepVO payRepVO, String date) {
		// TODO Auto-generated method stub
		return refundbl.initRefundTable(payRepVO, date);
	}

	@Override
	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO) {
		// TODO Auto-generated method stub
		rentbl.submitRent(payRepVO, payRepRentRepVO);
	}

	@Override
	public Vector<Object> initRentTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return rentbl.initRentTable(payRepVO);
	}

	@Override
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO) {
		// TODO Auto-generated method stub
		staffbl.submitStaff(payRepVO, payRepStaffSalaryRepVO);
	}

	@Override
	public Vector<Object> initStaffTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return staffbl.initStaffTable(payRepVO);
	}

	@Override
	public String getReceiverName(String num) 
			throws RemoteException, FileNotFoundException, ClassNotFoundException, NameNotFoundException,
			NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		return bonusbl.getReceiverName(num);
	}

	@Override
	public Vector<String> showBankAccount() throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return payRepbl.showBankAccount();
	}

	@Override
	public void minusMoneyInBankAccount(String bankAccount, double money) 
			throws FileNotFoundException, ClassNotFoundException, NumNotFoundException, IOException {
		// TODO Auto-generated method stub
		payRepbl.minusMoneyInBankAccount(bankAccount, money);
	}

	@Override
	public String getRefundTime(String type) {
		// TODO Auto-generated method stub
		return payRepbl.getRefundTime(type);
	}
	
	public PayRepVO getSubmitPayRep() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException{
		return payRepbl.getSubmitPayRep();
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return payRepCheckbl.initCheck();
	}

	@Override
	public PayRepRefundRepVO getRefundByDate(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs, String date) {
		// TODO Auto-generated method stub
		return refundbl.getRefundByDate(payRepRefundRepVOs, date);
	}

	@Override
	public Vector<Object> initFreightCheck(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return freightbl.initFreightCheck(payRepVO);
	}

}
