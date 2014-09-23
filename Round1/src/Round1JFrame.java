
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cameron
 */
public class Round1JFrame extends JFrame {
    CanvasJPanel cjp;
    
    public Round1JFrame()   {
        super("Round 1");
        
        cjp = new CanvasJPanel();
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(cjp,"Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setVisible(true);
        
    }
    
}
