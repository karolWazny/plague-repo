package gui;

import app.Settings;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ShowParamsPanel extends JPanel{

    private Settings settings;
    private JTextArea textArea;

    public ShowParamsPanel(Settings settings){
        super();

        this.settings = settings;
        textArea = new JTextArea(settings.getParameters().toString());
        add(textArea);
        textArea.setEditable(false);
    }
}