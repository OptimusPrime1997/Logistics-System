/**
 * 
 */
package VO;

/**
 * @author G
 *
 */
public class StockVO {
	public String cityNum;
	public String listNum;
	public String inStockRepNum;
	public String inStockDate;
	public String destination;
	public int block;
	public int place;
	
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
	public StockVO(String cn,String ln,String rn,String d,String des,int b,int p){
		cityNum=cn;
		listNum=ln;
		inStockRepNum=rn;
		inStockDate=d;
		destination=des;
		block=b;
		place=p;
	}
}
