package app;

import gui.frames.MainFrame;

import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * W tym miejscu rozpoczyna się cały program
 * @version 1.0
 * @see gui.*;
 */
public class App {
    /** Pole, które przechowuje główne okno/ramkę dla menu */
    private static MainFrame mainFrame;

    /**
     * Metoda main, która uruchamia wszystko w symulacji
     * @param args parametry wejściowe do maina
     * @throws Exception wyrzuca wyjątki, jeśli takie będą
     */
    public static void main(String[] args) throws Exception {
        
        Settings settings = new Settings();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Program(settings, executor));
        
    }

    /**
     * Klasa - zadanie w formie przyjmowanej przez egzekutora wątków,
     * wyświetla okienko z głównym menu.
     */
    public static class Program implements Runnable{
        /** Pole przechowujące obiekt z ustawieniami */
        private Settings settings;
        /** Pole, które przechowuje obiekt zarządzający zadaniami dla wątków */
        private ExecutorService executor;

        /**
         * Metoda, konstruktor, która tworzy obiekt tej klasy finalnej
         * @param settings obiekt z ustawieniami
         * @param executor obiekt zarządzający zadaniami dla wątków
         */
        public Program(Settings settings, ExecutorService executor){
            this.settings = settings;
            this.executor = executor;
        }

        /** Metoda, która wyświetla okienko */
        public void run(){
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    mainFrame = new MainFrame(settings, executor);
                }
            });
        }
    }
}