package app;

import gui.MainFrame;

import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;

import javax.swing.SwingUtilities;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
    private static MainFrame mainFrame;
    public static void main(String[] args) throws Exception {
        
        Settings settings = new Settings();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new Program(settings, executor));
        
        
        // File plik = new File("Config.txt");
        // SimulationParameters params = new SimulationParameters();
        // params.ReadFromFile(plik);
        // Simulation sim = new Simulation(params);
        // sim.doSimulation();
    }

    public static void menuRun(SimulationParameters parameters, SimulationLog log) {
        if(parameters == null){
            System.out.println("No parameters found.\nInput parameters manually\nor via path to parameters.txt file");
            return;
        }
        //Simulation sim = new Simulation(parameters);
        //log = sim.doSimulation(); //tu cały cyrk z zapisem do pliku
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