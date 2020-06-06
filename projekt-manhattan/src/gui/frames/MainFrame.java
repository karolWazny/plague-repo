package gui.frames;

import app.Settings;
import gui.panels.MainMenu;

import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

/**
 * Klasa, która jest odpowiedzialna za tworzenie obiektów 
 * posiadających cechy głównego okienka aplikacji
 * @version 1.0
 * @see app.Settings
 * @see gui.panels.MainMenu
 */
public class MainFrame extends JFrame{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = 8708925714105432303L;

    /**
     * Metoda, konstruktor, która tworzy obiekty klasy głównego okienka 
     * W zależności od obiektów ustawień i zarządzania wątkami
     * @param settings ustawienia
     * @param executor zarządzanie wątkami
     */
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