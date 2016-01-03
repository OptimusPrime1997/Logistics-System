package ui.util;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BoundedRangeModel;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;
public class MyProgressBar extends JProgressBar {
 
    private class GyrProgressUI extends BasicProgressBarUI {
 
        private double greenOverPercent=(2d/3d)*100d;
 
        private double yellowOverPercent=(1d/3d)*100d;
 
        private JProgressBar jProgressBar;
 
        private GyrProgressUI(JProgressBar jProgressBar) {
            this.jProgressBar = jProgressBar;
        }
 
        @Override
        protected void paintDeterminate(Graphics g, JComponent c) {
 
 
            double percent=100d*this.jProgressBar.getValue()/(this.jProgressBar.getMaximum()-this.jProgressBar.getMinimum());
 
            if (percent > this.greenOverPercent) {
                this.jProgressBar.setForeground(new Color(0 ,255 ,0));
            } else if (percent > this.yellowOverPercent) {
                this.jProgressBar.setForeground(Color.yellow);
            } else {
                this.jProgressBar.setForeground(new Color(122 ,197 ,205));
            }
            super.paintDeterminate(g, c);
        }
 
    }
 
    public MyProgressBar() {
        init();
    }
 
    public MyProgressBar(int orient) {
        super(orient);
        init();
    }
 
    public MyProgressBar(int min, int max) {
        super(min, max);
        init();
    }
 
    public MyProgressBar(int orient, int min, int max) {
        super(orient, min, max);
        init();
    }
 
    public MyProgressBar(BoundedRangeModel newModel) {
        super(newModel);
        init();
    }
 
    private void init(){
        this.setBorderPainted(false);
        this.setUI(new GyrProgressUI(this));
    }
}