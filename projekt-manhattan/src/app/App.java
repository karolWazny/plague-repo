package app;

import gui.MainFrame;

import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.SwingUtilities;


public class App {
    private static MainFrame mainFrame;
    public static void main(String[] args) throws Exception {
        
        Settings settings = new Settings();
        
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                mainFrame = new MainFrame(settings);
            }
        });
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

    public static void menuShowParams(SimulationParameters parameters) {
        if(parameters == null){
            System.out.println("No parameters found.\nInput parameters manually\nor via path to parameters.txt file");
            return;
        }
        System.out.print(parameters.toString());
    }

    ///////////////////////////////////////
}