package gui.panels;

import app.Settings;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowParamsPanel extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = -2037304708202985244L;
    private JTextArea textArea;

    public ShowParamsPanel(Settings settings){
        super();

        textArea = new JTextArea(settings.getParameters().toString());
        add(textArea);
        textArea.setEditable(false);
    }
}