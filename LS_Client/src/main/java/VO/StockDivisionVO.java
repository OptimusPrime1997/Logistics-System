/**
 * 
 */
package VO;

import util.enumData.City;
import PO.StockDivisionPO;

/**
 * @author G
 *
 */
public class StockDivisionVO {
	public City cityNum;
	public String listNum;
	public City destination;
	public int block;
	public int place;
	
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param avai  state of this place
	 */
	public StockDivisionVO(City cityNum,String listNum,City des,int b,int p){
		this.cityNum = cityNum;
		this.listNum = listNum;
		destination=des;
		block=b;
		place=p;
		
	}
	
	public StockDivisionVO() {};
	
	public StockDivisionPO voToPo(StockDivisionVO vo) {
		
		StockDivisionPO po = new StockDivisionPO();
		po.setListNum(vo.listNum);
		po.setBlock(vo.block);
		po.setCityNum(vo.cityNum);
		po.setDestination(vo.destination);
		po.setPlace(vo.place);
		
		return po;
	}
	
	public StockDivisionVO poToVo(StockDivisionPO po) {
		
		StockDivisionVO vo = new StockDivisionVO();
		vo.listNum = po.getListNum();
		vo.block = po.getBlock();
		vo.cityNum = po.getCityNum();
		vo.destination = po.getDestination();
		vo.place = po.getPlace();
		
		return vo;
	}
}
