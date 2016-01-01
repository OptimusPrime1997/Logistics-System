package ui.util;

import java.awt.Color;
import java.text.ParseException;
import java.util.StringTokenizer;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

public class MyFormattedTextFeild extends JFormattedTextField {
	/**
	 * MyTextField(TextType type,int x,int y,int width, int height){
	 * setBounds(x, y, width, height);
	 * 
	 * switch(type){ case FEEDBACK: setHorizontalAlignment(JTextField.CENTER);
	 * setForeground(Color.magenta); setEditable(false);
	 */
	private static final long serialVersionUID = 1L;

	public MyFormattedTextFeild(FormatedText type, int x, int y, int width,
			int height) {
		// TODO Auto-generated constructor stub
		setBounds(x, y, width, height);
		switch (type) {
		case IP:
			setFormatter(new IPAddressFormatter());
			setInputVerifier(new FormattedTextFieldVerifier());
			
			setHorizontalAlignment(JTextField.CENTER);
			setForeground(Color.magenta);
			setEditable(true);
			break;
		default:
			break;
		}
	}

	public MyFormattedTextFeild(int k) {

		assert (k > 0) : ("MyFormattedTextFeild premeter num less or equal than 0");
		String str = "";
		for (int i = 0; i < k; i++) {
			str += "#";
		}
		MaskFormatter formatter;
		try {
			formatter = new MaskFormatter(str);
			formatter.setPlaceholderCharacter('0');
			setFormatter(formatter);
			setDocument(new NumOnlyDocument());
			setInputVerifier(new FormattedTextFieldVerifier());
			
			setHorizontalAlignment(JTextField.CENTER);
			setForeground(Color.magenta);
			setEditable(true);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MyFormattedTextFeild(int k, int x, int y, int width, int height) {
		setBounds(x, y, width, height);
		new MyFormattedTextFeild(k);
	}
//	JFormattedTextField intField = new JFormattedTextField(NumberFormat.getIntegerInstance());
//	intField.setInputVerifier(new FormattedTextFieldVerifier());
//
//	//定义一个InputVerifier类，把这个类添加到JFormattedTextField中

	class IPAddressFormatter extends DefaultFormatter {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public String valueToString(Object value) throws ParseException {
			if (!(value instanceof byte[]))
				throw new ParseException("Not a byte[]", 0);
			byte[] a = (byte[]) value;
			if (a.length != 4)
				throw new ParseException("Length != 4", 0);
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < 4; i++) {
				int b = a[i];
				if (b < 0)
					b += 256;
				builder.append(String.valueOf(b));
				if (i < 3)
					builder.append('.');
			}
			return builder.toString();
		}

		public Object stringToValue(String text) throws ParseException {
			StringTokenizer tokenizer = new StringTokenizer(text, ".");
			byte[] a = new byte[4];
			for (int i = 0; i < 4; i++) {
				int b = 0;
				if (!tokenizer.hasMoreTokens())
					throw new ParseException("Too few bytes", 0);
				try {
					b = Integer.parseInt(tokenizer.nextToken());
				} catch (NumberFormatException e) {
					throw new ParseException("Not an integer", 0);
				}
				if (b < 0 || b >= 256)
					throw new ParseException("Byte out of range", 0);
				a[i] = (byte) b;
			}
			if (tokenizer.hasMoreTokens())
				throw new ParseException("Too many bytes", 0);
			return a;
		}
	}
	class FormattedTextFieldVerifier extends InputVerifier
	{
	   public boolean verify(JComponent component)
	   {
	      JFormattedTextField field = (JFormattedTextField) component;
	      //若用户的输入符合格式，则返回true，否则返回false
	      return field.isEditValid();
	   }
	}
}
