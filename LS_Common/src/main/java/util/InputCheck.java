package util;

import util.enumData.ResultMessage;

public class InputCheck {
	public static  ResultMessage checkInputNum(String num,int n){
		if(num.length()==0) return ResultMessage.NOT_COMPLETED;
		if(num.length()==n){
			char c='\0';
			for(int i=0;i<num.length();i++){
				c=num.toCharArray()[i];
				if(!(c>='0'&&c<='9')){
					return ResultMessage.WRONG;
				}
			}
			return ResultMessage.SUCCESS;
			
		}else{
			return ResultMessage.WRONG;
		}
	}
}
