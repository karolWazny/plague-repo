package gui;

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

public class InputPathPanel extends JPanel {
    private Settings settings;

    private JLabel lab1;
    private JLabel lab2;
    private JTextField tField1;
    private JTextField tField2;
    private JButton defaultButt;
    private JButton confirmButt;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setDefaultParamPath();
                refresh();
            }
        });
        panel3.add(defaultButt);
        confirmButt = new JButton("Confirm and load from file");
        confirmButt.addActionListener(new ActionListener() {
            @Override
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
                        // TODO Auto-generated catch block
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

    public void refresh(){
        tField1.setText(settings.getParamPath());
        tField2.setText(settings.getParamPath());
    }
}