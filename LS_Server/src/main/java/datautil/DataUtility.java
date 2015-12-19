package datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class DataUtility implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4917823440137859978L;

	public ResultMessage save(Object o, String add) throws IOException {
		File saveFile = new File(add);
		FileOutputStream fo = new FileOutputStream(saveFile, true);
		ObjectOutputStream os;
		if (saveFile.length() < 1)
			os = new ObjectOutputStream(fo);
		else
			os = new MyObjectOutputStream(fo);
		os.writeObject(o);
		os.close();
		return ResultMessage.SUCCESS;
	}

	public ArrayList<Object> getAll(String add) throws IOException, ClassNotFoundException {
		File saveFile = new File(add);
		if (saveFile.length() < 1)
			return null;
		ArrayList<Object> objects = new ArrayList<Object>();
		FileInputStream fin = new FileInputStream(saveFile);
		ObjectInputStream is = new ObjectInputStream(fin);
		while (fin.available() > 0) {
			Object o = is.readObject();
			objects.add(o);
		}
		is.close();
		return objects;
	}
	
	public void clear(String add) throws IOException {
		File file = new File(add);
		if (file.exists())
			file.delete();
		file.createNewFile();
	}
	
	/**
	 * 传入某文件的所有待存对象和文件名，将它们存起来
	 * 
	 * @param list
	 * @param add
	 * @throws IOException
	 */
	public void SaveAll(ArrayList<Object> list, String add) throws IOException {
		clear(add);
		for (Object o : list) {
			save(o, add);
		}
	}

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

}
