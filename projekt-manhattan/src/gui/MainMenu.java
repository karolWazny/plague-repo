package gui;

import app.IncorrectParametersException;
import app.Settings;
import app.Simulation;
import app.SimulationLog;
import app.WriteToFile;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.concurrent.ExecutorService;

public class MainMenu extends JPanel {

    private JButton runButt;
    private JButton showParamButt;
    private JButton inputParamButt;
    private JButton inputParamPathButt;
    private JButton showLastButt;
    private JButton inputOutPathButt;

    private JFrame parentFrame;

    private Settings settings;

    private ExecutorService executor;

    JFrame frame;

    ///////////////////////

    public MainMenu(Settings settings, JFrame parentFrame, ExecutorService executor) {
        super();

        this.settings = settings;
        this.parentFrame = parentFrame;
        this.executor = executor;

        runButt = new JButton("Run simulation");
        runButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executor.submit(new SimulationDoer(settings));
            }
        });
        add(runButt);

        showParamButt = new JButton("Show current parameters");
        showParamButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        frame = new SidekickFrame(new ShowParamsPanel(settings), "Current simulation parameters",
                                parentFrame);
                    }
                });
            }
        });
        add(showParamButt);

        inputParamButt = new JButton("Input parameters manually");
        inputParamButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        frame = new SidekickFrame(new InputParamPanel(settings), "Input simulation parameters",
                                parentFrame);
                    }
                });
            }
        });
        add(inputParamButt);

        inputParamPathButt = new JButton("Input path to configuration file");
        inputParamPathButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        frame = new SidekickFrame(new InputPathPanel(settings), "Change path to configuration file",
                                parentFrame);
                    }
                });
            }
        });
        add(inputParamPathButt);

        showLastButt = new JButton("Show last run's output");
        showLastButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        frame = new LastFrame(new ShowLastPanel(settings), "Last run output", parentFrame);
                    }
                });
            }
        });
        add(showLastButt);

        inputOutPathButt = new JButton("Change output destination");
        inputOutPathButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable(){
                    @Override
                    public void run(){
                        frame = new SidekickFrame(new ChangeOutputPanel(settings), "Change output directory", parentFrame);
                    }
                });
            }
        });
        add(inputOutPathButt);

        setLayout(new GridLayout(6, 1, 3, 3));
    }

    class SimulationDoer implements Runnable {
        private Settings settings;
        private Simulation simulation;

        public SimulationDoer(Settings settings) {
            this.settings = settings;
            try {
                simulation = new Simulation(settings.getParameters());
            } catch (IncorrectParametersException e) {
                JOptionPane.showMessageDialog(getParent(),
                        "Cannot run simulation with current parameters.\nToo many people "
                                + "and vehicles on too small map\nor map too large to handle.",
                        "Incorrect parameters", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        public void run() {
            SimulationLog log = simulation.doSimulation();
            String date = log.getStartTime().toString().replace(" ", "_").replace(":", "").toLowerCase();
            WriteToFile skryba = new WriteToFile(settings.getOutPath() + "simulation_output_" + date + ".txt");
            try {
                skryba.WriteTheData(log);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            skryba = new WriteToFile("last_output.txt");
            try {
                skryba.WriteTheData(log);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}