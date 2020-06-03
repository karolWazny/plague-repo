package gui;

import app.IncorrectParametersException;
import app.Settings;
import app.Simulation;
import app.IncorrectParametersException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

    private JFrame parentFrame;

    private Settings settings;

    private static SimulationRuntimeWindow srw;

    JFrame frame;
    
    ///////////////////////

    public MainMenu(Settings settings, JFrame parentFrame){
        super();

        this.settings = settings;
        this.parentFrame = parentFrame;

        runButt = new JButton("Run simulation");
        runButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                        try{
                            Simulation sim = new Simulation(settings.getParameters());
                            sim.doSimulation();
                        } catch (IncorrectParametersException exception){
                            JOptionPane.showMessageDialog(frame, "Unable to run simulation\nusing current parameters.\nPossible cause:\ntoo many people on"+
                            "too small map\nor map too large to handle", "Incorrect parameters error", JOptionPane.ERROR_MESSAGE);
                        }
            }
        });
        add(runButt);

        showParamButt = new JButton("Show current parameters");
        showParamButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable(){

                    @Override
                    public void run(){
                        frame = new SidekickFrame(new ShowParamsPanel(settings), "Current simulation parameters");
                    }
                });
            }
        });
        add(showParamButt);

        inputParamButt = new JButton("Input parameters manually");
        inputParamButt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        
                    }
                });
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