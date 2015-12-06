package util;

import util.enumData.ResultMessage;

public class InputCheck {
	/**
	 * 检查是否都为数字 以及长度是否正确
	 * 
	 * @param num
	 * @param n
	 * @return
	 */
	public static ResultMessage checkInputNum(String num, int n) {
		if (num.length() == 0)
			return ResultMessage.NOT_COMPLETED;
		if (num.length() == n) {
			char c = '\0';
			for (int i = 0; i < num.length(); i++) {
				c = num.toCharArray()[i];
				if (!(c >= '0' && c <= '9')) {
					return ResultMessage.UNVALID_CHAR;
				}
			}
			return ResultMessage.VALID;
		} else {
			return ResultMessage.LENGTH_WRONG;
		}
	}

	/**
	 * 检查是否填写
	 * 
	 * @param str
	 * @return
	 */
	public static ResultMessage ifWritten(String str) {
		if (str.length() == 0)
			return ResultMessage.NOT_COMPLETED;
		else
			return ResultMessage.VALID;
	}

	/**
	 * 检查输入的名称是否规范
	 * 
	 * @param str
	 * @return
	 */
	public static ResultMessage checkInputName(String name) {
		if (name.length() == 0) {
			return ResultMessage.NOT_COMPLETED;
		}
		if (name.length() <= 20) {
			char c = '\0';
			for (int i = 0; i < name.length(); i++) {
				c = name.toCharArray()[i];
				if ((c >= '0' && c <= '9')) {
					return ResultMessage.UNVALID_CHAR;
				}
			}
			return ResultMessage.VALID;
		} else {
			return ResultMessage.LENGTH_OVER;
		}
	}

	/**
	 * 检查电话号码是否是11位，首位是否是1
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static ResultMessage checkInputPhoneNum(String phoneNum) {
		if (checkInputNum(phoneNum, 11) == ResultMessage.VALID) {
			if (phoneNum.charAt(0) == '1') {
				return ResultMessage.VALID;
			} else {
				return ResultMessage.WRONG_FORMAT;
			}
		} else {
			return checkInputNum(phoneNum, 11);
		}
	}

	public static ResultMessage checkListNum(String listNum) {
		return checkInputNum(listNum, 10);
	}

	/**
	 * 8位 第一位是否为1或2 月份 天数
	 * 
	 * @param date
	 * @return VAILD WRONG
	 */
	public static ResultMessage checkInputDate(String date) {
		int month = Integer.parseInt(date.substring(4, 6));
		int day = Integer.parseInt(date.substring(6, 8));
		if (date.length() == 8
				&& (date.charAt(0) == '1' || date.charAt(0) == '2')
				&& month <= 12 && month >= 1 && day >= 1 && day <= 31) {
			return ResultMessage.VALID;
		} else {
			return ResultMessage.WRONG;
		}
	}

	/**
	 * 检查车辆车牌号，是否为6位
	 * 
	 * @param licenseNum
	 * @return
	 */
	public static ResultMessage checkLicenseNum(String licenseNum) {
		if (licenseNum.length() == 6) {
			return ResultMessage.VALID;
		} else {
			return ResultMessage.LENGTH_WRONG;
		}
	}

	public static ResultMessage checkContactInfo(String contactInfo) {
		if (contactInfo.length() == 11) {
			if (contactInfo.charAt(0) == '0') {
				return ResultMessage.VALID;
			} else {
				return ResultMessage.WRONG_DATA;
			}
		} else {
			return ResultMessage.LENGTH_WRONG;
		}
	}
}
