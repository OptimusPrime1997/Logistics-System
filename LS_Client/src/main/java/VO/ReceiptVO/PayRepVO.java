package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepPO;
import PO.ReceiptPO.TransferPayRepPO;

public class PayRepVO extends ReceiptVO {
	public double sum;
	public ArrayList<PayVO> payVOs;
	public String payPersonNum;
	public ArrayList<LittleThingRepVO> littleThing;
	public SalaryRepVO salary; 
	public TransferPayRepVO transferPay;
	public RentRepVO rent;
	public DriverSalaryRepVO driverSalary;
	public CourierSalaryRepVO courierSalary;
	public BonusRepVO bonus;
	

	public PayRepVO(String num, String date, double sum, ArrayList<PayVO> payVOs, String payPersonNum,
			ArrayList<LittleThingRepVO> littleThing, SalaryRepVO salary, TransferPayRepVO transferPay,
			RentRepVO rent,DriverSalaryRepVO driverSalary, CourierSalaryRepVO courierSalary, BonusRepVO bonus) {
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
		this.littleThing = LittleThingRepVO.toArrayVO(po.getLittleThing());
		this.salary = new SalaryRepVO(po.getSalary());
		this.transferPay = new TransferPayRepVO(po.getTransferPay());
		this.rent = new RentRepVO(po.getRent());
		this.driverSalary = new DriverSalaryRepVO(po.getDriverSalary());
		this.courierSalary = new CourierSalaryRepVO(po.getCourierSalary());
		this.bonus = new BonusRepVO(po.getBonus());
	}
	public static PayRepPO toPO(PayRepVO vo){
		return new PayRepPO(vo.num, vo.date, vo.sum, PayVO.toArrayPO(vo.payVOs), vo.payPersonNum,
				LittleThingRepVO.toArrayPO(vo.littleThing), SalaryRepVO.toPO(vo.salary),
				TransferPayRepVO.toPO(vo.transferPay), RentRepVO.toPO(vo.rent),
				DriverSalaryRepVO.toPO(vo.driverSalary), CourierSalaryRepVO.toPO(vo.courierSalary), 
				BonusRepVO.toPO(vo.bonus));
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
