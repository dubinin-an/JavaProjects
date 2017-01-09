package ro.dron2004.awtTest;

import java.awt.event.*;
import javax.swing.*;
 
public class TestJFrame extends JFrame {
    public TestJFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowStateListener(new WindowStateListener() {
 
            @Override
            public void windowStateChanged(WindowEvent st) {
                if (st.getNewState() == TestJFrame.MAXIMIZED_BOTH) {
                    dispose();
                    setUndecorated(true);
                    showFrame();
                } else {
                    dispose();
                    setUndecorated(false);
                    showFrame();
                }
            }
        });
        showFrame();
    }

    private void showFrame() {
        pack();
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new TestJFrame();
    }
}