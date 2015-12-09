package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.OutStockRepPO;
import PO.ReceiptPO.ReceiptPO;
import util.enumData.*;

public class OutStockRepVO extends ReceiptVO {
<<<<<<< HEAD
	public City city;
=======
	public String destination;
>>>>>>> origin/master
	public ShipForm form;
	public Rep rep;
	public String shipNum;
	public ArrayList<String> goods;
	public OutStockRepVO(String num, String date, String destination, ShipForm form, Rep rep, 
			String shipNum, ArrayList<String> goods) {
		super(num, date);
<<<<<<< HEAD
		this.city = City;
=======
		this.destination = destination;
>>>>>>> origin/master
		this.form = form;
		this.rep = rep;
		this.shipNum = shipNum;
		this.goods = goods;
	}
	public OutStockRepVO(OutStockRepPO po){
		this.date = po.getDate();
		this.num = po.getNum();
<<<<<<< HEAD
		this.city = po.getCity();
=======
		this.destination = po.getDestination();
>>>>>>> origin/master
		this.form = po.getForm();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.goods = po.getGoods();
	}
	public static OutStockRepPO toPO(OutStockRepVO vo){
<<<<<<< HEAD
		return new OutStockRepPO(vo.num, vo.date, vo.city, vo.form, vo.rep, vo.shipNum, vo.goods);
=======
		return new OutStockRepPO(vo.num, vo.date, vo.destination, vo.form, vo.rep, vo.shipNum, vo.goods);
>>>>>>> origin/master
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
			OutStockRepPOs.add(toPO(OutStockRepVO));
		return OutStockRepPOs;
	}
}
