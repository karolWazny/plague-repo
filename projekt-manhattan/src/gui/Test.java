package gui;

import app.*;

import java.awt.EventQueue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

public class Test {
    static Ramka ramka;
    public static void main(String [] args)throws Exception{
            File plik = new File("Config.txt");
            SimulationParameters parametry = new SimulationParameters();
            parametry.ReadFromFile(plik);
            Simulation sim2 = new Simulation(parametry);
            //System.out.println(sim2.doSimulation().toString());
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run() {
                ramka = new Ramka(sim2);
                }
            });
            for(int i = 0; i < 100; i++) {
                
            }
    }
}