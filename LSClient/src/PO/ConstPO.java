package PO;

import java.io.Serializable;

public class ConstPO implements Serializable{
	public final static long serialVersionUID=1L;
	private String twoCities;
	private double priceConst;
	private double distanceConst;
	public ConstPO(String twoCities, double priceConst, double distanceConst) {
		super();
		this.twoCities = twoCities;
		this.priceConst = priceConst;
		this.distanceConst = distanceConst;
	}
	public String getTwoCities() {
		return twoCities;
	}
	public void setTwoCities(String twoCities) {
		this.twoCities = twoCities;
	}
	public double getPriceConst() {
		return priceConst;
	}
	public void setPriceConst(double priceConst) {
		this.priceConst = priceConst;
	}
	public double getDistanceConst() {
		return distanceConst;
	}
	public void setDistanceConst(double distanceConst) {
		this.distanceConst = distanceConst;
	}
	
	

}
