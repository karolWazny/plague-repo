package gui;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LastFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1221589322728058910L;
    private JPanel panel;
    private JFrame parentFrame;

    public LastFrame(JPanel panel, String windowName, JFrame parentFrame){
        super(windowName);

        this.parentFrame = parentFrame;
        parentFrame.setEnabled(false);

        this.panel = panel;
        add(new JScrollPane(panel));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowListener(){
            @Override
            public void windowClosing(WindowEvent we){
                parentFrame.setEnabled(true);
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub

            }
            
        });
        setSize(470, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
}