package util;

import util.enumData.ResultMessage;

public class InputCheck {
	/**
	 * 检查是否都为数字 以及长度是否正确
	 * @param num
	 * @param n
	 * @return
	 */
	public static  ResultMessage checkInputNum(String num,int n){
		if(num.length()==0) return ResultMessage.NOT_COMPLETED;
		if(num.length()==n){
			char c='\0';
			for(int i=0;i<num.length();i++){
				c=num.toCharArray()[i];
				if(!(c>='0'&&c<='9')){
					return ResultMessage.UNVALID_CHAR;
				}
			}
			return ResultMessage.VALID;
		}else{
			return ResultMessage.LENGTH_WRONG;
		}
	}
	/**
	 * 检查是否填写
	 * @param str
	 * @return
	 */
	public static ResultMessage ifWritten(String str) {
		if(str.length()==0) return ResultMessage.NOT_COMPLETED;
		else return ResultMessage.VALID;
	}
	/**
	 * 检查输入的名称是否规范
	 * @param str
	 * @return
	 */
	public static ResultMessage checkInputName(String name){
		if(name.length()==0){
			return ResultMessage.NOT_COMPLETED;
		}
		if(name.length()<=20){
			char c='\0';
			for(int i=0;i<name.length();i++){
				c=name.toCharArray()[i];
				if((c>='0'&&c<='9')){
					return ResultMessage.UNVALID_CHAR;
				}
			}
			return ResultMessage.VALID;
		}else{
			return ResultMessage.LENGTH_OVER;
		}
	}
	public static ResultMessage checkInputPhoneNum(String phoneNum){
		if(checkInputNum(phoneNum, 11)==ResultMessage.VALID){
			if(phoneNum.charAt(0)=='1'){
				return ResultMessage.VALID;
			}else{
				return ResultMessage.WRONG_FORMAT;
			}
		}else{
			return checkInputNum(phoneNum, 11);
		}
	}
	
}
