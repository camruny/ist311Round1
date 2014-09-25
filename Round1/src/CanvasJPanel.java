
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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CanvasJPanel extends JPanel implements ChangeListener, MouseListener, MouseMotionListener, ActionListener {
    JPanel p1;
    JButton green, blue, red, black, erase, thick, thin, regular;
    JButton save;
    JSlider js1;
    JLabel jl1;
    int thickness = 20;
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

        //Thickness Slider
        js1 = new JSlider();
        js1.setMaximum(20);
        js1.setMinimum(1);
        js1.setMajorTickSpacing(4);
        js1.setMinorTickSpacing(1);
        js1.setPaintTicks(true);
        js1.setPaintLabels(true);
        js1.addChangeListener(this);
        
        //Create Thickness Slider Label
        jl1 = new JLabel("Thickness: ");
        
        //Adds the eraser
        erase = new JButton("Erase");
        erase.addActionListener(this);
        
        //Adds the color controls
        red = new JButton("Red");
        red.addActionListener(this);
        
        blue = new JButton("Blue");
        blue.addActionListener(this);
        
        black = new JButton("Black");
        black.addActionListener(this);
        
        save = new JButton("Save");
        save.addActionListener(this);
        
        //Add choices to panel
        p1.add(red);
        p1.add(blue);
        p1.add(black);
        p1.add(erase);
        p1.add(jl1);
        p1.add(js1);
        p1.add(save);
    }
    
    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        for(int k=0; k<index; k++)  {
            //sets the color of the pixel based on which button was clicked
            if(pc[k] == "green")    {g.setColor(Color.green);}
            if(pc[k] == "blue")     {g.setColor(Color.blue);}
            if(pc[k] == "red")      {g.setColor(Color.red);}
            if(pc[k] == "black")    {g.setColor(Color.black);}
            g.fillRect (ps[k].x, ps[k].y, pnt[k],pnt[k]);
        }
    }

    public void mouseMoved(MouseEvent e) {
       
    }
    
    int save() throws IOException   {
        int success=0;
        try {
            PrintWriter pr = new PrintWriter("paint.txt");    

            for (int i=0; i<index ; i++)
            {
                pr.println(ps[i]);
                pr.println(pc[i]);
                pr.println(pnt[i]);
            }
            pr.close();
            success = 1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
        return success; 
    }
    
    public void mouseDragged(MouseEvent e) {
        Point pt = e.getPoint();
        getGraphics().fillRect((pt.x - (thickness/2)), (pt.y - (thickness/2)), thickness, thickness);
        
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
        getGraphics().fillRect(pt.x, pt.y, thickness, thickness);
        
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
        if(obj == save) {try {
            save();
            } catch (IOException ex) {
                Logger.getLogger(CanvasJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
}
    }
    
    public void stateChanged(ChangeEvent e){
        Object obj = e.getSource();
        
        if(obj == js1){
            thickness = js1.getValue();
        }
    }
    
    public void stateChanged(ChangeEvent e){
        Object obj = e.getSource();
        
        if(obj == js1){
            thickness = js1.getValue();
        }
    }
    
    public void stateChanged(ChangeEvent e){
        Object obj = e.getSource();
        
        if(obj == js1){
            thickness = js1.getValue();
        }
    }
}
