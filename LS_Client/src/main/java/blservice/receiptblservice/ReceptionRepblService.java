package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.Rep;

/**
 * @author bismuth
 *
 */
public interface ReceptionRepblService extends ReceiptblService{
	
	/**初始化表格
	 * @param rep
	 * @param num
	 * @param existOrders
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	/**该货物由于丢失，损毁导致快递过程结束
	 * @param num
	 */
	public void transferOver(String num, GoodsArrivalState goodsArrivalState);
	
	/**订单号是否存在
	 * @param order
	 * @return
	 */
	public boolean isTrueOrder(String order);
	
	/**得到出发地
	 * @param rep
	 * @param num
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NotBoundException
	 * @throws IOException
	 * @throws NumNotFoundException
	 */
	public String getDepart(Rep rep, String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;

	/**改变物流信息
	 * @param num
	 * @param goodsLogisticState
	 */
	public void changeLogistic(String num, GoodsLogisticState goodsLogisticState);
}
