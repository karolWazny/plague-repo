package gui.panels;

import app.IncorrectParametersException;
import app.Settings;
import app.Simulation;
import app.SimulationLog;
import app.WriteToFile;
import gui.frames.LastFrame;
import gui.frames.SidekickFrame;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;

/**
 * Klasa, ktorej obiekty tworza glowne menu symulacji
 * @version 1.0
 * @see app.IncorrectParametersException
 * @see app.Settings
 * @see app.Simulation
 * @see app.WriteToFile
 * @see gui.frames.LastFrame
 * @see gui.frames.SidekickFrame
 */
public class MainMenu extends JPanel {
    /**
     * Pole, ktore potrzebne jest do serializacji
     */
    private static final long serialVersionUID = -3300511018266865394L;
    /** Pole, ktore przechowuje przycisk do startu symulacji */
    private JButton runButt;
    /** Pole, ktore przechowuje przycisk do opcji pokazania parametrow */
    private JButton showParamButt;
    /** Pole, ktore przechowuje przycisk do opcji wpisania parametrow*/
    private JButton inputParamButt;
    /** Pole, ktore przechowuje przycisk do sciezki z plikiem parametrow wejsciowych */
    private JButton inputParamPathButt;
    /** Pole, ktore przechowuje przycisk do pokazania ostatniego przebiegu */
    private JButton showLastButt;
    /** Pole, ktore przechowuje przycisk do opcji zmiany sciezki docelowego miejsca zapisu plikow */
    private JButton inputOutPathButt;
    /** Referencja do aktualnie otwartego okienka pobocznego. */
    JFrame frame;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt graficznego menu symulacji
     * @param settings ustawienia
     * @param parentFrame ramka 
     * @param executor obiekt zarzadzajacy watkami
     */
    public MainMenu(Settings settings, JFrame parentFrame, ExecutorService executor) {
        super();
        
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
                    public void run(){
                        frame = new SidekickFrame(new ChangeOutputPanel(settings), "Change output directory", parentFrame);
                    }
                });
            }
        });
        add(inputOutPathButt);

        setLayout(new GridLayout(6, 1, 3, 3));
    }

    /**
     * Klasa wewnetrzna - zadanie przeprowadzenia symulacji i zapisu wyniku;
     * wysylana do egzekutora watkow.
     */

    class SimulationDoer implements Runnable {
        private Settings settings;
        private Simulation simulation;

        /**
         * 
         * @param settings ustawienia programu
         * Metoda - konstruktor; tworzy obiekt, ktory jest przyjmowany jako zadanie przez watek.
         */
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
                e.printStackTrace();
            }
            skryba = new WriteToFile("last_output.txt");
            try {
                skryba.WriteTheData(log);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}