package gui.frames;

import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Klasa okienka modalnego do wyswietlania przebiegu ostatniej symulacji.
 * @version 1.0
 */
public class LastFrame extends JFrame{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = 1221589322728058910L;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy LastFrame
     * @param panel panel
     * @param windowName nazwa okna
     * @param parentFrame okienko - rodzic
     */
    public LastFrame(JPanel panel, String windowName, JFrame parentFrame){
        super(windowName);

        parentFrame.setEnabled(false);

        add(new JScrollPane(panel));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
        setSize(470, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.LINE_AXIS));
        setVisible(true);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
}