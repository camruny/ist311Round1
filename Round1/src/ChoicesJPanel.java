import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class ChoicesJPanel extends JPanel{
    JButton blue, red, black;
    JSlider js1;
    int thickness = 20;
    String color = "black";
    String shape = "square";
    
    public ChoicesJPanel(){

        //Thickness Slider
        js1 = new JSlider();
        js1.setMaximum(20);
        js1.setMinimum(1);
        js1.setMajorTickSpacing(4);
        js1.setMinorTickSpacing(1);
        js1.setPaintTicks(true);
        js1.setPaintLabels(true);
        
        //Adds the color controls
        red = new JButton("Red");
        red.setBackground(Color.red);
        red.setForeground(Color.white);
        blue = new JButton("Blue");
        blue.setBackground(Color.blue);
        blue.setForeground(Color.white);
        black = new JButton("Black");
        black.setBackground(Color.black);
        black.setForeground(Color.white);
    }
    
    public void setColor(){
        //TODO
    }
    
    public void setBrushShape(){
        //TODO
    }
    
    public void setBrushSize(){
        //TODO
    }
}
