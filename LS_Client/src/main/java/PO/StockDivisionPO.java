/**
 * 
 */
package PO;

import java.io.Serializable;

/**
 * @author G
 *
 */
public class StockDivisionPO implements Serializable{
	
	String cityNum;
	String destination;
	int block;
	int place;
	boolean available;
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param avai  state of this place
	 */
	public StockDivisionPO(String cn,String des,int b,int p,boolean avai){
		cityNum=cn;
		destination=des;
		block=b;
		place=p;
		available=avai;
	}

	public String getCityNum() {
		return cityNum;
	}

	public String getDestination() {
		return destination;
	}

	public int getBlock() {
		return block;
	}

	public int getPlace() {
		return place;
	}

	public boolean isAvailable() {
		return available;
	}
	
	
	
}
