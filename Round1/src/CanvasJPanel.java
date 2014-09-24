
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CanvasJPanel extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
    JPanel p1;
    JButton green, blue, red, black, erase, thick, thin, regular;
    int thickness = 5;
    //Saves the point coordinates
    Point[]ps = new Point[10000];
    //Saves the color for each point
    String[]pc = new String[10000];
    //Saves the thickness for each point
    int[]pnt = new int[10000];
    //Counts the number of points in the point ps array
    int index = 0;
    String color;
    
    
    public CanvasJPanel()   {
        setBackground(Color.green);
        setLayout(new BorderLayout());
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2,2));
        add(p1,"South");
        addMouseMotionListener(this);
        addMouseListener(this);

        //Adds the thickness controls
        thin = new JButton("Thin");
        thin.addActionListener(this);
        p1.add(thin);
        
        regular = new JButton("Regular");
        regular.addActionListener(this);
        p1.add(regular);
        
        thick = new JButton("Thick");
        thick.addActionListener(this);
        p1.add(thick);
        
        //Adds the eraser
        erase = new JButton("Erase");
        p1.add(erase);
        erase.addActionListener(this);
        
        //Adds the color controls
        red = new JButton("Red");
        red.addActionListener(this);
        p1.add(red);
        
        blue = new JButton("Blue");
        blue.addActionListener(this);
        p1.add(blue);
        
        black = new JButton("Black");
        black.addActionListener(this);
        p1.add(black);
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        for(int k=0; k<index; k++)  {
            //sets the color of the pixel based on which button was clicked
            if(pc[k] == "green")    {g.setColor(Color.green);}
            if(pc[k] == "blue")     {g.setColor(Color.blue);}
            if(pc[k] == "red")      {g.setColor(Color.red);}
            if(pc[k] == "black")    {g.setColor(Color.black);}
            g.fillOval (ps[k].x, ps[k].y, pnt[k],pnt[k]);
        }
    }

    public void mouseMoved(MouseEvent e) {
       
    }
    
    public void mouseDragged(MouseEvent e) {
        Point pt = e.getPoint();
        getGraphics().fillOval((pt.x - (thickness/2)), (pt.y - (thickness/2)), thickness, thickness);
        
        //saves the location of each pixel
        ps[index]=pt;
        //saves the color of each pixel
        pc[index] = color;
        //saves the thickness of each pixel
        pnt[index] = thickness;
        index = index + 1;
 
        //prevents the pixel array from being exceeded and causing a crash
        if(index >=10000)  {
            index = 0;
        }
        repaint();
    }
    
    public void mouseEntered(MouseEvent e){
        
    }
    
    public void mouseExited(MouseEvent e){
        
    }
    
    public void mousePressed(MouseEvent e){
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    public void mouseClicked(MouseEvent e){
        Point pt = e.getPoint();
        getGraphics().fillOval(pt.x, pt.y, thickness, thickness);
        
        //saves the location of each pixel
        ps[index]=pt;
        //saves the color of each pixel
        pc[index] = color;
        //saves the thickness of each pixel
        pnt[index] = thickness;
        index = index + 1;
 
        //prevents the pixel array from being exceeded and causing a crash
        if(index >=10000)  {
            index = 0;
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj == thick) {thickness = 20;}
        if(obj == regular) {thickness = 10;}
        if(obj == thin) {thickness = 5;}
        if(obj == erase) {color = "green";}
        if(obj == red) {color = "red";}
        if(obj == blue) {color = "blue";}
        if(obj == black) {color = "black";}
    }
}
