import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main{
	public static void main(String args[]){
		JFrame frame = new JFrame("Swing Draw");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Canvas c = new Canvas();
		frame.add(c);
		frame.setVisible(true);
	}
}


