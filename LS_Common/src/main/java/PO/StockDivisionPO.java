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
public class StockDivisionPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2717252400399634569L;
	private City listNum;
	private String cityNum;
	private City destination;
	private int block;
	private int place;
	
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param avai  state of this place
	 */
	public StockDivisionPO(City listnum, String cn, City des,int b,int p){
		this.listNum = listnum;
		cityNum=cn;
		destination=des;
		block=b;
		place=p;
		
	}

	
	public City getListnum() {
		return listNum;
	}


	public void setListnum(City listnum) {
		this.listNum = listnum;
	}


	public StockDivisionPO(){
		
	}
	public String getCityNum() {
		return cityNum;
	}

	public City getDestination() {
		return destination;
	}

	public int getBlock() {
		return block;
	}

	public int getPlace() {
		return place;
	}

	

	public void setCityNum(String cityNum) {
		this.cityNum = cityNum;
	}

	public void setDestination(City destination) {
		this.destination = destination;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public void setPlace(int place) {
		this.place = place;
	}


	
	
	
	
}
