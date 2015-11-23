package blservice.receiptblservice;

import java.util.ArrayList;
import java.util.Vector;

import VO.CashRepVO;
import VO.GoodsVO;
import util.enumData.ResultMessage;

public interface CashRepblService extends ReceiptblService{
	
	public ResultMessage submit(CashRepVO vo);
	
	public ArrayList<CashRepVO> getAllCashRep();
	
	public ArrayList<CashRepVO> getRepBydate(String date);
	
	public CashRepVO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
	
	public String createNum();

	/**
	 * 通过快递员编号得到快递员一天收到所有货物
	 * @param courierNum
	 * @return
	 */
	public ArrayList<GoodsVO> getGoods(String text);

	/**
	 * 通过快递员编号得到名字
	 * @param courierNum
	 * @return
	 */
	public String getCourierName(String text);

	/**
	 * 得到一批货物的总钱数
	 * @param arrGoods
	 * @return
	 */
	public double getMoneySum(ArrayList<GoodsVO> arrGoods);
	
	/**
	 * 初始化表格
	 * @return
	 */
	public Vector<Object> initTable(String date);
	
}