package app;

import java.io.File;
import map.Map;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main(String[] args) throws Exception {
        //Tu trzeba własną ścieżkę dostępu do pliku dodać:
        File plik = new File("D:/programowanieProjekty/sluzbowe/naStudia/plague-repo/projekt-manhattan/src/app/Config.txt");
        SimulationParameters parametry = new SimulationParameters();
        parametry.ReadFromFile(plik);
        Simulation sim2 = new Simulation(parametry);
        System.out.print(sim2.doSimulation().toString());
        //startup();
    }
    public static void startup() {
        try {
            System.out.print("Wake up, Neo...");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("");
        System.out.println("");
        System.out.println("The Matrix has you...");
        TimeUnit.SECONDS.sleep(5);
        System.out.println();
        System.out.println();
        System.out.println("Follow the white rabbit...");
        System.out.println("");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("");
        System.out.println("Knock, knock, Neo.");
        TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            return;
        }
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Plague Simulation: Project Manhattan");
        System.out.println("");
        //tu chciałbym drukować wersję
    }
    public static void menu(){
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Run simulation");
            System.out.println("2. Show current parameters");
            System.out.println("3. Input parameters manually");
            System.out.println("4. Input path for parameters file");
            System.out.println("5. Show last simulation output");
            System.out.println("6. Exit");
        }
    }
}