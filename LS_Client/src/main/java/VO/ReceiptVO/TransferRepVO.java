package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;
import PO.ReceiptPO.TransferRepPO;
import util.enumData.*;

public class TransferRepVO extends ReceiptVO {
	public ShipForm form;
	public String carNum;
	public City city;
	public ArrayList<String> goods;
	public double money;
	
	public TransferRepVO(String num, String date, ShipForm form, String carNum, City city, ArrayList<String> goods,
			double money) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.city = city;
		this.goods = goods;
		this.money = money;
	}
	public TransferRepVO(TransferRepPO po){
		this.form = po.getForm();
		this.carNum = po.getCarNum();
		this.city = po.getCity();
		this.goods = po.getGoods();
		this.money = po.getMoney();
	}
	public static TransferRepPO toPO(TransferRepVO vo){
		return new TransferRepPO(vo.num, vo.date, vo.form, vo.carNum, vo.city, vo.goods, vo.money);
	}
	public static ArrayList<TransferRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<TransferRepVO> TransferRepVOs = new ArrayList<TransferRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			TransferRepVOs.add(new TransferRepVO((TransferRepPO) receiptPO));
		return TransferRepVOs;
	}
	
	public static ArrayList<TransferRepPO> toArrayPO(ArrayList<TransferRepVO> transferRepVOs) {
		ArrayList<TransferRepPO> transferRepPOs = new ArrayList<TransferRepPO>();
		for (TransferRepVO transferRepVO : transferRepVOs)
			transferRepPOs.add(toPO(transferRepVO));
		return transferRepPOs;
	}
}
