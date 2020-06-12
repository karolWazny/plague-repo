package gui.frames;

import app.Settings;
import gui.panels.MainMenu;

import java.util.concurrent.ExecutorService;

import javax.swing.JFrame;

/**
 * Klasa, ktora jest odpowiedzialna za tworzenie obiektow 
 * posiadajacych cechy glownego okienka aplikacji
 * @version 1.0
 * @see app.Settings
 * @see gui.panels.MainMenu
 */
public class MainFrame extends JFrame{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = 8708925714105432303L;

    /**
     * Metoda, konstruktor, ktora tworzy obiekty klasy glownego okienka.
     * Przekazuje ustawienia i referencje do egzekutora watkow do panelu glownego menu.
     * @param settings ustawienia
     * @param executor zarzadzanie watkami
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