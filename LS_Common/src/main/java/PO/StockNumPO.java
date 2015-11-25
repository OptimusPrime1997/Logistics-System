/**
 * 
 */
package PO;

import java.io.Serializable;

/**
 * @author G
 *
 */
public class StockNumPO implements Serializable{
	private String cityNum;
	private int initialNum;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param in    the initial number of this warehouse 
	 */
	public StockNumPO(String cn,int in) {
		cityNum=cn;
		initialNum=in;
	}

	public String getCityNum() {
		return cityNum;
	}

	public int getInitialNum() {
		return initialNum;
	}

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public void setInitialNum(int initialNum) {
		this.initialNum = initialNum;
	}
	
	
	
}
