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
	private City cityNum;
	private String listNum;
	private City destination;
	private int block;
	private int place;
	
	
	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param des   destination of this place
	 * @param b	    block to which this place belongs
	 * @param p	    number of this place
	 * @param listnum 本地城市
	 */
	public StockDivisionPO(City cityNum, String listNum, City des,int b,int p){
		this.cityNum = cityNum;
		this.listNum = listNum;
		destination=des;
		block=b;
		place=p;
		
	}

	
	public City getCityNum() {
		return cityNum;
	}


	public void setCityNum(City cityNum) {
		this.cityNum = cityNum;
	}


	public StockDivisionPO(){
		
	}
	public String getListNum() {
		return listNum;
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

	

	public void setListNum(String listNum) {
		this.listNum = listNum;
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
