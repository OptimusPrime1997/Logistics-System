package datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import util.enumData.ResultMessage;

public class DataUtility {
	
	class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream out) throws IOException {
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			return;
		}
	}
	
	public ResultMessage save(Object o, String add){
		File saveFile = new File(add);
		try {
			FileOutputStream fo = new FileOutputStream(saveFile, true);
			ObjectOutputStream os;
			if(saveFile.length()<1)
				os = new ObjectOutputStream(fo);
			else
				os = new MyObjectOutputStream(fo);
			os.writeObject(o);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		return ResultMessage.SUCCESS;
	}
	
	public ArrayList<Object> getAll(String add){
		File saveFile = new File(add);
		ArrayList<Object> objects = new ArrayList<Object>();
		try {
			FileInputStream fin = new FileInputStream(saveFile);
			ObjectInputStream is = new ObjectInputStream(fin);
			while (fin.available() > 0) {
				Object o = is.readObject();
				objects.add(o);
			}
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}  
		return objects;
	}
	
	public void clear(String add){
		File file = new File(add);
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage delete(int n, String add) {
		ArrayList<Object> objects = getAll(add);
		clear(add);
		for(int i = n;i<objects.size();i++)
			save(objects.get(i), add);
		return ResultMessage.SUCCESS;
	}
	
}
