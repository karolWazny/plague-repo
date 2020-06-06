package gui.frames;

import app.Simulation;
import gui.panels.PanelMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Klasa, która jest typem obiektu będącego okienkiem podglądu przebiegu w trakcie trwania
 * symulacji.
 * @version 1.0
 * @see app.Simulation
 * @see gui.panels.PanelMap
 */
public class SimulationRuntimeWindow extends JFrame {
    /** Pole potrzebne do serializacji. */
    private static final long serialVersionUID = -4709971995267753715L;
    /** Pole, które przechowuje panel do wyświetlania mapy. */
    private JPanel simulationPanel;
    /** Pole, które przechowuje obszar tekstowy, gdzie są drukowane wartości liczbowe
     * w trakcie przebiegu symulacji.
    */
    private JTextArea outputConsole;
    /** Obiekt odpowiedzialny za możliwość scrollowania obszaru tekstowego
     * - konsoli wyjściowej.
    */
    private JScrollPane scroller;

    /**
     * Metoda, konstruktor, która tworzy obiekt będący okienkiem symulacji
     * @param sim Obiekt klasy symulacji
     */
    public SimulationRuntimeWindow(Simulation sim) {
        super("Simulation run");

        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));

        simulationPanel = new PanelMap(sim.getMap());
        add(new JScrollPane(simulationPanel));
        outputConsole = new JTextArea(sim.getLog().toString());
        outputConsole.setEditable(false);
        scroller = new JScrollPane(outputConsole);
        add(scroller);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
    }

    /**
     * Metoda, która wyświetla następną rundę.
     * @param state obiekt ze stanem symulacji po rundzie
     */
    public void nextRound(String state) {
        simulationPanel.revalidate();
        simulationPanel.repaint();
        outputConsole.append('\n'+state.toString());
        outputConsole.setCaretPosition(outputConsole.getText().length());
    }

    /**
     * Metoda, która wyświetla do okienka ostatnią rundę i wynik symulacji.
     * @param str tekst, będący ostatecznym wyjściem symulacji.
     */
    public void finish(String str) {
        outputConsole.setText(str);
    }
}