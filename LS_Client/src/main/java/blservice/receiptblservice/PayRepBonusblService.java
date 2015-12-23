package blservice.receiptblservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.Receipt.PayRepBonusRepVO;
import VO.Receipt.PayRepVO;

/**
 * @author bismuth
 *
 */
public interface PayRepBonusblService extends PayThingblService, PreReceiptblService{

	/**
	 * 提交奖金付款单
	 * 
	 * @param payRepVO
	 * @param payRepBonusRepVO
	 */
	public void submitBonus(PayRepVO payRepVO, PayRepBonusRepVO payRepBonusRepVO);

	/**
	 * 初始化奖金付款单表格
	 * 
	 * @param payRepVO
	 * @return
	 */
	public Vector<Object> initBonusTable(PayRepVO payRepVO);

	/**
	 * 根据人员编号得到奖金获得者名字
	 * 
	 * @param num
	 * @return
	 * @throws RemoteException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws NameNotFoundException
	 * @throws NumNotFoundException
	 * @throws IOException
	 */
	public String getReceiverName(String num) throws RemoteException, FileNotFoundException, ClassNotFoundException,
			NameNotFoundException, NumNotFoundException, IOException;

}
