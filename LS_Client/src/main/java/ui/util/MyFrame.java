package ui.util;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import ui.componentfactory.ComponentFactory;

public class MyFrame extends JFrame {
	private int mousePressedX;
	private int mousePressedY;

	public MyFrame(int width, int height, JPanel panel) {
		this.setSize(width, height);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		changeLook();
		this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	public MyFrame(JPanel panel) {
		this.setSize(830, 590);
		this.setContentPane(panel);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mousePressedX = e.getX();
				mousePressedY = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = (int) getLocation().getX();
				int y = (int) getLocation().getY();
				setLocation(x + e.getX() - mousePressedX, y + e.getY()
						- mousePressedY);
			}
		});
		this.setUndecorated(true);
		changeLook();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setVisible(true);
	}

	/**
	 * 更改外观
	 */
	public static void changeLook() {
		// try {
		// BeautyEyeLNFHelper.frameBorderStyle =
		// BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
		// org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
		// // 关闭右上角设置
		// UIManager.put("RootPane.setupButtonVisible", false);
		// } catch (Exception e) {
		// }
		ComponentFactory.setSystemLook();
	}

}
