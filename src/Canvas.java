import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Canvas extends JPanel implements ActionListener, KeyListener, MouseListener{
    private Brush brush;


    public Canvas(){
        this.brush = new Brush();
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    public void paint(Graphics g){
        g.setColor(this.brush.getCurColor());
        g.fillOval(this.brush.getX(), this.brush.getY()-65, this.brush.getSize(), this.brush.getSize());
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            this.brush.setHeld(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            this.brush.setHeld(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseEvent.BUTTON1){
            this.brush.setHeld(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.brush.setHeld(false);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_1) this.brush.changeColor(0);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_2) this.brush.changeColor(1);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_3) this.brush.changeColor(2);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_4) this.brush.changeColor(3);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_5) this.brush.changeColor(4);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_6) this.brush.changeColor(5);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_7) this.brush.changeColor(6);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_8) this.brush.changeColor(7);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_9) this.brush.changeColor(8);
        else if(keyEvent.getKeyCode() == KeyEvent.VK_0) this.brush.changeColor(9);  // this should cause an error and make the window pop up

        if(keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public Brush getBrush(){return this.brush;}
}
