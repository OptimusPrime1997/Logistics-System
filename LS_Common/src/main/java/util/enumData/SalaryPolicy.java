package util.enumData;

public enum SalaryPolicy {
	/**
	 * 固定薪水
	 */
	BASE_SALARY(0, "固定薪水"), /**
	 * 计次薪水
	 */
	FREQUENCY_SALARY(1, "计次薪水"), /**
	 * 计件提成薪水
	 */
	SHARE_SALARY(2, "计件提成薪水");
	final private int index;
	final private String value;
	final public static int SALARYPOLICY_NUM = 3;

	/**
	 * 将Authority转换为对应String
	 * 
	 * @param salaryPolicy
	 * @return
	 */
	private SalaryPolicy(int index, String value) {
		this.index = index;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	public static String toString(SalaryPolicy salaryPolicy) {
		if (salaryPolicy == null) {
			return "";
		}
		switch (salaryPolicy) {
		case BASE_SALARY:
			return "固定薪水";
		case FREQUENCY_SALARY:
			return "计次薪水";
		case SHARE_SALARY:
			return "计件提成薪水";
		default:
			return "";
		}
	}

	/**
	 * 将string转换成对应的Authority
	 * 
	 * @param str
	 * @return
	 */
	public static SalaryPolicy toSalaryPolicy(String str) {
		// TODO Auto-generated method stub
		assert (str != null) : ("由于string为空，String to SalaryPolicy失败");
		assert (str.length() > 0) : ("String 空白，String to SalaryPolicy失败");
		switch (str) {
		case "固定薪水":
			return BASE_SALARY;
		case "计次薪水":
			return FREQUENCY_SALARY;
		case "计件提成薪水":
			return SHARE_SALARY;
		default:
			return null;
		}
	}

	/**
	 * 通过数字index来获得SalaryPolicy
	 * 
	 * @param index
	 * @return
	 */
	public static SalaryPolicy getSalaryPolicy(int index) {
		switch (index) {
		case 0:
			return SalaryPolicy.BASE_SALARY;
		case 1:
			return SalaryPolicy.FREQUENCY_SALARY;
		case 2:
			return SalaryPolicy.SHARE_SALARY;
		default:
			return null;
		}
	}
}
