package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.PayRepFreightRepPO;

public class PayRepVO extends ReceiptVO {
	public double sum;
	public ArrayList<PayVO> payVOs;
	public String payPersonNum;
	public ArrayList<PayRepRefundRepVO> refund;
	public PayRepStaffSalaryRepVO staffSalary; 
	public PayRepFreightRepVO freight;
	public PayRepRentRepVO rent;
	public PayRepDriverSalaryRepVO driverSalary;
	public PayRepCourierSalaryRepVO courierSalary;
	public PayRepBonusRepVO bonus;
	

	public PayRepVO(String num, String date, double sum, ArrayList<PayVO> payVOs, String payPersonNum,
			ArrayList<PayRepRefundRepVO> refund, PayRepStaffSalaryRepVO staffSalary, 
			PayRepFreightRepVO freight, PayRepRentRepVO rent,PayRepDriverSalaryRepVO driverSalary, 
			PayRepCourierSalaryRepVO courierSalary, PayRepBonusRepVO bonus) {
		super(num, date);
		this.sum = sum;
		this.payVOs = payVOs;
		this.payPersonNum = payPersonNum;
		this.refund = refund;
		this.staffSalary = staffSalary;
		this.freight = freight;
		this.rent = rent;
		this.driverSalary = driverSalary;
		this.courierSalary = courierSalary;
		this.bonus = bonus;
	}
	public PayRepVO (PayRepPO po){
		this.sum = po.getSum();
		this.payVOs = PayVO.toArrayVO(po.getPayPOs());
		this.payPersonNum = po.getPayPersonNum();
		this.refund = PayRepRefundRepVO.toArrayVO(po.getRefund());
		this.staffSalary = new PayRepStaffSalaryRepVO(po.getStaffSalary());
		this.freight = new PayRepFreightRepVO(po.getFreight());
		this.rent = new PayRepRentRepVO(po.getRent());
		this.driverSalary = new PayRepDriverSalaryRepVO(po.getDriverSalary());
		this.courierSalary = new PayRepCourierSalaryRepVO(po.getCourierSalary());
		this.bonus = new PayRepBonusRepVO(po.getBonus());
	}
	public static PayRepPO toPO(PayRepVO vo){
		return new PayRepPO(vo.num, vo.date, vo.sum, PayVO.toArrayPO(vo.payVOs), vo.payPersonNum,
				PayRepRefundRepVO.toArrayPO(vo.refund), PayRepStaffSalaryRepVO.toPO(vo.staffSalary),
				PayRepFreightRepVO.toPO(vo.freight), PayRepRentRepVO.toPO(vo.rent),
				PayRepDriverSalaryRepVO.toPO(vo.driverSalary), 
				PayRepCourierSalaryRepVO.toPO(vo.courierSalary), 
				PayRepBonusRepVO.toPO(vo.bonus));
	}

	public static ArrayList<PayRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs){
		ArrayList<PayRepVO> payRepVOs  = new ArrayList<PayRepVO>();
		for(ReceiptPO receiptPO : receiptPOs){
			payRepVOs.add(new PayRepVO((PayRepPO) receiptPO));
		}
		return payRepVOs;
	}
	public static ArrayList<PayRepVO> payToArrayVO(ArrayList<PayRepPO> receiptPOs){
		ArrayList<PayRepVO> payRepVOs  = new ArrayList<PayRepVO>();
		for(PayRepPO receiptPO : receiptPOs){
			payRepVOs.add(new PayRepVO(receiptPO));
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
