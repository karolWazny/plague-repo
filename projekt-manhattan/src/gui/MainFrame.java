package gui;

import app.Settings;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

    Settings settings;

    public MainFrame(Settings settings){
        super("Plague Simulation: Project Manhattan");

        this.settings = settings;

        add(new MainMenu(settings, this));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}