package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

public interface ShipmentRepblServce extends ReceiptblService{
	
	public String getTruckSum(String date) throws ClassNotFoundException, NotBoundException, IOException;
    /**
     * 根据营业厅编号 日期  得到那天的该营业厅的装车单总数
     * @param num
     * @param date
     * @return
     */
	public int getSumByBusiOfficerNum(String num,String date);
}
