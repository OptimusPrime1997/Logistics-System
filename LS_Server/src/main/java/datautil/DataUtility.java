package datautil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

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
	
	/**
	 * 复制文件
	 * @param oldPath
	 * @param newPath
	 */
	public void copyFile(String oldPath, String newPath) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				int length;
				while ( (byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		}
		catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
	}

	/**
	 * 复制文件夹
	 * @param oldPath
	 * @param newPath
	 */
	public void copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹
			File a=new File(oldPath);
			String[] file=a.list();
			File temp=null;
			for (int i = 0; i < file.length; i++) {
				if(oldPath.endsWith(File.separator)){
					temp=new File(oldPath+file[i]);
				}
				else{
					temp=new File(oldPath+File.separator+file[i]);
				}
				if(temp.isFile()){
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" +
							(temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ( (len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if(temp.isDirectory()){//如果是子文件夹
					copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);
				}
			}
		}
		catch (Exception e) {
			System.out.println("复制整个文件夹内容操作出错");
			e.printStackTrace();
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
