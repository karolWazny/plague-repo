package gui;

import app.*;

import java.awt.EventQueue;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String [] args){
        try{
            File plik = new File("Config.txt");
            SimulationParameters parametry = new SimulationParameters();
            parametry.ReadFromFile(plik);
            Simulation sim2 = new Simulation(parametry);
            //System.out.println(sim2.doSimulation().toString());
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run() {
                new Ramka(sim2.getMap());
            }
            });
        } catch (IOException e){
            e.printStackTrace();
        }
        
    }
}