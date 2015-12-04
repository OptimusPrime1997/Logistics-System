package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.OutStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import util.enumData.*;

public class OutStockRepVO extends ReceiptVO {
	public place place;
	public ShipForm form;
	public Rep rep;
	public String shipNum;
	public ArrayList<String> goods;
	public OutStockRepVO(String num, String date, util.enumData.place place, ShipForm form, Rep rep, String shipNum,
			ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.form = form;
		this.rep = rep;
		this.shipNum = shipNum;
		this.goods = goods;
	}
	public OutStockRepVO(OutStockRepPO po){
		this.date = po.getDate();
		this.num = po.getNum();
		this.place = po.getPlace();
		this.form = po.getForm();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.goods = po.getGoods();
	}
	public static OutStockRepPO toPO(OutStockRepVO vo){
		return new OutStockRepPO(vo.num, vo.date, vo.place, vo.form, vo.rep, vo.shipNum, vo.goods);
	}
	public static ArrayList<OutStockRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<OutStockRepVO> OutStockRepVOs = new ArrayList<OutStockRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			OutStockRepVOs.add(new OutStockRepVO((OutStockRepPO) receiptPO));
		return OutStockRepVOs;
	}
	
	public static ArrayList<OutStockRepPO> toArrayPO(ArrayList<OutStockRepVO> OutStockRepVOs) {
		ArrayList<OutStockRepPO> OutStockRepPOs = new ArrayList<OutStockRepPO>();
		for (OutStockRepVO OutStockRepVO : OutStockRepVOs)
			OutStockRepPOs.add(OutStockRepVO.toPO(OutStockRepVO));
		return OutStockRepPOs;
	}
}
