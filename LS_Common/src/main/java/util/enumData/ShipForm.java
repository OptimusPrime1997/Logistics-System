package util.enumData;

public enum ShipForm {
	TRUCK(1000, 10000, 20), PLANE(5000, 10000, 50), TRAIN(200000, 2000000, 1);
	/**
	 * 最大数量（个）
	 */
	private double amount;
	/**
	 * 最大重量（吨）
	 */
	private double weight;
	/**
	 * 与火车的价格比率（元每吨每公斤）/火车
	 */
	private double ratio;

	// }
	private ShipForm(double amount, double weight, double ratio) {
		this.amount = amount;
		this.weight = weight;
		this.ratio = ratio;
	}

	public double getAmount() {
		return amount;
	}

	public double getWeight() {
		return weight;
	}

	public double getRatio() {
		return ratio;
	}

	public static String toFrendlyString(ShipForm shipForm) {
		switch (shipForm) {
		case TRUCK:
			return "汽运";
		case PLANE:
			return "航运";
		case TRAIN:
			return "火车";
		default:
			return null;
		}
	}

	public static ShipForm getShipForm(String ChineseName) {
		switch (ChineseName) {
		case "汽运":
			return TRUCK;
		case "航运":
			return PLANE;
		case "火车":
			return TRAIN;
		default:
			return null;
		}
	}
}
