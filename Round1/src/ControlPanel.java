import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;

public class ControlPanel extends JFrame {
    CanvasJPanel cjp;
    
    public ControlPanel()   {
        super("Round 1");
        
        //Fixes issues with mac displaying background colors.
        try 
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        cjp = new CanvasJPanel();
        getContentPane().setLayout(new BorderLayout());
	getContentPane().add(cjp,"Center");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setSize (640, 480);
        setVisible(true);
        
    }
    
}
