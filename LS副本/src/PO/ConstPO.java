package PO;

import java.io.Serializable;

public class ConstPO implements Serializable{
	public final static long serialVersionUID=1L;

	private int priceConst;
	private int distanceConst;
	
	public ConstPO(int priceConst,int distanceConst) {
		// TODO Auto-generated constructor stub
		this.priceConst=priceConst;
		this.distanceConst=distanceConst;
	}

	public int getPriceConst() {
		return priceConst;
	}

	public void setPriceConst(int priceConst) {
		this.priceConst = priceConst;
	}

	public int getDistanceConst() {
		return distanceConst;
	}

	public void setDistanceConst(int distanceConst) {
		this.distanceConst = distanceConst;
	}

}
