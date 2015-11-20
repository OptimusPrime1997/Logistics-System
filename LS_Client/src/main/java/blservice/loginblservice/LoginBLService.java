package blservice.loginblservice;

import util.enumData.Authority;
import util.enumData.ResultMessage;

public interface LoginBLService {
public ResultMessage login(String accountNum,String key);
public Authority loginChoose(String accountNum);
}
