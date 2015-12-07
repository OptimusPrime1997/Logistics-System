package VO.ManagementVO;

public class ConstVO implements Comparable<ConstVO> {
	public String twoCities;
	public double priceConst;
	public double distanceConst;

	public ConstVO(String twoCities, double distanceConst, double priceConst) {
		super();
		this.twoCities = twoCities;
		this.priceConst = priceConst;
		this.distanceConst = distanceConst;
	}

	public int compareTo(ConstVO v) {
		// TODO Auto-generated method stub
		return twoCities.compareTo(v.twoCities);
	}

	public boolean equals(ConstVO v) {
		if (twoCities.equals(v.twoCities) && priceConst == v.priceConst
				&& distanceConst == v.distanceConst) {
			return true;
		}else {
			return false;
		}
	}
}
