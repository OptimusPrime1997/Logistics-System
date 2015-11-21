package bl.receiptbl.InStockRepbl;

import java.util.ArrayList;

import VO.InStockRepVO;
import bl.receiptbl.Receiptbl.ReceiptController;
import blservice.receiptblservice.InStockRepblService;

public class InStockRepController extends ReceiptController implements InStockRepblService{
	InStockRepbl InStockRep = new InStockRepbl();

	public InStockRepVO update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return InStockRep.update(num, listNum, area, loc);
	}

	public String submit(String num, String date, int area, int loc, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return InStockRep.submit(num, date, area, loc, goods);
	}

}
