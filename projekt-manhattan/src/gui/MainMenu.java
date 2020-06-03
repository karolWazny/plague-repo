package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        runButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                runButt.setBackground(Color.GRAY);
            }
        });
        add(runButt);

        showParamButt = new JButton("Show current parameters");
        showParamButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showParamButt.setBackground(Color.GRAY);
            }
        });
        add(showParamButt);

        inputParamButt = new JButton("Input parameters manually");
        inputParamButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputParamButt.setBackground(Color.GRAY);
            }
        });
        add(inputParamButt);

        inputParamPathButt = new JButton("Input path to configuration file");
        inputParamPathButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputParamPathButt.setBackground(Color.GRAY);
            }
        });
        add(inputParamPathButt);

        showLastButt = new JButton("Show last run's output");
        showLastButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showLastButt.setBackground(Color.GRAY);
            }
        });
        add(showLastButt);

        inputOutPathButt = new JButton("Change output destination");
        inputOutPathButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inputOutPathButt.setBackground(Color.GRAY);
            }
        });
        add(inputOutPathButt);

        setLayout(new GridLayout(6,1,3,3));
    }
}