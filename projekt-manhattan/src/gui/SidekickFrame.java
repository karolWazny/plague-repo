package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SidekickFrame extends JFrame{
    private JPanel panel;

    public SidekickFrame(JPanel panel, String windowName){
        super(windowName);

        this.panel = panel;
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}