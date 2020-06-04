package gui;

import app.Settings;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;

public class InputParamPanel extends JPanel{
    private Settings settings;

    public InputParamPanel(Settings settings){
        super();
        this.settings = settings;

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Map length:"));
        panel1.add(new JLabel("Map width:"));
        panel1.add(new JLabel("People number:"));
        panel1.add(new JLabel("Doctors number"));
        panel1.setLayout(new GridLayout(0,1,5,8));
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.add(new JTextField());
        panel2.add(new JTextField());
        panel2.add(new JTextField());
        panel2.add(new JTextField());
        panel2.setLayout(new GridLayout(0,1,5,8));
        add(panel2);

        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }
}