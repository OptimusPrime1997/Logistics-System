/**
 * 
 */
package VO;

import PO.StockPO;

/**
 * @author G
 *
 */
public class StockVO {
	public String cityNum;
	public String listNum;
	public String inStockRepNum;
	public String inStockDate;
	public String destination;
	public int block;
	public int place;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param ln    number of this list
	 * @param rn    inStockRepNum of this list
	 * @param d     date when this list in
	 * @param des   destination of this list
	 * @param b     block where this list is
	 * @param p     place where this list is 
	 */
	public StockVO(String cn,String ln,String rn,String d,String des,int b,int p){
		cityNum=cn;
		listNum=ln;
		inStockRepNum=rn;
		inStockDate=d;
		destination=des;
		block=b;
		place=p;
	}
	
	/**
	 * 库存的vo转po
	 * @param vo
	 * @return
	 */
	public StockPO voToPO(StockVO vo) {
		
		
		StockPO po = new StockPO("","","","","",0,0);
		po.setBlock(vo.block);
		po.setCityNum(vo.cityNum);
		po.setDestination(vo.destination);
		po.setInStockDate(vo.inStockDate);
		po.setInStockRepNum(vo.inStockRepNum);
		po.setListNum(vo.listNum);
		po.setPlace(vo.place);
		
		return po;
		
	}
	
	public StockVO poToVo(StockPO po) {
		
		StockVO vo = new StockVO("", "", "", "", "", 0, 0);
		
		vo.block = po.getBlock();
		vo.cityNum = po.getCityNum();
		vo.destination = po.getDestination();
		vo.inStockDate = po.getInStockDate();
		vo.inStockRepNum = po.getInStockRepNum();
		vo.listNum = po.getListNum();
		vo.place = po.getPlace();
		
		return vo;
	}
}
