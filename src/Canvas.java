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
        g.fillOval(this.brush.getX(), this.brush.getY()-60, this.brush.getSize(), this.brush.getSize());
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

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public Brush getBrush(){return this.brush;}
}
