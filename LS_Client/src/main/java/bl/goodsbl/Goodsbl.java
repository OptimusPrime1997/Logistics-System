package bl.goodsbl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.CurrentTime;
import util.enumData.City;
import util.enumData.GoodsArrivalState;
import util.enumData.GoodsExpressType;
import util.enumData.GoodsLogisticState;
import util.enumData.LogType;
import util.enumData.ResultMessage;
import Exception.ExistException;
import Exception.GoodsNotFound;
import PO.GoodsPO;
import VO.GoodsVO;
import VO.LogVO;
import bl.logbl.Logbl;
import bl.loginbl.Loginbl;
import bl.managementbl.accountbl.Courierbl;
import bl.managementbl.constbl.Constbl;
import dataservice.goodsdataservice.GoodsDataService;

/*
 * 
 * 
 * (listNum, ifExaminePassed, getCourierAccount, deliverCourierAccount,
 *  startTime, overtime, destinationCity, senderName, senderAddress, 
 *  senderCompany, senderPhone, receiverName, receiverAddress, receiverCompany,
 *   receiverPhone, numOfGoods, weight, volume, nameOfInside, 
 *   expressType, moneyOfPackage, moneyTotal, moneyFare, arrivalState, 
 *   logisticState, realReceiverName, realReceiverPhone, dates)

 *   GoodsVO vo = new GoodsVO("", false, "02500106066",
 "", "2015-12-20", "", "025", "啦啦啦丽",
 "上海 浦东新区张杨路500号", "上海华润时代广场", "13587511426", "小宏宏",
 "南京 栖霞区仙林大道和园12号", null, "15500001112", 1, 5, 8, "袜子",
 GoodsExpressType.NORMAL, 1, 10, 9, GoodsArrivalState.INTACT,
 GoodsLogisticState.SENDED, null, null);
 */
public class Goodsbl {
	/*
	 * ECONOMIC NORMAL EXPRESS 18: 23: 25
	 */
	String ip = Loginbl.getIP();
	Logbl ctr_log = new Logbl();
	final double[] expressRates = { 18, 23, 25 };
	public static void main(String[] args) {
		
		/*
		 * 1北京   温冰宇 11100000000
		 * 2广州   方子阳 22200000000
		 * 3上海   任向东 33300000000
		 * 4南京   丁云亮 44400000000
		 */
		Goodsbl ctr = new Goodsbl();
		GoodsVO vo = new GoodsVO("", false, "02500106066", "", "2015-12-31", "", "", "方子阳", "广州",
				"", "22200000000", "任向东", "上海", null, "33300000000", 1, 0.5, 0.03, "贺卡",
				GoodsExpressType.NORMAL, 1, 10, 9, GoodsArrivalState.INTACT, GoodsLogisticState.SENDED, null, null,
				"2015-12-31");
		try {
			ctr.initComplete(vo);
		} catch (ExistException e) {
		}
	}

	/**
	 * 查物流信息
	 * 
	 * @param listNum
	 * @return
	 */
	public GoodsVO findByListNum(String listNum) throws GoodsNotFound {
		GoodsVO vo = null;
		try {
			GoodsPO po = getGoodsDataService().findbygoods(listNum);
			if (po == null)
				throw new GoodsNotFound();
			vo = new GoodsVO(po);
		} catch (RemoteException e) {
		}
		return vo;
	}

	public ArrayList<GoodsVO> show() {
		try {
			return GoodsVO.toVOArray(getGoodsDataService().show());
		} catch (RemoteException e) {
			return null;
		}
	}

	/**
	 * 填写新订单
	 * 
	 * @param vo
	 * @return填写的信息是否符合规格 SUCCESS
	 */
	public ResultMessage init(GoodsVO vo) {
		if (vo.expressType == null || vo.nameOfInside == null
				|| vo.receiverAddress == null || vo.receiverName == null
				|| vo.receiverPhone == null || vo.senderAddress == null
				|| vo.senderName == null || vo.senderPhone == null
				|| vo.weight == 0) {
			return ResultMessage.NOT_COMPLETED;
		}
		if (vo.numOfGoods < 0 || vo.numOfGoods > 100)
			return ResultMessage.UNREASONABLE_GOODS_NUM;
		else if (vo.receiverPhone.length() != 11
				|| vo.senderPhone.length() != 11)
			return ResultMessage.PHONE_LENGTH_WRONG;
		else if (vo.weight < 0 || vo.weight > 100)
			return ResultMessage.UNREASONABLE_WEIGHT_NUM;
		else if (vo.volume < 0 || vo.volume > 100)
			return ResultMessage.UNREASONABLE_VOLUME_NUM;

		return ResultMessage.SUCCESS;
	}

