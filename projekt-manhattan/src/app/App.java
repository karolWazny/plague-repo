package app;

import map.Map;

public class App {
    public static void main(String[] args) throws Exception {
        SimulationParameters params = new SimulationParameters(15, 20, 50, 5, 0, 0, 4, 6, 5, 80, 100, 100);
        Simulation sim = new Simulation(params);
        sim.doSimulation();
    }
}