package app;

public class Test{
    public static void main(String[] args) throws IncorrectParametersException {
        Simulation sim = new Simulation(new SimulationParameters());
        sim.doSimulation();
    }
}