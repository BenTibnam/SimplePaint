import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Canvas can = new Canvas();

        Thread gui = new Thread(){
            public void run(){
                JFrame mainFrame = new JFrame("Paint");
                mainFrame.setSize(500, 500);
                mainFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        System.exit(0);
                    }
                });
                mainFrame.add(can);
                mainFrame.setVisible(true);
            }
        };

        Thread painter = new Thread(){
            public void run(){
                for(;;){
                    if(can.getBrush().getHeld()){
                        can.getBrush().update();
                        can.repaint();
                    }
                }
            }
        };

        gui.start();
        painter.start();
    }
}
