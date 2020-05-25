package app;

import java.io.File;
import map.Map;

public class App {
    public static void main(String[] args) throws Exception {
        //Tu trzeba własną ścieżkę dostępu do pliku dodać:
        File plik = new File("D:/programowanieProjekty/sluzbowe/naStudia/plague-repo/projekt-manhattan/src/app/Config.txt");
        
        SimulationParameters parametry = new SimulationParameters();
        System.out.println("mapLength = " + parametry.mapLength);
        
        parametry.ReadFromFile(plik);

        System.out.println("After ReadFromFile(); mapLength = " + parametry.mapLength);
        Simulation sim2 = new Simulation(parametry);
        sim2.doSimulation();
    }
}