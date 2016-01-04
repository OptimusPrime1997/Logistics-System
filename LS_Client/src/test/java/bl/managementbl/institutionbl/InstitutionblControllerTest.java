//package bl.managementbl.institutionbl;
//
//import static org.junit.Assert.*;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import org.junit.AfterClass;
//import org.junit.Test;
//
//import util.enumData.ResultMessage;
//import VO.ManagementVO.InstitutionVO;
//
//public class InstitutionblControllerTest {
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Test
//	public void test() {
//		InstitutionblController institutionblController = new InstitutionblController();
//		InstitutionVO vo = null;
//		InstitutionVO vo1 = null;
//		try {
//			ArrayList<ResultMessage> rmsgs=new ArrayList<ResultMessage>();
//			ResultMessage rmsg = ResultMessage.SUCCESS;
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"025000", "南京市中转中心","02589689341", "南京市秦淮区中山北路63号", 
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"025001", "南京栖霞区营业厅", "02589689342", "南京市栖霞区仙林大道235号",
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"025002", "南京玄武区营业厅", "02589689343", "南京市玄武区汉口路345号",
//					""));
//			rmsgs.add(rmsg);
//			
//			
//			
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"021000", "上海市中转中心","02189680211", "上海市秦淮区中山北路63号", 
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"021001", "上海栖霞区营业厅", "02189680212", "上海市栖霞区仙林大道235号",
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"021002", "上海玄武区营业厅", "02189680213", "上海市玄武区汉口路345号",
//					""));
//			rmsgs.add(rmsg);
//			
//			
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"020000", "广州市中转中心","02089680201", "广州市秦淮区中山北路63号", 
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"020001", "广州栖霞区营业厅", "02089680202", "广州市栖霞区仙林大道235号",
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"020002", "广州玄武区营业厅", "02089680203", "广州市玄武区汉口路345号",
//					""));
//			rmsgs.add(rmsg);
//			
//			
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"010000", "北京市中转中心","01089680101", "北京市秦淮区中山北路63号", 
//					""));
//			rmsgs.add(rmsg);
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"010001", "北京栖霞区营业厅", "01089680102", "北京市栖霞区仙林大道235号",
//					""));
//			rmsgs.add(rmsg);
//			
//			rmsg = institutionblController.insert(new InstitutionVO(
//					"010002", "北京玄武区营业厅", "01089680103", "北京市玄武区汉口路345号",
//					""));
//			rmsgs.add(rmsg);
//			
//			for (int i = 0; i < rmsgs.size(); i++) {
//				if(rmsgs.get(i)!=null){
//				System.out.println(rmsgs.get(i));
//				}else{
//					System.out.println("the "+(i+1)+" rsmg is null!");
//				}
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("远程连接错误");
//		}
////		try {
////			vo = institutionblController.findByInstitutionNum("025002");
////			System.out.println(vo.address);
////			assertEquals("南京市栖霞区仙林大道235号", vo.address);
////			// institutionbl.delete(vo);
////			vo1 = institutionblController.findByInstitutionName("南京市栖霞区营业厅");
////		} catch (RemoteException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (FileNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (ClassNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (InstitutionNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (NumNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} catch (NameNotFoundException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		if (vo1 != null) {
////			assertEquals("02589689345", vo1.contactInfo);
////		} else {
////			System.out.println("vo is null");
////		}
//
//	}
//		
//
//}
