package dataimpl.management.accountdata;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import util.enumData.Authority;
import util.enumData.ResultMessage;
import util.enumData.Sex;
import Exception.NumNotFoundException;
import PO.AccountPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountDataTest {
	AccountData data=null;
	public AccountDataTest() {
		// TODO Auto-generated constructor stub
		try{
			data=new AccountData();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1save()  {
		AccountPO po=new AccountPO("20150003213", "张三", "12345678", Sex.Sex_MALE, Authority.COURIER,"18293043902", "南京市栖霞区");
		try{
		data.insert(po);
		ArrayList<AccountPO> pos=data.show();
		assertEquals("张三", pos.get(pos.size()-1).getAccountName());
		System.out.println(pos.get(0).getAccountNum());
		
		}catch(RemoteException r){
			System.out.println("Remote link failed!");
		}
		
	}
	@Test
	public void test2update(){
		AccountPO po1=new AccountPO("20150003213", "李斯", "12345678", Sex.Sex_MALE, Authority.COURIER,"18293043902", "南京市栖霞区");
		try {
			ResultMessage msg=data.update(po1);
			System.out.println(msg.toString());
			if(msg==ResultMessage.SUCCESS){
				ArrayList<AccountPO> pos1=data.show();
				assertEquals("李斯", pos1.get(pos1.size()-1).getAccountName());
			}else if(msg==ResultMessage.NOT_FOUND_FILE){
				System.out.println("update failed! Not found file!");
			}else if(msg==ResultMessage.NOT_FOUND){
				System.out.println("update failed! Not found po!");
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void test3findByAccountNum(){
		AccountPO p=null;
		try {
			p=data.findByAccountNum("20150003213");
		} catch (RemoteException | FileNotFoundException | NumNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("12345678", p.getPassword());
	}
	@Test
	public void test4findByAccountName(){
		AccountPO p=null;
				try {
					p=data.findByName("李斯");
				} catch (RemoteException | FileNotFoundException
						| NameNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		assertEquals("20150003213", p.getAccountNum());
		}
	public void test5delete(){
		AccountPO po1=new AccountPO("20150003213", "李斯", "12345678", Sex.Sex_MALE, Authority.COURIER,"18293043902", "南京市栖霞区");
		try {
			data.delete(po1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
