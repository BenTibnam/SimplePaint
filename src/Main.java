import com.sun.xml.internal.ws.api.message.Message;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Canvas can = new Canvas();
        final JFrame mainFrame = new JFrame("Paint");
        mainFrame.setVisible(true);

        Thread gui = new Thread(){
            public void run(){
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
                  while(can.getBrush().getHeld()){
                      can.repaint();
                  }

                    if(!mainFrame.isVisible()) System.exit(0);
                }
            }
        };

        Thread variableBox = new Thread(){
            MessageWindow mw = new MessageWindow("Variable Box(Debugging Only)", "Held: "+can.getBrush().getHeld() + "Color: " + can.getBrush().getCurColor());
            public void run(){
                mw.setUp();
                mw.display();
                for(;;){
                    // updating debug box
                    mw.setText("<html><body>Held: " + can.getBrush().getHeld()  + "<br/>Color: " + can.getBrush().getCurColor() + "</body></html>");
                }
            }
        };


        gui.start();
        painter.start();
        variableBox.start();
    }
}
