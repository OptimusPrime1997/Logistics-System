/**
 * 
 */
package VO;

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

}
