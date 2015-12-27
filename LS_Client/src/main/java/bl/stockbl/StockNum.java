/**
 * 
 */
package bl.stockbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import bl.loginbl.Loginbl;
import dataservice.stockdataservice.StockInitialDataService;
import ui.warehousemanui.CheckUtil;
import util.CurrentCity;
import util.enumData.City;
import util.enumData.ResultMessage;
import PO.StockNumPO;
import VO.StockNumVO;


/**
 * @author G
 *
 */
public class StockNum {
	
	
	
	/**
	 * 由当前城市，得到初始库存数量
	 * @return
	 * @throws RemoteException 
	 */
	public int getInitialStockNum() throws RemoteException {
		City cityNum =  CurrentCity.getCurrentCity();
		int i = 0;
		try {
			StockInitialDataService si = (StockInitialDataService) Naming.lookup("rmi://"+Loginbl.getIP()+":1099/stockini");
			i = si.getInitialNum(cityNum).getInitialNum();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return i;
	}


	
	/**
	 * 初始化当前城市库存数量
	 * @param initialNum
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMessage initial(String initialNum) throws RemoteException {
		City cityNum = CurrentCity.getCurrentCity();
		if(CheckUtil.isSucceNumber(initialNum)){
			if(initialNum.length()>=10){
				
				return ResultMessage.NUMBER_OVER;
				
			}else{

				int n = Integer.parseInt(initialNum);
				StockNumVO vo = new StockNumVO(cityNum, n);
				StockNumPO po = vo.voToPo(vo);
				
				
				try {
					StockInitialDataService si = (StockInitialDataService) Naming.lookup("stockini");
					si.initial(po);
								
				} catch (Exception e) {					
					e.printStackTrace();
					return ResultMessage.FAILED;
				}
				return ResultMessage.SUCCESS;
			}
		}else {
			return ResultMessage.INPUT_SHOULD_BE_POSITIVE_INTEGER;
		}
	}
	
	

}
