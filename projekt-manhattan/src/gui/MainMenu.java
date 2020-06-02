package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class MainMenu extends JPanel{

    private JButton runButt;
    private JButton showParamButt;
    private JButton inputParamButt;
    private JButton inputParamPathButt;
    private JButton showLastButt;
    private JButton inputOutPathButt;
    
    ///////////////////////

    public MainMenu(){
        super();
        runButt = new JButton("Run simulation");
        add(runButt);
        showParamButt = new JButton("Show current parameters");
        add(showParamButt);
        inputParamButt = new JButton("Input parameters manually");
        add(inputParamButt);
        inputParamPathButt = new JButton("Input path to configuration file");
        add(inputParamPathButt);
        showLastButt = new JButton("Show last run's output");
        add(showLastButt);
        inputOutPathButt = new JButton("Change output destination");
        add(inputOutPathButt);

        setLayout(new GridLayout(6,1,3,3));
    }
}