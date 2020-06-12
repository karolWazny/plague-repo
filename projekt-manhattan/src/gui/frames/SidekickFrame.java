package gui.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

/**
 * Klasa, ktora jest odpowiedzialna za poboczne okienka modalne, nie liczac okna podgladu symulacji i wyswietlania
 * wyniku ostatniego przebiegu.
 * @version 1.0
 */
public class SidekickFrame extends JFrame{
    /** Pole potrzebne do serializacji. */
    private static final long serialVersionUID = 4962172870167576711L;
    /** Pole, ktore przechowuje panel z zawartoscia okienka.*/
    private JPanel panel;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy SidekickFrame 
     * @param panel panel 
     * @param windowName nazwa okienka
     * @param parentFrame nazwa rodzica
     */
    public SidekickFrame(JPanel panel, String windowName, JFrame parentFrame){
        super(windowName);

        parentFrame.setEnabled(false);

        this.panel = panel;
        add(panel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();

        addWindowListener(new WindowListener(){
            public void windowClosing(WindowEvent we){
                parentFrame.setEnabled(true);
            }

            public void windowOpened(WindowEvent e) {

            }

            public void windowClosed(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
            
        });
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * Metoda, getter, ktora pobiera panel z obiektu.
     * @return obiekt typu IPanel
     */
    public JPanel getPanel(){
        return panel;
    }
}