 /**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import util.CurrentTime;
import util.enumData.City;
import util.enumData.ResultMessage;
import dataservice.stockdataservice.StockDataService;
import bl.receiptbl.InStockRepbl.InStockRepController;
import bl.receiptbl.OutStockRepbl.OutStockRepController;
import PO.StockPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;
import VO.StockVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.OutStockRepVO;

/**
 * @author G
 *
 */
public class Stock {
	
	
	StockNum sn = new StockNum();
	private ArrayList<StockVO> result;
	

	private StockDataService getStockDataService() throws MalformedURLException, RemoteException, NotBoundException {
		StockDataService s = (StockDataService) Naming.lookup("stock");
		return s;
	}
	/**
	 * 根据输入的起始月日和终止月日得到这段时间内的入库数量，出库数量的总字符串，以空格隔开
	 * @param startMonth
	 * @param startDay
	 * @param endMonth
	 * @param endDay
	 * @return
	 */
	public String checkStock(String startMonth, String startDay,
			String endMonth, String endDay) {
		
		InStockRepController in = new InStockRepController();
		OutStockRepController out = new OutStockRepController();
	
		
		ArrayList<InStockRepVO> instockreps = new ArrayList<InStockRepVO>();
		ArrayList<OutStockRepVO> outstockreps = new ArrayList<OutStockRepVO>();
		
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
        
        try{
            Date dateOne = dateFormat.parse(startMonth+"-"+startDay);
            Date dateTwo = dateFormat.parse(endMonth+"-"+endDay);
             
            Calendar calendar = Calendar.getInstance();
   
            if(!checkDateValid(dateOne,dateTwo)){
    			return null;
    		}
            
            calendar.setTime(dateOne);
             
            while(calendar.getTime().compareTo(dateTwo)<=0){               
            	
                instockreps.addAll(in.getRepBydate(dateFormat.format(calendar.getTime())));
                outstockreps.addAll(out.getRepBydate(dateFormat.format(calendar.getTime())));
                
                calendar.add(Calendar.DAY_OF_MONTH, 1);               
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        

         
        int instocknum = instockreps.size();
        int outstocknum = outstockreps.size();

		 
		return instocknum+" "+outstocknum;
	}


	
	
	
	/**
	 * 得到当前库存数量，现有库存数量=初始库存数量+遍历库存的数量
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public int checkPresentStockQuantity() throws ClassNotFoundException, NotBoundException, IOException {
		
		int result = 0;
		int initialnum = sn.getInitialStockNum();
		ArrayList<StockVO> list = show();
		int presentnum = list.size();
		result = initialnum+presentnum;
		return result;
		
	
	}

	
	/**
	 * 得到本仓库当前所有有完整信息的库存
	 * @return
	 * @throws NotBoundException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<StockVO> show() throws NotBoundException, ClassNotFoundException, IOException {
		result = null;
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		
		StockDataService s = getStockDataService();
		//TODO  得到当前城市编号
		City cityNum = City.BEIJING;
		
		list = s.getStock(cityNum);
		for(StockPO po:list) {
			result.add(new StockVO().poToVo(po));
		}
		return result;
	}

	
	
	/**
	 * 检查起始日期是否在结束日期之前
	 * @param dateOne
	 * @param dateTwo
	 * @return
	 */
	private boolean checkDateValid(Date dateOne,Date dateTwo){
		Calendar calendar = Calendar.getInstance();
        
        calendar.setTime(dateOne);
         
        if(calendar.getTime().compareTo(dateTwo)<=0){
        	return true;
        }
        
        return false;
	}
	
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		InStockRepPO po = vo.toPO(vo);
		StockDataService sd = getStockDataService();
		return sd.update(po);
	}
	
	
	public ResultMessage update(OutStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		OutStockRepPO po = vo.toPO(vo);
		StockDataService sd = getStockDataService();
		return sd.update(po);
	}
	/**
	 * 得到今天的库存盘点
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<StockVO> showToday() throws ClassNotFoundException, NotBoundException, IOException {
		result = null;
		ArrayList<StockVO> list = show();
		
		String date = CurrentTime.getDate();
		
		for (StockVO vo : list) {
			if (vo.inStockDate.equals(date)) {
				result.add(vo);
			}
		}
		
		return result;
	}
	/**
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public ResultMessage exportExcel() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		
		
		
//		
//		ArrayList<StockVO> list = show();
		
		
		
		ArrayList<StockVO> list  = new ArrayList<StockVO>();
		list.add(new StockVO(null, "11111", "11112222", "2011-1-1", City.BEIJING, 20, 30));
		list.add(new StockVO(null, "2211", "1345222", "2012-1-1", City.BEIJING, 50, 40));
		list.add(new StockVO(null, "333311", "68975222", "2013-1-1", City.GUANGZHOU, 90, 70));
		
		
		if (list.isEmpty()) {
			return ResultMessage.NOT_FOUND;
		}
		
		String currentTime = CurrentTime.getTime();
	
//		return ExportToExcel.exportStockExcel(list, "/Users/G/Desktop/库存快照"+currentTime);
		return ExportToExcel.exportStockExcel(list, "/Users/G/Desktop/test");
		
		
		
	}
	
	
	public static void main(String[] args) {
		Stock s = new Stock();
		try {
	
			System.out.println(s.exportExcel());
		} catch (ClassNotFoundException | NotBoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
