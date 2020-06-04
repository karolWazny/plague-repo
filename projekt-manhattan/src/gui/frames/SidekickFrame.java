package gui.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class SidekickFrame extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 4962172870167576711L;
    private JPanel panel;

    public SidekickFrame(JPanel panel, String windowName, JFrame parentFrame){
        super(windowName);

        parentFrame.setEnabled(false);

        this.panel = panel;
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

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
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public JPanel getPanel(){
        return panel;
    }
}