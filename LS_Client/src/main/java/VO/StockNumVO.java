/**
 * 
 */
package VO;

import PO.StockNumPO;

/**
 * @author G
 *
 */
public class StockNumVO {
	public String cityNum;
	public int initialNum;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param in    the initial number of this warehouse 
	 */
	public StockNumVO(String cn,int in) {
		cityNum=cn;
		initialNum=in;
	}
	
	/**
	 * 初始化库存数量的vo转po
	 * @param vo
	 * @return
	 */
	public StockNumPO voToPo(StockNumVO vo) {
		
		StockNumPO po = new StockNumPO("", 0);
		po.setCityNum(vo.cityNum);
		po.setInitialNum(vo.initialNum);
		return po;
	}
	
	/**
	 * 初始化库存数量的po转vo
	 * @param po
	 * @return
	 */
	public StockNumVO poToVo(StockNumPO po) {
		
		StockNumVO vo = new StockNumVO("", 0);
		vo.cityNum = po.getCityNum();
		vo.initialNum = po.getInitialNum();
		return vo;
	}

}
