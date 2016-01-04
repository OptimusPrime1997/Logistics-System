package util;

import java.text.DecimalFormat;

import util.enumData.ResultMessage;

public class InputCheck {
	
	/**
	 * 检查是否都为数字 以及长度是否正确
	 * 
	 * @param num
	 * @param n
	 * @return num长度为0时返回NOT_COMPLETED; 
	 * num中有非数字时返回UNVALID_CHAR;
	 * num长度不是n时 返回LENGTH_WRONG;
	 * 合法则返回VALID;
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
	 * 检查是否是正数  （可以在数字存在小数点） 
	 * @param str
	 * @return   没写NOT_COMPLETED;
	 *           出现非数字，非小数点UNVALID_CHAR;
	 *           合法VALID;
	 */
	public static ResultMessage checkIfPositiveFloat(String str){
		if(str.length()==0){
			return ResultMessage.NOT_COMPLETED;
		}else{
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if (!((c >= '0' && c <= '9')||c=='.')) {
					return ResultMessage.UNVALID_CHAR;
				}
			}
		}
		return ResultMessage.VALID;
	}
	/**
	 * 检查是否填写
	 * 
	 * @param str
	 * @return
	 * 未填写返回NOT_COMPLETED;
	 * 填写返回VALID;
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
	 * name长度为0时，返回NOT_COMPLETED;
	 * name中出现数字   返回UNVALID_CHAR;
	 * name长度大于20  返回LENGTH_OVER;
	 * 合法则返回VALID
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
	 * 检查手机号是否合法
	 * @param phoneNum
	 * @return 
	 * phoneNum长度为0时返回NOT_COMPLETED; 
	 * phoneNum中有非数字时返回UNVALID_CHAR;
	 * phoneNum长度不是11时 返回LENGTH_WRONG; 
	 * phoneNum第一个数字不是1  返回WRONG_FORMAT;
	 * 合法则返回VALID
	 */
	public static ResultMessage checkInputPhoneNum(String phoneNum){
		if(checkInputNum(phoneNum, 11)==ResultMessage.VALID){
			if(phoneNum.charAt(0)=='1'){
				return ResultMessage.VALID;
			} else {
				return ResultMessage.WRONG_FORMAT;
			}
		} else {
			return checkInputNum(phoneNum, 11);
		}
	}

	
	/**
	 * 检查订单号是否合法
	 * @param listNum
	 * @return
	 * ListNum长度为0时返回NOT_COMPLETED; 
	 * ListNum中有非数字时返回UNVALID_CHAR;
	 * ListNum长度不是10时 返回LENGTH_WRONG;
	 * 合法则返回VALID;
	 */
	public static ResultMessage checkListNum(String listNum){
		return checkInputNum(listNum, 10);
	}
	/**
	 * 检查账号是否合法
	 * 输入的账号长度不为11，或有非数字 则返回NOT_FOUND_ACCOUNTNUM;
	 * 合法返回VALID;
	 * @param accountNum
	 * @return
	 */
	public static ResultMessage checkAccount(String accountNum){
		if(accountNum.length()==0){
			return ResultMessage.NOT_COMPLETED_ACCOUNT;
		}else if(checkInputNum(accountNum, 11)==ResultMessage.VALID){
			return ResultMessage.VALID;
		}		
		return ResultMessage.NOT_FOUND_NUM;
	}
	public static ResultMessage keyIfWritten(String key){
		if (key.length() == 0)
			return ResultMessage.NOT_COMPLETED_KEY;
		else
			return ResultMessage.VALID;
	}
	/**
	 * 检查输入的字符串是否都是数字
	 * @param str
	 * @return
	 * str长度为0时   返回NOT_COMPLETED;
	 * str有非数字时  返回UNVALID_CHAR;
	 * 合法则返回VALID;
	 */
	public static ResultMessage checkIfAllNum(String str){
		if(str.length()==0) return ResultMessage.NOT_COMPLETED;
		else{
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(c<'0'||c>'9') return ResultMessage.UNVALID_CHAR;
			}			
		}
		return ResultMessage.VALID;
		
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
		if (licenseNum.length() == 7) {
			return ResultMessage.VALID;
		} else {
			return ResultMessage.LENGTH_WRONG;
		}
	}

	/**
	 * 检查Institution contactinfo
	 * @param contactInfo
	 * @return
	 */
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
	/**
	 * 将double值转换成两位小数
	 * @param d
	 * @return
	 */
	public static double formatDouble(double d){
		DecimalFormat dcmFmt = new DecimalFormat("0.00");
		return Double.parseDouble(dcmFmt.format(d));
	}
}
