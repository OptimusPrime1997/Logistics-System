package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.PayRepFreightRepPO;

public class PayRepVO extends ReceiptVO {
	public double sum;
	public ArrayList<PayVO> payVOs;
	public String payPersonNum;
	public ArrayList<PayRepRefundRepVO> littleThing;
	public PayRepStaffSalaryRepVO salary; 
	public PayRepFreightRepVO transferPay;
	public PayRepRentRepVO rent;
	public PayRepDriverSalaryRepVO driverSalary;
	public PayRepCourierSalaryRepVO courierSalary;
	public PayRepBonusRepVO bonus;
	

	public PayRepVO(String num, String date, double sum, ArrayList<PayVO> payVOs, String payPersonNum,
			ArrayList<PayRepRefundRepVO> littleThing, PayRepStaffSalaryRepVO salary, PayRepFreightRepVO transferPay,
			PayRepRentRepVO rent,PayRepDriverSalaryRepVO driverSalary, PayRepCourierSalaryRepVO courierSalary, PayRepBonusRepVO bonus) {
		super(num, date);
		this.sum = sum;
		this.payVOs = payVOs;
		this.payPersonNum = payPersonNum;
		this.littleThing = littleThing;
		this.salary = salary;
		this.transferPay = transferPay;
		this.rent = rent;
		this.driverSalary = driverSalary;
		this.courierSalary = courierSalary;
		this.bonus = bonus;
	}
	public PayRepVO (PayRepPO po){
		this.sum = po.getSum();
		this.payVOs = PayVO.toArrayVO(po.getPayPOs());
		this.payPersonNum = po.getPayPersonNum();
		this.littleThing = PayRepRefundRepVO.toArrayVO(po.getLittleThing());
		this.salary = new PayRepStaffSalaryRepVO(po.getSalary());
		this.transferPay = new PayRepFreightRepVO(po.getTransferPay());
		this.rent = new PayRepRentRepVO(po.getRent());
		this.driverSalary = new PayRepDriverSalaryRepVO(po.getDriverSalary());
		this.courierSalary = new PayRepCourierSalaryRepVO(po.getCourierSalary());
		this.bonus = new PayRepBonusRepVO(po.getBonus());
	}
	public static PayRepPO toPO(PayRepVO vo){
		return new PayRepPO(vo.num, vo.date, vo.sum, PayVO.toArrayPO(vo.payVOs), vo.payPersonNum,
				PayRepRefundRepVO.toArrayPO(vo.littleThing), PayRepStaffSalaryRepVO.toPO(vo.salary),
				PayRepFreightRepVO.toPO(vo.transferPay), PayRepRentRepVO.toPO(vo.rent),
				PayRepDriverSalaryRepVO.toPO(vo.driverSalary), PayRepCourierSalaryRepVO.toPO(vo.courierSalary), 
				PayRepBonusRepVO.toPO(vo.bonus));
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
