package app;

import java.io.File;
import map.Map;

public class App {
    public static void main(String[] args) throws Exception {
        /*SimulationParameters params = new SimulationParameters(15, 30, 30, 5, 0, 0, 6, 6, 5, 80, 80, 100);
        Simulation sim = new Simulation(params);
        sim.doSimulation();*/

        //Tu trzeba własną ścieżkę dostępu do pliku dodać:
        File plik = new File("D:/STUDIA/II semestr/Programowanie obiektowe/PROJEKT/Repozytorium projekt/plague-repo/projekt-manhattan/src/app/Config.txt");
        
        SimulationParameters parametry = new SimulationParameters();
        System.out.println("mapLength = " + parametry.mapLength);
        
        parametry.ReadFromFile(plik);

        System.out.println("After ReadFromFile(); mapLength = " + parametry.mapLength);
    }
}