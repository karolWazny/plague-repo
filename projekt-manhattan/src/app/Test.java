package app;

/**
 * Klasa spelniajaca funkcje testowe
 */
public class Test{
    /**
     * Metoda main do testow
     * @param args ciag znakow wejscciowych do maina
     * @throws IncorrectParametersException Wyrzuca bledy niepoprawnych parametrow
     */
    public static void main(String[] args) throws IncorrectParametersException {
        Simulation sim = new Simulation(new SimulationParameters());
        sim.doSimulation();
    }
}