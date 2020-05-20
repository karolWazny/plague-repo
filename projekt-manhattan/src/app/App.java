package app;

import java.io.FileNotFoundException;

import map.Map;

public class App {
    public static void main(String[] args) throws Exception {
        SimulationParameters params = new SimulationParameters(15, 30, 30, 5, 0, 0, 6, 6, 5, 80, 80, 100);
        Simulation sim = new Simulation(params);
        sim.doSimulation();
    }
}