import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements KeyListener, ActionListener{
	private Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, new Color(34, 212, 112), Color.PINK};
	private Color currColor = colors[0];
	private int up = KeyEvent.VK_W;
	private int down = KeyEvent.VK_S;
	private int left = KeyEvent.VK_A;
	private int right = KeyEvent.VK_D;
	private int esc = KeyEvent.VK_ESCAPE;
	private int brushUp = KeyEvent.VK_RIGHT;
	private int brushDown = KeyEvent.VK_LEFT;
	private int brushSize = 20;
	private int brushX = 0;
	private int brushY = 0;
	
	public Canvas(){
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		repaint();
	}
	
	public void moveLeft(){
		brushX--;
	}
	
	public void moveRight(){
		brushX++;
	}
	
	public void moveUp(){
		brushY--;
	}
	
	public void moveDown(){
		brushY++;
	}
	
	public void paint(Graphics g){
		// brush
		g.setColor(currColor);
		g.fillOval(brushX, brushY, brushSize, brushSize);
		g.dispose();
	}
	
	@Override
	public void keyPressed(KeyEvent ke){
		int keyCode = ke.getKeyCode();
		if(keyCode == esc) System.exit(0);
		if(keyCode == KeyEvent.VK_1) currColor = colors[0];
		if(keyCode == KeyEvent.VK_2) currColor = colors[1];
		if(keyCode == KeyEvent.VK_3) currColor = colors[2];
		if(keyCode == KeyEvent.VK_4) currColor = colors[3];
		if(keyCode == KeyEvent.VK_5) currColor = colors[4];
		if(keyCode == KeyEvent.VK_6) currColor = colors[5];
		if(keyCode == KeyEvent.VK_7) currColor = colors[6];
		if(keyCode == KeyEvent.VK_8) currColor = colors[7];
		if(keyCode == up) moveUp();
		if(keyCode == down) moveDown();
		if(keyCode == left) moveLeft();
		if(keyCode == right) moveRight();
		if(keyCode == brushUp) brushSize++;
		if(keyCode == brushDown) brushSize--;
		
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent ke){
	
	}
	
	@Override
	public void keyReleased(KeyEvent ke){
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
	
	}
}