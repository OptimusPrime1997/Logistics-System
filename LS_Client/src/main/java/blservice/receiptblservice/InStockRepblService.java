package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import VO.StockDivisionVO;
import util.enumData.City;

public interface InStockRepblService extends ReceiptblService{
	public ArrayList<StockDivisionVO> getBlock(City destination) throws NotBoundException, IOException;
}
