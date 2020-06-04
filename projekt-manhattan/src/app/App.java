package app;

import gui.MainFrame;

import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
    private static MainFrame mainFrame;
    public static void main(String[] args) throws Exception {
        
        Settings settings = new Settings();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Program(settings, executor));
        
    }

    ////////////////////////////////////

    public static class Program implements Runnable{

        private Settings settings;
        private ExecutorService executor;

        public Program(Settings settings, ExecutorService executor){
            this.settings = settings;
            this.executor = executor;
        }

        @Override
        public void run(){
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                    mainFrame = new MainFrame(settings, executor);
                }
            });
        }

    }

    ///////////////////////////////////////
}