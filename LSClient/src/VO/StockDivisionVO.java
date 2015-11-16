/**
 * 
 */
package VO;

/**
 * @author G
 *
 */
public class StockDivisionVO {
	public String cityNum;
	public String destination;
	public int block;
	public int place;
	public boolean available;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param avai  state of this place
	 */
	public StockDivisionVO(String cn,String des,int b,int p,boolean avai){
		cityNum=cn;
		destination=des;
		block=b;
		place=p;
		available=avai;
	}
}
