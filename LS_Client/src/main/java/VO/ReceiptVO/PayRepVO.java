package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepPO;

public class PayRepVO extends ReceiptVO {
	public String BankAccountNum;
	public String PayPersonNum;
	public ArrayList<LittleThingVO> littleThing;
	public ArrayList<SalaryVO> salary; 
	public ArrayList<TransferPayVO> transferPay;
	public ArrayList<RentVO> rent;
	public ArrayList<DriverSalaryVO> driverSalary;
	public ArrayList<CourierSalaryVO> courierSalary;
	public ArrayList<BonusVO> bouns;

	

	public PayRepVO(String num, String date, String bankAccountNum, String payPersonNum,
			ArrayList<LittleThingVO> littleThing, ArrayList<SalaryVO> salary, ArrayList<TransferPayVO> transferPay,
			ArrayList<RentVO> rent, ArrayList<DriverSalaryVO> driverSalary, ArrayList<CourierSalaryVO> courierSalary,
			ArrayList<BonusVO> bouns) {
		super(num, date);
		BankAccountNum = bankAccountNum;
		PayPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
		this.driverSalary = driverSalary;
		this.courierSalary = courierSalary;
		this.bouns = bouns;
	}
	
	

	public String getBankAccountNum() {
		return BankAccountNum;
	}

	public String getPayPersonNum() {
		return PayPersonNum;
	}

	public ArrayList<LittleThingVO> getLittleThing() {
		return littleThing;
	}

	public ArrayList<SalaryVO> getSalary() {
		return salary;
	}

	public ArrayList<TransferPayVO> getTransferPay() {
		return transferPay;
	}

	public ArrayList<RentVO> getRent() {
		return rent;
	}

	public ArrayList<DriverSalaryVO> getDriverSalary() {
		return driverSalary;
	}

	public ArrayList<CourierSalaryVO> getCourierSalary() {
		return courierSalary;
	}

	public ArrayList<BonusVO> getBouns() {
		return bouns;
	}

	public PayRepVO(PayRepPO po){
		this.BankAccountNum = po.getBankAccountNum();
		this.PayPersonNum = po.getPayPersonNum();
		this.littleThing = LittleThingVO.toArrayVO(po.getLittleThing());
		this.salary = SalaryVO.toArrayVO(po.getSalary());
		this.transferPay = TransferPayVO.toArrayVO(po.getTransferPay());
		this.rent = RentVO.toArrayVO(po.getRent());
		this.driverSalary = DriverSalaryVO.toArrayVO(po.getDriverSalary());
		this.courierSalary = CourierSalaryVO.toArrayVO(po.getCourierSalary());
		this.bouns = BonusVO.toArrayVO(po.getBouns());
	}
	
	public static PayRepPO toPO (PayRepVO vo){
		return new PayRepPO(vo.num, vo.date, vo.BankAccountNum, vo.PayPersonNum, 
				LittleThingVO.toArrayPO(vo.littleThing), SalaryVO.toArrayPO(vo.salary), 
				TransferPayVO.toArrayPO(vo.transferPay), RentVO.toArrayPO(vo.rent),
				DriverSalaryVO.toArrayPO(vo.driverSalary),CourierSalaryVO.toArrayPO(vo.courierSalary),
				BonusVO.toArrayPO(vo.bouns));
	}
		
	public static ArrayList<PayRepVO> toArrayVO(ArrayList<PayRepPO> payrepPOs){
		ArrayList<PayRepVO> payRepVOs  = new ArrayList<PayRepVO>();
		for(PayRepPO payRepPO : payrepPOs){
			payRepVOs.add(new PayRepVO(payRepPO));
		}
		return payRepVOs;
	}
	
	public static ArrayList<PayRepPO> toArrayPO(ArrayList<PayRepVO> payrepVOs){
		ArrayList<PayRepPO> payRepPOs  = new ArrayList<PayRepPO>();
		for(PayRepVO payRepVO : payrepVOs){
			payRepPOs.add(PayRepVO.toPO(payRepVO));
		}
		return payRepPOs;
	}
}
