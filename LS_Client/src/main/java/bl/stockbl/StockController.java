/**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.StockDivisionVO;
import VO.StockVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.OutStockRepVO;
import blservice.stockblservice.StockBLService;
import blservice.stockblservice.StockDivisionBLService;
import blservice.stockblservice.StockNumBLService;

/**
 * @author G
 *
 */
public class StockController implements StockBLService,StockNumBLService,StockDivisionBLService{

	private Stock stock = new Stock();
	private StockNum ininum = new StockNum();
	private StockDivisionbl division =  new StockDivisionbl();
	
	

	
	public boolean isExist(int block, int place) throws MalformedURLException, RemoteException, NotBoundException{
		return division.isExist(block, place);
		
	}
	
	public ArrayList<Integer> getOverBlock(InStockRepVO vo) throws NotBoundException, IOException{
		return division.getOverBlock(vo);
	}
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		ResultMessage instock = stock.update(vo);
		ResultMessage indivision = division.update(vo);
		
		if(indivision.equals(ResultMessage.SUCCESS)&&instock.equals(ResultMessage.SUCCESS)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.LINK_FAILURE;
		}
	}
	
	
	public ResultMessage update(OutStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		ResultMessage outstock = stock.update(vo);
		ResultMessage outdivision = division.update(vo);
		
		if(outdivision.equals(ResultMessage.SUCCESS)&&outstock.equals(ResultMessage.SUCCESS)) {
			return ResultMessage.SUCCESS;
		}else {
			return ResultMessage.LINK_FAILURE;
		}
	}
	
	
	public boolean isPlaceAvailable(int block, int place) throws NotBoundException, IOException {
		return division.isPlaceAvailable(block, place);
	}
	
	@Override
	public int checkPresentStockQuantity() throws ClassNotFoundException, NotBoundException, IOException {
		return stock.checkPresentStockQuantity();
	}
	
	@Override
	public ArrayList<StockVO> show() throws ClassNotFoundException, NotBoundException, IOException {
		return stock.show();
	}

	
	@Override
	public InStockRepVO toWriteInStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public OutStockRepVO toWriteOutStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResultMessage initial(String input) {
		return ininum.initial(input);
		
	}
	
	public ResultMessage modifyDivision(int oldBlock, int oldPlace,
			int newBlock, int newPlace) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public ArrayList<StockDivisionVO> getBlock(String destination) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String checkStock(String startMonth, String startDay,
			String endMonth, String endDay) {
		return stock.checkStock(startMonth, startDay, endMonth, endDay);
	}
	
	
	
	
}
