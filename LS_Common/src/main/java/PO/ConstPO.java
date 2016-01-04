package PO;

import java.io.Serializable;

import org.apache.poi.openxml4j.opc.PackageAccess;

import util.InputCheck;
import util.enumData.City;

public class ConstPO implements Serializable, Comparable<ConstPO> {
	public final static long serialVersionUID = 1L;
	// /**
	// * 存储两个城市名称并按拼音排序，如：南京-上海 中间横线为中文字符
	// */
	// private String twoCities;
	/**
	 * city1与city2按城市区号排序
	 */
	private City city1;
	private City city2;
	private double priceConst;
	private double distanceConst;

	public ConstPO(City city1, City city2, double distanceConst,
			double priceConst) {
		super();
		assert (city1.getIndex() != city2.getIndex()) : ("两个城市相同，出现错误");
		this.city1 = city1.getIndex() < city2.getIndex() ? city1 : city2;
		this.city2 = city1.getIndex() > city2.getIndex() ? city1 : city2;
		this.priceConst = priceConst;
		this.distanceConst = InputCheck.formatDouble(distanceConst);
	}

	public City getCity1() {
		return city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

	public double getPriceConst() {
		return priceConst;
	}

	public void setPriceConst(double priceConst) {
		this.priceConst = priceConst;
	}

	public double getDistanceConst() {
		return InputCheck.formatDouble(distanceConst);
	}

	public void setDistanceConst(double distanceConst) {
		this.distanceConst = InputCheck.formatDouble(distanceConst);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 用于表格显示排序，按编号小的城市编号排序
	 */
	@Override
	public int compareTo(ConstPO p) {
		return (city1.getIndex())-(p.getCity1().getIndex());
	}
	/**
	 * 用于查重比较
	 * @param p
	 * @return
	 */
	public boolean equals(ConstPO p){
		if(city1==p.getCity1()
				&&city2==p.getCity2()){
			return true;
		}else{
			return false;
		}
	}

}
