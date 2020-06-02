package gui;

import app.Simulation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;

public class SimulationRuntimeWindow extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = -4709971995267753715L;
    private Simulation sim;
    private JPanel simulationPanel;
    private JTextArea outputConsole;

    public SimulationRuntimeWindow(Simulation sim) {
        super("Simulation");
        this.sim = sim;

        simulationPanel = new PanelMap(sim.getMap());//do zmiany
        add(simulationPanel);
        outputConsole = new JTextArea(sim.getLog().toString());
        add(new JScrollPane(outputConsole));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
    }

    public void nextRound(String state) {
        simulationPanel.revalidate();
        simulationPanel.repaint();
        outputConsole.append('\n'+state.toString());
    }

    public void finish(String str) {
        outputConsole.setText(str);
    }
}