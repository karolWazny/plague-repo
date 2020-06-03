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

        
            
            SwingUtilities.invokeLater(new Runnable(){
                @Override
                public void run(){
                    try{
                        Simulation sim = new Simulation(new SimulationParameters());
                        sim.doSimulation();
                    } catch (IncorrectParametersException e){
                        e.printStackTrace();
                    }
                }
            });
    }
}