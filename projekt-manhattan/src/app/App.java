package app;

import java.io.File;
import map.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //Tu trzeba własną ścieżkę dostępu do pliku dodać:
        File plik = new File("D:/programowanieProjekty/sluzbowe/naStudia/plague-repo/projekt-manhattan/src/app/Config.txt");
        
        SimulationParameters parametry = new SimulationParameters();
        Simulation sim2 = new Simulation(parametry);
        sim2.doSimulation();
    }
}