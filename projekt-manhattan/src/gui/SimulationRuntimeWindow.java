package gui;

import app.Simulation;

import javax.swing.BoxLayout;
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
    private JScrollPane scroller;

    public SimulationRuntimeWindow(Simulation sim) {
        super("Simulation");
        this.sim = sim;

        
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));

        simulationPanel = new PanelMap(sim.getMap());//do zmiany
        add(simulationPanel);
        outputConsole = new JTextArea(sim.getLog().toString());
        scroller = new JScrollPane(outputConsole);
        add(scroller);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        pack();
    }

    public void nextRound(String state) {
        simulationPanel.revalidate();
        simulationPanel.repaint();
        outputConsole.append('\n'+state.toString());
        outputConsole.setCaretPosition(outputConsole.getText().length());
    }

    public void finish(String str) {
        outputConsole.setText(str);
    }
}