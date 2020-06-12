package gui.panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.FileNotFoundException;

import app.Settings;

/**
 * Klasa, ktora jest odpowiedzialna za przygotowanie wzoru obiektu bedacego
 * panelem do zmiany sciezki dla plikow wyjsciowych z symulacji.
 * @version 1.0
 * @see app.Settings
 */
public class ChangeOutputPanel extends JPanel{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = -7668936027676131330L;
    /** Pole, ktore przechowuje przycisk do potwierdzenia zmian */
    private JButton confirmButt;
    /** Pole, ktore przechowuje przycisk do ustawienia domyslnej sciezki */
    private JButton defaultButt;
    /** Pole, ktore przechowuje napis nad obszarem do wyswietlania tekstu */
    private JLabel lab1;
    /** Pole, ktore przechowuje napis nad obszarem do wpisywania tekstu */
    private JLabel lab2;
    /** Pole, ktore przechowuje obiekt odpowiedzialny za wpisywanie tekstu sciezki */
    private JTextField tField1;
    /** Pole, ktore przechowuje obiekt odpowiedzialny za wyswietlanie tekstu sciezki */
    private JTextField tField2;
    /** Pole, ktore przechowuje obiekt z ustawieniami */
    private Settings settings;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt tej klasy w zaleznosci
     * od obiektu ustawień symulacji
     * @param settings obiekt z ustawieniami
     */
    public ChangeOutputPanel(Settings settings) {
        super();

        this.settings = settings;

        JPanel panel1 = new JPanel();

        lab1 = new JLabel("Current output directory: ");
        panel1.add(lab1);
        tField1 = new JTextField();
        tField1.setColumns(100);
        tField1.setEnabled(false);
        tField1.setDisabledTextColor(Color.GRAY);
        panel1.add(tField1);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        add(panel1);

        JPanel panel2 = new JPanel();
        lab2 = new JLabel("New output directory: ");
        panel2.add(lab2);
        tField2 = new JTextField();
        tField2.setColumns(100);
        panel2.add(tField2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
        add(panel2);

        JPanel panel3 = new JPanel();
        defaultButt = new JButton("Set default directory");
        defaultButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.setDefaultOutPath();
                refresh();
            }
        });
        panel3.add(defaultButt);
        confirmButt = new JButton("Confirm new output directory");
        confirmButt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPath = tField2.getText();
                String oldPath = settings.getOutPath();
                try {
                    settings.setOutPath(newPath);
                } catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(getParent(), "Couldn't find directory!\nCheck output path,\ntry using '\\' instead of '/',\nfinish with '\\'.");
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
     * Metoda, ktora jest odpowiedzialna za odswiezanie pol tekstowych w panelu.
     */
    public void refresh(){
        tField1.setText(settings.getOutPath().replace("\\\\", "\\"));
        tField2.setText(settings.getOutPath().replace("\\\\", "\\"));
    }
}