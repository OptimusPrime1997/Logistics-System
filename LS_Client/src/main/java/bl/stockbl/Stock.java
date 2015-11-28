/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import ui.warehousemanui.CheckUtil;
import util.enumData.ResultMessage;
import VO.InStockRepVO;
import VO.OutStockRepVO;
import VO.StockVO;

/**
 * @author G
 *
 */
public class Stock {
	
	
	public InStockRepVO toWriteInStockRep() {
		//TODO
		return null;
	}
	
	public OutStockRepVO toWriteOutStockRep() {
		//TODO
		return null;
	}
	
	public int checkInStock(String startDate, String endDate) {
		// TODO Auto-generated method stub
		MockInStockRep rep = new MockInStockRep();
		ArrayList<InStockRepVO> reps = new ArrayList<InStockRepVO>();
		for(int i = 0;i < 10;++i) {
			reps.addAll(rep.getByDate(startDate));
		}
		return reps.size();
	}

	
	public int checkOutStock(String startDate, String endDate) {
		// TODO Auto-generated method stub
		MockOutStockRep rep = new MockOutStockRep();
		ArrayList<OutStockRepVO> reps = new ArrayList<OutStockRepVO>();
		for(int i = 0;i < 10;++i) {
			reps.addAll(rep.getbyDate(startDate));
		}
		return reps.size();
	}

	
	public int checkStockQuantity(String startDate, String endDate) {
		// TODO Auto-generated method stub
		MockInStockRep inrep = new MockInStockRep();
		ArrayList<InStockRepVO> inreps = new ArrayList<InStockRepVO>();
		for(int i = 0;i < 10;++i) {
			inreps.addAll(inrep.getByDate(startDate));
		}
		MockOutStockRep outrep = new MockOutStockRep();
		ArrayList<OutStockRepVO> outreps = new ArrayList<OutStockRepVO>();
		for(int i = 0;i < 10;++i) {
			outreps.addAll(outrep.getbyDate(startDate));
		}
		MockStockNum stocknum = new MockStockNum();
		stocknum.initial(100);
		int initialStockNum = stocknum.getInitialStockNum();
		
		return initialStockNum+inreps.size()-outreps.size();
	}

	
	public int checkPresentStockQuantity() {
		// TODO Auto-generated method stub
		//现有库存数量=初始库存数量+遍历库存的数量
//		MockStockNum stocknum = new MockStockNum();
//		int initialStockNum = stocknum.getInitialStockNum();
		
		MockStockNum stocknum = new MockStockNum();
		stocknum.initial(100);
		MockStockList list = new MockStockList();
		
		StockListItem item1 = new StockListItem();
		StockListItem item2 = new StockListItem();
		
		list.addStockListItem(item1);
		list.addStockListItem(item2);
		
		int initialStockNum = stocknum.getInitialStockNum();
		System.out.println(" initial "+initialStockNum);
		int present = list.getPresentStockList().size();
		
		return initialStockNum+present;
	}

	
	public ArrayList<StockVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
