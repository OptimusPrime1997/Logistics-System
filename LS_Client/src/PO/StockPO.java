/**
 * 
 */
package PO;

import java.io.Serializable;

/**
 * @author G
 *
 */
public class StockPO implements Serializable{
	
	String cityNum;
	String listNum;
	String inStockRepNum;
	String inStockDate;
	String destination;
	int block;
	int place;
	
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
	public StockPO(String cn,String ln,String rn,String d,String des,int b,int p){
		cityNum=cn;
		listNum=ln;
		inStockRepNum=rn;
		inStockDate=d;
		destination=des;
		block=b;
		place=p;
	}
	
	
	public String getCityNum() {
		return cityNum;
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
	public String getDestination() {
		return destination;
	}
	public int getBlock() {
		return block;
	}
	public int getPlace() {
		return place;
	}
	
	
}
