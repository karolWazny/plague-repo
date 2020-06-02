package gui;

import app.Simulation;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

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
        super("Simulation run");
        this.sim = sim;

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));


        simulationPanel = new PanelMap(sim.getMap());
        add(new JScrollPane(simulationPanel));
        outputConsole = new JTextArea(sim.getLog().toString());
        // outputConsole.setBackground(Color.BLACK);
        // outputConsole.setForeground(Color.GREEN);
        scroller = new JScrollPane(outputConsole);
        add(scroller);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
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