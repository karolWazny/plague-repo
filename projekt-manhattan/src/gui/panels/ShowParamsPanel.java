package gui.panels;

import app.Settings;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Klasa, która odpowiedzialna jest za pokazanie wyświetlenie
 * panelu z parametrami symulacji
 * @version 1.0
 * @see app.Settings
 */
public class ShowParamsPanel extends JPanel{
    /** Pole dla serializacji */
    private static final long serialVersionUID = -2037304708202985244L;
    /** Pole - obiekt będący polem tekstowym w panelu */
    private JTextArea textArea;

    /**
     * Metoda, konstruktor panelu z parametrami
     * @param settings obiekt z ustawieniami
     */
    public ShowParamsPanel(Settings settings){
        super();

        textArea = new JTextArea(settings.getParameters().toString());
        add(textArea);
        textArea.setEditable(false);
    }
}