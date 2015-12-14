package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.InStockRepblService;
import blservice.receiptblservice.PostReceiptblService;
import blservice.receiptblservice.SubmitblService;
import util.enumData.City;
import util.enumData.ResultMessage;

public class InStockRepController extends ReceiptblController 
implements InStockRepblService, PostReceiptblService, SubmitblService{
	private InStockRepbl inStockRepbl = new InStockRepbl();
	private InStockRepCheckbl inStockRepCheckbl = new InStockRepCheckbl();
	private InStockRepShowbl inStockRepShowbl = new InStockRepShowbl();

	@Override
	public String createNum(String date, String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.createNum(date, office);
	}

	@Override
	public InStockRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return inStockRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		inStockRepbl.submit(vo);
	}

	@Override
	public ArrayList<InStockRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, 
	IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<InStockRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.getRepByDate(date, office);
	}

	@Override
	public Vector<Object> initCheck(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return inStockRepShowbl.initShow(num);
	}

	@Override
	public String getCity(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return inStockRepbl.getCity(order);
	}

	@Override
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.getAvailableDivision(des);
	}

	@Override
	public ResultMessage delete(String listNum) 
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return inStockRepbl.delete(listNum);
	}

	@Override
	public ResultMessage update(InStockRepVO vo) 
			throws MalformedURLException, RemoteException, NotBoundException {
		// TODO Auto-generated method stub
		return inStockRepbl.update(vo);
	}

	@Override
	public ArrayList<InStockRepVO> getAllRepByDate(String date)
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return inStockRepbl.getAllRepByDate(date);
	}

}
