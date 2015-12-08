/**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.City;
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
	
	 

 
	public StockDivisionVO getAvailableDivision (City des) throws NotBoundException, IOException {
		return division.getAvailableDivision (des);
	}
	
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
	public ResultMessage initial(String input) throws RemoteException {
		return ininum.initial(input);
		
	}
	
	
	

	@Override
	public ArrayList<StockDivisionVO> getBlock(City destination) throws NotBoundException, IOException {
		return division.getBlock(destination);
	}
	
	
	@Override
	public String checkStock(String startMonth, String startDay, String endMonth, String endDay) {
		return stock.checkStock(startMonth, startDay, endMonth, endDay);
	}

	/* (non-Javadoc)
	 * @see blservice.stockblservice.StockDivisionBLService#modifyDivision(int, int, int, int, int, int)
	 */
	@Override
	public ResultMessage modifyDivision (int oldBlock, int oldPlace, int newBlock, int newPlace) throws ClassNotFoundException, NotBoundException, IOException {
		return division.modifyDivision(oldBlock, oldPlace, newBlock, newPlace);
	}

	/* (non-Javadoc)
	 * @see blservice.stockblservice.StockBLService#showToday()
	 */
	@Override
	public ArrayList<StockVO> showToday() throws ClassNotFoundException, NotBoundException, IOException {
		return stock.showToday();
	}

	/* (non-Javadoc)
	 * @see blservice.stockblservice.StockBLService#exportExcel()
	 */
	@Override
	public ResultMessage exportExcel() throws ClassNotFoundException, NotBoundException, IOException {
		return stock.exportExcel();
	}
	
	
	
	
}
