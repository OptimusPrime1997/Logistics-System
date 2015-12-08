/**
 * 
 */
package PO;

import java.io.Serializable;

import util.enumData.City;

/**
 * @author G
 *
 */
public class StockNumPO implements Serializable{
	private City cityNum;
	private int initialNum;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param in    the initial number of this warehouse 
	 */
	public StockNumPO(City cn,int in) {
		cityNum=cn;
		initialNum=in;
	}

	public City getCityNum() {
		return cityNum;
	}

	public int getInitialNum() {
		return initialNum;
	}

	public void setCityNum(City cityNum) {
		this.cityNum = cityNum;
	}

	public void setInitialNum(int initialNum) {
		this.initialNum = initialNum;
	}
	
	
	
}
