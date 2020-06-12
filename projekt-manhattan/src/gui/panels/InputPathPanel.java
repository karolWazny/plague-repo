package gui.panels;

import app.Settings;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Klasa, ktora jest odpowiedzialna za stworzenie obiektu bedacego
 * panelem do pobrania aktualnej sciezki dostepu lub do wpisania nowej sciezki
 * z plikiem konfiguracyjnym.
 * @version 1.0
 * @see app.Settings
 */
public class InputPathPanel extends JPanel {
    /** Pole, ktore jest potrzebne do serializacji. */ 
    private static final long serialVersionUID = -2602656210270465426L;
    /** Pole, ktore przechowuje obiekt z ustawieniami. */
    private Settings settings;
    /** Etykieta z napisem "Current configuration file path: "*/
    private JLabel lab1;
    /** Etykieta z napisem "New configuration file path: " */
    private JLabel lab2;
    /** Obszar tekstowy wyswietlajacy aktualna sciezke do pliku konfiguracyjnego.*/
    private JTextField tField1;
    /** Obszar tekstowy na wpisanie nowej sciezki do pliku konfiguracyjnego.*/
    private JTextField tField2;
    /** Pole, ktore przechowuje obiekt - przycisk do ustawiania domyslnej sciezki */
    private JButton defaultButt;
    /** Pole, ktore przechowuje obiekt - przycisk do potwierdzenia i zaladowania parametrow
     * z pliku z podanej sciezki.
    */
    private JButton confirmButt;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt bedacy panelem do pokazywania
     * aktualnej sciezki z plikiem konfiguracyjnym i do wpisywania nowej
     * @param settings obiekt z ustawieniami
     */
    public InputPathPanel(Settings settings) {
        super();

        this.settings = settings;

        JPanel panel1 = new JPanel();

        lab1 = new JLabel("Current configuration file path: ");
        panel1.add(lab1);
        tField1 = new JTextField();
        tField1.setColumns(100);
        tField1.setEnabled(false);
        tField1.setDisabledTextColor(Color.GRAY);
        panel1.add(tField1);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        add(panel1);

        JPanel panel2 = new JPanel();
        lab2 = new JLabel("New configuration file path: ");
        panel2.add(lab2);
        tField2 = new JTextField();
        tField2.setColumns(100);
        panel2.add(tField2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        add(panel2);

        JPanel panel3 = new JPanel();
        defaultButt = new JButton("Set default path");
        defaultButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setDefaultParamPath();
                refresh();
            }
        });
        panel3.add(defaultButt);
        confirmButt = new JButton("Confirm and load from file");
        confirmButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPath = tField2.getText();
                String oldPath = settings.getParamPath();
                try {
                    settings.setParamPath(newPath);
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(getParent(), "Couldn't find file!\nCheck input path,\ntry using '\\' instead of '/'.");
                    try {
                        settings.setParamPath(oldPath);
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        panel3.add(confirmButt);

        panel3.setLayout(new BoxLayout(panel3, BoxLayout.LINE_AXIS));
        add(panel3);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        refresh();
    }

    /**
     * Metoda, ktora odswieza widok zawartosci obszarow tekstowych.
     */
    public void refresh(){
        tField1.setText(settings.getParamPath());
        tField2.setText(settings.getParamPath());
    }
}