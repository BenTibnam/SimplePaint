import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Brush {
    private int x;
    private int y;
    private int size;
    volatile private boolean held;
    private Color curColor;
    private Color[] colors = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.PINK, Color.YELLOW, Color.CYAN, Color.DARK_GRAY, Color.LIGHT_GRAY};

    public Brush(){
        this.x = 0;
        this.y = 0;
        this.size = 5;
        this.held = false;
        this.curColor = Color.BLACK;
    }

    public void changeColor(int i){
        if(i < 0 || i >= colors.length){
            // creating an error message box
            MessageWindow mw = new MessageWindow("Error", "Error: out of color range");
            mw.setUp();
            mw.display();
        }else{
            curColor = colors[i];
        }
    }

    public void update(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        this.x = p.x;
        this.y = p.y;
    }


    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public int getSize(){return this.size;}
    public boolean getHeld(){return this.held;}
    public Color getCurColor(){return this.curColor;}
    public void setSize(int amt){this.size = amt;}
    public void setCurColor(Color c){this.curColor = c;}
    public void setHeld(boolean b){this.held = b;}


}
