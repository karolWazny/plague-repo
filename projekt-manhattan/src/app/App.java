package app;

import gui.frames.MainFrame;

import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * W tym miejscu rozpoczyna sie caly program
 * @version 1.0
 * @see gui.*;
 */
public class App {
    /** Pole, ktore przechowuje glowne okno/ramke dla menu */
    private static MainFrame mainFrame;

    /**
     * Metoda main, ktora uruchamia wszystko w symulacji
     * @param args parametry wejsciowe do maina
     * @throws Exception wyrzuca wyjatki, jesli takie beda
     */
    public static void main(String[] args) throws Exception {
        
        Settings settings = new Settings();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Program(settings, executor));
        
    }

    /**
     * Klasa - zadanie w formie przyjmowanej przez egzekutora watkow,
     * wyswietla okienko z glownym menu.
     */
    public static class Program implements Runnable{
        /** Pole przechowujace obiekt z ustawieniami */
        private Settings settings;
        /** Pole, ktore przechowuje obiekt zarzadzajacy zadaniami dla watkow */
        private ExecutorService executor;

        /**
         * Metoda, konstruktor, ktora tworzy obiekt tej klasy finalnej
         * @param settings obiekt z ustawieniami
         * @param executor obiekt zarzadzajacy zadaniami dla watkow
         */
        public Program(Settings settings, ExecutorService executor){
            this.settings = settings;
            this.executor = executor;
        }

        /** Metoda, ktora wyswietla okienko */
        public void run(){
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    mainFrame = new MainFrame(settings, executor);
                }
            });
        }
    }
}