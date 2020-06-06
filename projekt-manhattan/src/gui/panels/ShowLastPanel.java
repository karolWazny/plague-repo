package gui.panels;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import app.Settings;

/**
 * Klasa, której obiekty są odpowiedzialne za wyświetlanie parametrów
 * ostatniego przebiegu symulacji.
 * @version 1.0
 * @see app.Settings
 */
public class ShowLastPanel extends JPanel{
    /** Pole, które jest potrzebne do serializacji */
    private static final long serialVersionUID = -2172300090694690416L;
    /** Pole, które przechowuje obszar tekstowy, w którym
     * jest wyświetlany wynik ostatniej symulacji.
    */
    private JTextArea tArea;

    /**
     * Metoda, konstruktor, która tworzy obiekty tej klasy.
     * @param settings ustawienia symulacji
     */
    public ShowLastPanel(Settings settings){

        tArea = new JTextArea();
        add(tArea);

        String buffer;
        try{
            buffer = new String(Files.readAllBytes(Paths.get("last_output.txt")));
        } catch (Exception e){
            buffer = "Nothing to show!\nRun simulation, so its output can be viewed here.";
        }
        
        tArea.setText(buffer);
        tArea.setEditable(false);
        tArea.setCaretPosition(0);
        setSize(458, 500);
    }
}