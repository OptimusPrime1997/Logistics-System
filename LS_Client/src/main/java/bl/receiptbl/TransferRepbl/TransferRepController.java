package bl.receiptbl.TransferRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.ConstNotFoundException;
import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;
import VO.Receipt.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.TransferRepblService;
import util.enumData.ShipForm;

public class TransferRepController extends ReceiptblController implements TransferRepblService{
	
	private TransferRepbl transferRepbl = new TransferRepbl();
	private TransferRepCheckbl transferRepCheckbl = new TransferRepCheckbl();
	private TransferRepShowbl transferRepShowbl = new TransferRepShowbl();

	@Override
	public String createNum(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.createNum(date, office);
	}

	@Override
	public TransferRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return transferRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		transferRepbl.submit(vo);
	}

	@Override
	public ArrayList<TransferRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<TransferRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getRepByDate(date, office);
	}

	@Override
	public Vector<Object> initCheck(String office)
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return transferRepShowbl.initShow(num);
	}

	@Override
	public boolean isTrueOrder(String order) {
		// TODO Auto-generated method stub
		return transferRepbl.isTrueOrder(order);
	}

	@Override
	public double getFreightMoney(String depart, String destination, double weight, ShipForm form)
			throws FileNotFoundException, ClassNotFoundException, ConstNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getFreightMoney(depart, destination, weight, form);
	}

	@Override
	public double getWeightByOrder(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return transferRepbl.getWeightByOrder(order);
	}

	@Override
	public ArrayList<TransferRepVO> getMonthRep(String date)
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return transferRepbl.getMonthRep(date);
	}

}
