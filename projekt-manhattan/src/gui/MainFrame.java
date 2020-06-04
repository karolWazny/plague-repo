package gui;

import app.Settings;

import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

    private Settings settings;
    private ExecutorService executor;

    public MainFrame(Settings settings, ExecutorService executor){
        super("Plague Simulation: Project Manhattan");

        this.settings = settings;
        this.executor = executor;

        add(new MainMenu(settings, this, executor));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}