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
	
	private String cityNum;
	private String destination;
	private int block;
	private int place;
	private boolean available;
	
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

	public boolean getAvailable() {
		return available;
	}
	

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	
	
	
	
}
