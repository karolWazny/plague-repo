package app;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;


public class SimulationParameters {
    int mapLength;
    int mapWidth;
    int numPeople;
    int numDocs;
    int numAmbulance;
    int numHearse;
    int power1;
    int power2;
    int timeTilInfect;
    int timeTilCured;
    int infectionRate;
    int activeRate;

    ///////////////////////////////////

    SimulationParameters(int mapLength, int mapWidth, int numPeople, int numDocs, int numAmbulance, int numHearse, int power1,
    int power2, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
        this.numPeople = numPeople;
        this.numDocs = numDocs;
        this.numAmbulance = numAmbulance;
        this.numHearse = numHearse;
        this.power1 = power1;
        this.power2 = power2;
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    public SimulationParameters(){
        this.mapLength = 50;
        this.mapWidth = 50;
        this.numPeople = 10;
        this.numDocs = 5;
        this.numAmbulance = 2;
        this.numHearse = 2;
        this.power1 = 10;
        this.power2 = 10;
        this.timeTilInfect = 5;
        this.timeTilCured = 10;
        this.infectionRate = 10;
        this.activeRate = 10;
    }

    public void ReadFromFile(File plik) throws FileNotFoundException{
        boolean exists = plik.exists();

        if(exists){
            Scanner in = new Scanner(plik);
            String line = in.nextLine();

            while(in.hasNextLine()&&(!line.equals("END"))){
                
                int index1 = 0;
                index1 = line.indexOf("=");
                
                if(index1 != 0){
                    String name = line.substring(0, index1);
          
                    String number = line.substring(index1+1);

                    if(name.equals("mapLength")){
                        this.mapLength = Integer.valueOf(number);
                    }
                    else if(name.equals("mapWidth")){
                        this.mapWidth = Integer.valueOf(number);
                    }
                    else if(name.equals("numPeople")){
                        this.numPeople = Integer.valueOf(number);
                    }
                    else if(name.equals("numDocs")){
                        this.numDocs = Integer.valueOf(number);
                    }
                    else if(name.equals("numAmbulance")){
                        this.numAmbulance = Integer.valueOf(number);
                    }
                    else if(name.equals("numHearse")){
                        this.numHearse = Integer.valueOf(number);
                    }
                    else if(name.equals("power1")){
                        this.power1 = Integer.valueOf(number);
                    }
                    else if(name.equals("power2")){
                        this.power2 = Integer.valueOf(number);
                    }
                    else if(name.equals("timeTilInfect")){
                        this.timeTilInfect = Integer.valueOf(number);
                    }
                    else if(name.equals("timeTilCured")){
                        this.timeTilCured = Integer.valueOf(number);
                    }
                    else if(name.equals("infectionRate")){
                        this.infectionRate = Integer.valueOf(number);
                    }
                    else if(name.equals("activeRate")){
                        this.activeRate = Integer.valueOf(number);
                    }
                
                    line = in.nextLine();
                   
                    }
                    else{
                        line = in.nextLine();
                    }
            }
            in.close();
        }
    }
}