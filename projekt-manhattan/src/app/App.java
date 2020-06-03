package app;

import java.util.concurrent.TimeUnit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class App {
    //private Settings settings;
    public static void main(String[] args) throws Exception {
        File plik = new File("Config.txt");
        SimulationParameters parametry = new SimulationParameters();
        parametry.ReadFromFile(plik);
        Simulation sim2 = new Simulation(parametry);
        System.out.println(sim2.doSimulation().toString());
    }

    //////////////////////////

    public static void startup() {
        try {
            System.out.print("Wake up, Neo...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("");
        System.out.println("");
        System.out.println("The Matrix has you...");
        TimeUnit.SECONDS.sleep(3);
        System.out.println();
        System.out.println();
        System.out.println("Follow the white rabbit...");
        System.out.println("");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("");
        System.out.println("Knock, knock, Neo.");
        TimeUnit.SECONDS.sleep(3);
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

    ////////////////////////

    public static void menu() throws IOException{
        SimulationParameters parameters = new SimulationParameters();
        SimulationLog log = new SimulationLog();
        boolean running = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int position;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Run simulation");
            System.out.println("2. Show current parameters");
            System.out.println("3. Input parameters manually");
            System.out.println("4. Input path for parameters file");
            System.out.println("5. Show last simulation output");
            System.out.println("6. Exit\n\nEnter a number");
                try {
                    position = Integer.parseInt(br.readLine());
                    switch(position) {
                        case 1: menuRun(parameters, log);
                            break;
                        case 2: menuShowParams(parameters);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6: running = false;
                            break;
                        default: System.out.println("Invalid number!");
                            break;
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid number format!");
                }
        }
    }

    //////////////////////////////

    public static void menuRun(SimulationParameters parameters, SimulationLog log) {
        if(parameters == null){
            System.out.println("No parameters found.\nInput parameters manually\nor via path to parameters.txt file");
            return;
        }
        //Simulation sim = new Simulation(parameters);
        //log = sim.doSimulation(); //tu cały cyrk z zapisem do pliku
    }

    ////////////////////////////////////

    public static void menuShowParams(SimulationParameters parameters) {
        if(parameters == null){
            System.out.println("No parameters found.\nInput parameters manually\nor via path to parameters.txt file");
            return;
        }
        System.out.print(parameters.toString());
    }

    ///////////////////////////////////////
    
    class Settings implements Serializable{
        /**
         *
         */
        private static final long serialVersionUID = -282658663089910836L;
        SimulationParameters params;
        String outPath;
        String paramPath;

        ////////////////////////
        Settings(){
            boolean wasException = false;
            try {
                Settings temp = load();
                params = temp.params;
                outPath = temp.outPath;
                paramPath = temp.paramPath;
            } catch (FileNotFoundException e) {
                setDefaultAll();
                wasException = true;
            } catch (IOException e) {
                setDefaultAll();
                wasException = true;
            } catch (ClassNotFoundException e){
                setDefaultAll();
                wasException = true;
            }

            if(wasException){
                try {
                    serialize();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        ///////////////////////////

        private Settings load() throws FileNotFoundException, IOException, ClassNotFoundException {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Settings.bin"));
            Settings temp = (Settings)inputStream.readObject();
            inputStream.close();
            return temp;
        }

        //////////////////////////////////

        private void serialize() throws IOException{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Settings.bin"));
            outputStream.writeObject(this);
            outputStream.close();
            return;
        }

        ///////////////////////////////

        void setDefaultAll(){
            params = new SimulationParameters();
            outPath = new String();
            paramPath = new String();
            return;
        }
    }
}