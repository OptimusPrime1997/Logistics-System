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
	
}
