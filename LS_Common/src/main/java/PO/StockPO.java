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
public class StockPO implements Serializable{
	
	private City localCity;
	private String listNum;
	private String inStockRepNum;
	private String inStockDate;
	private City destination;
	private int block;
	private int place;
	

	/**
	 * 
	 * @param cn    id of this warehouse
	 * @param ln    number of this list
	 * @param rn    inStockRepNum of this list
	 * @param d     date when this list in
	 * @param des   destination of this list
	 * @param b     block where this list is
	 * @param p     place where this list is 
	 */
	
	public StockPO(City cn,String ln,String rn,String d,City des,int b,int p){
		localCity=cn;
		listNum=ln;
		inStockRepNum=rn;
		inStockDate=d;
		destination=des;
		block=b;
		place=p;
	}
	
	
	public City getCityNum() {
		return localCity;
	}
	public String getListNum() {
		return listNum;
	}
	public String getInStockRepNum() {
		return inStockRepNum;
	}
	public String getInStockDate() {
		return inStockDate;
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
	

	public void setCityNum(City localCity) {
		this.localCity = localCity;
	}


	public void setListNum(String listNum) {
		this.listNum = listNum;
	}


	public void setInStockRepNum(String inStockRepNum) {
		this.inStockRepNum = inStockRepNum;
	}


	public void setInStockDate(String inStockDate) {
		this.inStockDate = inStockDate;
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
