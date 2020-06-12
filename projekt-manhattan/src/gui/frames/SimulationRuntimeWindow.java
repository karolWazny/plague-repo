package gui.frames;

import app.Simulation;
import gui.panels.PanelMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

/**
 * Klasa, ktora jest typem obiektu bedacego okienkiem podgladu przebiegu w trakcie trwania
 * symulacji.
 * @version 1.0
 * @see app.Simulation
 * @see gui.panels.PanelMap
 */
public class SimulationRuntimeWindow extends JFrame {
    /** Pole potrzebne do serializacji. */
    private static final long serialVersionUID = -4709971995267753715L;
    /** Pole, ktore przechowuje panel do wyswietlania mapy. */
    private JPanel simulationPanel;
    /** Pole, ktore przechowuje obszar tekstowy, gdzie sa drukowane wartosci liczbowe
     * w trakcie przebiegu symulacji.
    */
    private JTextArea outputConsole;
    /** Obiekt odpowiedzialny za mozliwosć scrollowania obszaru tekstowego
     * - konsoli wyjsciowej.
    */
    private JScrollPane scroller;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt bedacy okienkiem symulacji
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
     * Metoda, ktora wyswietla nastepna runde.
     * @param state obiekt ze stanem symulacji po rundzie
     */
    public void nextRound(String state) {
        simulationPanel.revalidate();
        simulationPanel.repaint();
        outputConsole.append('\n'+state.toString());
        outputConsole.setCaretPosition(outputConsole.getText().length());
    }

    /**
     * Metoda, ktora wyswietla do okienka ostatnia runde i wynik symulacji.
     * @param str tekst, bedacy ostatecznym wyjsciem symulacji.
     */
    public void finish(String str) {
        outputConsole.setText(str);
    }
}