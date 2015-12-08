package datautil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import util.enumData.ResultMessage;

public class DataOrdinary {
	public static ResultMessage saveOneNum(int num,String fileName){
		File file=new File(fileName+".txt");
		try {
			OutputStream fout=new FileOutputStream(file);
			DataOutputStream dataout=new DataOutputStream(fout);
			dataout.writeInt(num);
			System.out.println("write "+num);
			fout.close();
			dataout.close();
		} catch (IOException e) {
		}
		return ResultMessage.SUCCESS;
	}
	public static int getOneNum(String fileName){
		File file=new File(fileName+".txt");
		int x=0;
		try {
			InputStream fin=new FileInputStream(file);
			DataInputStream datain=new DataInputStream(fin);
			x=datain.readInt();
			fin.close();
			datain.close();
		} catch (IOException e) {
		}
		return x;
	}

}
