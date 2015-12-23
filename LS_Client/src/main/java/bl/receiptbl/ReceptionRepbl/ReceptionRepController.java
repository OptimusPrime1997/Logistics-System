package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.GoodsNotFound;
import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsLogisticState;
import util.enumData.Rep;

public class ReceptionRepController extends ReceiptblController implements ReceptionRepblService{
	private ReceptionRepbl receptionRepbl = new ReceptionRepbl();
	private ReceptionRepCheckbl receptionRepCheckbl = new ReceptionRepCheckbl();
	private ReceptionRepShowbl receptionRepShowbl = new ReceptionRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepbl.createNum(date, office);
	}

	@Override
	public ReceptionRepVO getRepByNum(String num)
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		receptionRepbl.submit(vo);
	}

	@Override
	public ArrayList<ReceptionRepVO> getAllRep(String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepbl.getAllRep(office);
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepShowbl.initShow(num);
	}

	@Override
	public Vector<Object> initTable(Rep rep, String num, ArrayList<String> existOrders) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepbl.initTable(rep, num, existOrders);
	}

	@Override
	public void transferOver(String num, GoodsArrivalState goodsArrivalState) {
		// TODO Auto-generated method stub
		receptionRepbl.transferOver(num, goodsArrivalState);
	}

	@Override
	public String getDepart(Rep rep, String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return receptionRepbl.getDepart(rep, num);
	}

	@Override
	public boolean isTrueOrder(String order) {
		// TODO Auto-generated method stub
		return receptionRepbl.isTrueOrder(order);
	}

	@Override
	public void changeLogistic(String num, GoodsLogisticState goodsLogisticState) {
		// TODO Auto-generated method stub
		receptionRepbl.changeLogistic(num, goodsLogisticState);
	}

	@Override
	public String getDestination(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return receptionRepbl.getDestination(order);
	}

	@Override
	public String getDepart(String order) throws GoodsNotFound {
		// TODO Auto-generated method stub
		return receptionRepbl.getDepart(order);
	}

}
