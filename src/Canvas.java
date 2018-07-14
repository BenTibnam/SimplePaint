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
        this.help();
    }

    public void help(){
        MessageWindow mw = new MessageWindow("Help", "<html><body>Click to paint. Press 1-9 to change colors.<br/>" +
                "1: Black<br/>2: Red<br/>3: Green<br/>4: Blue<br/>5: Pink<br/>6: Yellow<br/>7: Cyan<br/>8: Dark Gray<br/>9: Light Gray <br/> Press 'h' to display this message.</html>", 300, 250);
        mw.setUp();
        mw.display();

        mw.getWindow().setLocationRelativeTo(null);

    }

    public void paint(Graphics g){
        this.brush.update();
        int baseX = this.brush.getX();
        int baseY = this.brush.getY() - 65;
        int size = this.brush.getSize();
        g.setColor(this.brush.getCurColor());
        g.fillOval(baseX, baseY, size, size);
        g.fillOval(baseX+1, baseY, size, size);
        g.fillOval(baseX-1, baseY, size, size);
        g.fillOval(baseX, baseY + 1, size, size);
        g.fillOval(baseX, baseY-1, size, size);
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

        // real secrete color
        if(keyEvent.getKeyCode() == KeyEvent.VK_C) this.brush.setCurColor(Color.WHITE);

        // display the help menu
        if(keyEvent.getKeyCode() == KeyEvent.VK_H) this.help();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public Brush getBrush(){return this.brush;}
}