	/**
	 * 不对应用例，由init()调用
	 * 
	 * @param vo
	 * @return返回计算过费用的GoodsVO
	 */
	public GoodsVO initComplete(GoodsVO vo) throws ExistException {// TODO可能初始化失败！没有反馈给界面
		Constbl ctr_const = new Constbl();
		ResultMessage msg;
		try {
			City city1 = City.getCity(vo.receiverAddress.substring(0, 2));
			City city2 = City.getCity(vo.senderAddress.substring(0, 2));
			vo.destinationCity=City.cityToNum(city1);
			vo.startCity=City.cityToNum(city2);
			City c1, c2;
			c1 = City.getCity1(city1, city2);
			c2 = City.getCity2(city1, city2);
			double basicprice = ctr_const.findByCities(c1, c2).priceConst;
			double distance = ctr_const.findByCities(c1, c2).distanceConst;
			if (vo.listNum.length() != 10) {
				int listNum_part = getGoodsDataService().recordListNum();
				// 补齐7位
				String temp = String.format("%7d", listNum_part).replace(" ",
						"0");
				vo.listNum = vo.getCourierAccount.substring(0, 3) + temp;
			}
			vo.moneyFare = moneyCounter(vo.expressType, vo.weight, distance,
					basicprice);
			vo.moneyTotal = vo.moneyFare + vo.moneyOfPackage;
			// vo.dates=vo.startTime;
			msg = getGoodsDataService().add(GoodsVO.toPO(vo));
			// 操作成功则记录日志
			if (msg == ResultMessage.SUCCESS) {
				System.out.println("Goodsbl.添加成功");
				LogVO logvo = new LogVO(LogType.ADD_A_GOODS,
						Loginbl.getCurrentOptorId(), CurrentTime.getDate());
				ctr_log.add(logvo);
				// 记录快递员收费，，为后面算他的工资做准备
				new Courierbl()
						.updateMoney(vo.getCourierAccount, vo.moneyTotal);
			}
			// 已添加过该订单号
			if (msg.equals(ResultMessage.EXIST))
				throw new ExistException();
		} catch (Exception e) {
			System.out.println("多半是没找到常量");
		}
		System.out.println(City.getCityByNum(vo.startCity)+" ---> "+City.getCityByNum(vo.destinationCity));
		return vo;
	}

