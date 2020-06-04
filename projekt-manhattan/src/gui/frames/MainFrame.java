package gui.frames;

import app.Settings;
import gui.panels.MainMenu;

import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

    /**
     *
     */
    private static final long serialVersionUID = 8708925714105432303L;

    public MainFrame(Settings settings, ExecutorService executor){
        super("Plague Simulation: Project Manhattan");

        add(new MainMenu(settings, this, executor));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
}