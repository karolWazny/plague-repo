package app;

/**
 * Klasa spełniająca funkcje testowe
 */
public class Test{
    /**
     * Metoda main do testów
     * @param args ciąg znaków wejścciowych do maina
     * @throws IncorrectParametersException Wyrzuca błędy niepoprawnych parametrów
     */
    public static void main(String[] args) throws IncorrectParametersException {
        Simulation sim = new Simulation(new SimulationParameters());
        sim.doSimulation();
    }
}