	public ResultMessage delete(GoodsVO vo) throws GoodsNotFound {
		try {
			return getGoodsDataService().delete(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		}
	}

	/**
	 * @param courierNum
	 * @return返回快递员收件的货物的VO（辅助收款单的填写）
	 */
	public ArrayList<GoodsVO> getGoodsByGetCourier(String courierNum,
			String date) {
		ArrayList<GoodsVO> vos = null;
		try {
			vos = GoodsVO.toVOArray(getGoodsDataService().findbyGetCourier(
					courierNum, date));
		} catch (RemoteException e) {
		}
		return vos;
	}

	/**
	 * 更改货物到达状态
	 * 
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setArrivalState(String listNum,
			GoodsArrivalState state, String date) {
		try {
			GoodsVO vo = findByListNum(listNum);
			vo.arrivalState = state;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		} catch (GoodsNotFound e1) {
			return ResultMessage.NOT_FOUND;
		}
	}

	/**
	 * 更改物流状态
	 * 
	 * @param listNum
	 * @param state
	 * @return
	 */
	public ResultMessage setLogisticState(String listNum,
			GoodsLogisticState state, String date) {
		try {
			GoodsVO vo = findByListNum(listNum);
			vo.logisticState = state;
			vo.dates = vo.dates + " " + date;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		} catch (GoodsNotFound e1) {
			return ResultMessage.NOT_FOUND;
		}
	}

	/**
	 * 单据审批，ifPassed=true即审批通过 否则为不通过
	 * 
	 * @param listNum
	 * @param ifPassed
	 * @return
	 */
	public ResultMessage examine(String listNum, Boolean ifPassed) {
		try {
			GoodsVO vo = findByListNum(listNum);
			vo.ifExaminePassed = ifPassed;
			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		} catch (GoodsNotFound e1) {
			return ResultMessage.NOT_FOUND;
		}
	}

	/**
	 * 收件信息录入
	 * 
	 * @param listNum
	 * @param realReceiverName
	 * @param realReceiverPhone可不填写
	 *            即传入null
	 * @return
	 */
	public ResultMessage end(String listNum, String date,
			String realReceiverName, String realReceiverPhone) {
		try {
			GoodsVO vo = findByListNum(listNum);
			if (vo.logisticState != GoodsLogisticState.DELIVERING) {
				if (vo.logisticState == GoodsLogisticState.SIGNED)
					return ResultMessage.SIGNED_ALREADY;
				else
					return ResultMessage.WRONG_LOGISTIC_STATE;
			}
			getGoodsDataService().delete(GoodsVO.toPO(vo));
			vo.deliverCourierAccount = Loginbl.getCurrentOptorId();
			vo.realReceiverName = realReceiverName;
			// 默认是本人签收
			vo.realReceiverPhone = vo.receiverPhone;
			vo.overtime = date;
			// 是代收的~
			if (realReceiverPhone.length() > 0) {
				vo.realReceiverPhone = realReceiverPhone;
			}
			vo.logisticState = GoodsLogisticState.SIGNED;
			vo.dates = vo.dates + " " + CurrentTime.getDate();

			ResultMessage msg_final = getGoodsDataService().add(
					GoodsVO.toPO(vo));
			// 操作成功则添加日志
			if (msg_final == ResultMessage.SUCCESS) {
				LogVO logvo = new LogVO(LogType.END_A_GOODS,
						Loginbl.getCurrentOptorId(), CurrentTime.getDate());
				ctr_log.add(logvo);
			}
			return msg_final;
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		} catch (GoodsNotFound e1) {
			return ResultMessage.NOT_FOUND;
		}
	}

	/**
	 * 
	 * @param listNum
	 * @return
	 */
	public ResultMessage end(String listNum, GoodsArrivalState arrivalState) {
		try {
			GoodsVO vo = findByListNum(listNum);
			vo.arrivalState = arrivalState;
			vo.logisticState = GoodsLogisticState.BROKEN_OR_LOST;
			vo.overtime = CurrentTime.getDate();

			return getGoodsDataService().modify(GoodsVO.toPO(vo));
		} catch (RemoteException e) {
			return ResultMessage.LINK_FAILURE;
		} catch (GoodsNotFound e1) {
			return ResultMessage.NOT_FOUND;
		}
	}

	/**
	 * 无需传参数，此方法自行从loginbl获取当前登录人的账号，返回快递员近日的业绩（即他经手的货物件数）
	 * 仅当月的业绩，若登录日期小于7号，则显示该月1号至当天的业绩，若大于7号，则显示近7天的业绩
	 * 
	 * @return
	 */
	public int[] get7daysNumOfGoods(int numOfDays) {
		int[] nums = new int[15];
		// initial
		for (int i = 0; i < nums.length; i++)
			nums[i] = -1;
		String date = CurrentTime.getDate();
		for (int i = 0; i < numOfDays; i++) {
			nums[i] = getGoodsByCourier(Loginbl.getCurrentOptorId(),
					CurrentTime.minusDate(date, i));
		}
		return nums;
	}

	/**
	 * 计算邮费
	 * 
	 * @param expressType
	 * @param weight
	 * @param distance
	 * @param basicPrice
	 * @return
	 */
	private int moneyCounter(GoodsExpressType expressType, double weight,
			double distance, double basicPrice) {
		double fare = 0;
		// calculate the unit price of different types
		if (expressType == GoodsExpressType.ECONOMIC)
			basicPrice = basicPrice * expressRates[0] / expressRates[1];
		else if (expressType == GoodsExpressType.EXPRESS)
			basicPrice = basicPrice * expressRates[2] / expressRates[1];
		// calculate the fare
		fare = basicPrice * distance * weight;
		return (int) fare;
	}

	/**
	 * 获得远程数据对象
	 * 
	 * @return
	 */
	private GoodsDataService getGoodsDataService() {
		GoodsDataService data = null;
		try {
			data = (GoodsDataService) Naming.lookup("rmi://" + ip
					+ ":1099/goodsServer");
		} catch (MalformedURLException e) {

		} catch (RemoteException e) {

		} catch (NotBoundException e) {

		}
		return data;
	}

	/**
	 * 
	 * @param courierNum
	 * @return返回快递员经手的所有货物的件数（包括收件和派件）
	 */
	private int getGoodsByCourier(String courierNum, String date) {
		int x = 0;
		try {
			if (getGoodsDataService() != null)
				x = getGoodsDataService().findbyCourier(courierNum, date);
		} catch (RemoteException e) {
		}
		return x;
	}

}
