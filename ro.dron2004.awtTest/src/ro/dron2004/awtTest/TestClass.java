package ro.dron2004.awtTest;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.*;
import java.awt.event.*;


public class TestClass extends Canvas {
   private int lastX, lastY;
   private int ex, ey;
   private boolean clear=false;

   public TestClass () {
	  //super.setSize(width, height);
	  
      addMouseListener(new MouseAdapter() {
         public void mousePressed(MouseEvent e) {
            lastX = e.getX();
            lastY = e.getY();
         }
      });

      addMouseMotionListener(new MouseMotionAdapter() {
         public void mouseDragged(MouseEvent e) {
            ex=e.getX();
            ey=e.getY();
            repaint();
         }
      });

      addKeyListener(new KeyAdapter() {
         public void keyTyped(KeyEvent e) {
            if (e.getKeyChar()==' ') {
               clear = true;
               repaint();
            }
         }
      });
      
      
      
      
   }

   public void update(Graphics g) {
      if (clear) {
         g.clearRect(0, 0, getWidth(), getHeight());
         clear = false;
      } else {
         g.drawLine(lastX, lastY, ex, ey);
         lastX=ex;
         lastY=ey;
      }
   }
   
   
   public static void main(String s[]) {
	   //StatusBar Top
	   
	   //Main Window
	   final Frame f = new Frame("Draw");
	   f.addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
			   f.dispose();
		   }
	   });
	   f.setSize(500, 500);
	   
	   final StatusContainer st = new StatusContainer("Press space to clear drawing!",15);
	   st.setVisible(true);
	   f.add(st);
//	   final Canvas c = new TestClass();
//	   f.add(c);
	   
/*
	   GridLayout grid =new GridLayout(3, 3);
	   grid.setHgap(15);
	   grid.setVgap(15);
	   f.setLayout(grid);

	   for (int i=0; i<8; i++) {
		   TestButton b =new TestButton ("-"+(i+1)+"-");
		   b.addMouseMotionListener(new MouseMotionListener(){
			@Override
			public void mouseDragged(MouseEvent m) {
				//System.out.println(m);

				Component b = (Button) m.getComponent();
//				Component b = m.getComponent();
				Container l = b.getParent();
				l.remove(b);

				b.setForeground(Color.blue);

			}

			@Override
			public void mouseMoved(MouseEvent m) {
				Component b = m.getComponent();
				Container l = b.getParent();
//				l.remove(b);
			}
			   
		   });
		   f.add(b);
	   }
*/
	   f.setVisible(true);
   	}
}

class TestButton extends Button {
	public TestButton(String s) {
		super(s);
	}
}


class StatusContainer extends TestClass {
	private String statusLabel = "";
	private int y;
	
	public StatusContainer (String l,int y) {
		super();
		this.statusLabel = l;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		//Серый фон
		g.setColor(new Color(0xCC, 0xCC, 0xCC));
		g.fillRect(0, 0, getWidth(), getHeight());
		//Черная полоса
		g.setColor(new Color(0x00, 0x00, 0x00));
		g.drawString(this.statusLabel, 5, this.y-3);
		g.drawLine(0, y, getWidth(), y);
	}
	
	public void setLabel (String l) {
		statusLabel = l;
		this.repaint();
	}
}