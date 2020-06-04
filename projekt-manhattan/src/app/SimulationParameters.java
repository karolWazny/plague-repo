package app;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;


public class SimulationParameters implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -4042477513098162866L;
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
        this(50, 50, 1200, 0, 5, 0, 6, 6, 1, 50, 50, 50);
    }

    public SimulationParameters(SimulationParameters params) {
        this.mapLength = params.mapLength;
        this.mapWidth = params.mapWidth;
        this.numPeople = params.numPeople;
        this.numDocs = params.numDocs;
        this.numAmbulance = params.numAmbulance;
        this.numHearse = params.numHearse;
        this.power1 = params.power1;
        this.power2 = params.power2;
        this.timeTilInfect = params.timeTilInfect;
        this.timeTilCured = params.timeTilCured;
        this.infectionRate = params.infectionRate;
        this.activeRate = params.activeRate;
    }

    public void ReadFromFile(File plik) throws FileNotFoundException{
        boolean exists = plik.exists();

            Scanner in = new Scanner(plik);
            int index1 = 0;
            String line, name, number;

            while(in.hasNextLine()){
                line = in.nextLine();

                if(line.equals("START")){
                    
                    while(!line.equals("END")){
                        line = in.nextLine();
                        index1 = 0;
                        index1 = line.indexOf("=");
                        
                        //System.out.println("Index = " + index1);
                        if(index1 > 0){
                            name = line.substring(0, index1);
          
                            number = line.substring(index1+1);

                            //System.out.println(name);
                            //System.out.println(number);

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
                        }
                    }
                }
            }
            in.close();
        
    }

    @Override
    public String toString() {
        String out = new String();
        out+="Simulation parameters:\nMap size:\n\twidth: "+mapWidth+", length: "+mapLength;
        out+="\nInitial number of people: "+numPeople+", including "+numDocs;
        out+=" doctors\nNumber of ambulances: "+numAmbulance;
        out += "\nVirus characteristics:\n\tPower: "+power1+"d"+power2;
        out += "\n\tNominal time between beeing infected and infecting others: "+timeTilInfect;
        out += "\n\tNominal time between being infected and being cured: "+timeTilCured;
        out += "\n\tInfection rate: "+infectionRate;
        out += "%\n\tPercentage of active instances of virus: "+activeRate+"%";
        return out;
    }

    public int getMapLength(){
        return mapLength;
    }

    public int getMapWidth(){
        return mapWidth;
    }

    public int getNumPeople(){
        return numPeople;
    }

    public int getNumDocs(){
        return numDocs;
    }

    public int getNumAmbulance(){
        return numAmbulance;
    }

    public int getPower1(){
        return power1;
    }

    public int getPower2(){
        return power2;
    }

    public int getTimeTilInfect(){
        return timeTilInfect;
    }

    public int getTimeTilCured(){
        return timeTilCured;
    }

    public int getInfectionRate(){
        return infectionRate;
    }

    public int getActiveRate(){
        return activeRate;
    }

    public void setMapLength(int mapLength){
        this.mapLength = mapLength;
    }

    public void setMapWidth(int mapWidth){
        this.mapWidth = mapWidth;
    }

    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }

    public void setNumDocs(int numDocs){
        this.numDocs = numDocs;
    }

    public void setNumAmbulance(int numAmbulance){
        this.numAmbulance = numAmbulance;
    }

    public void setPower1(int power1){
        this.power1 = power1;
    }

    public void setPower2(int power2){
        this.power2 = power2;
    }

    public void setTimeTilInfect(int timeTilInfect){
        this.timeTilInfect = timeTilInfect;
    }

    public void setTimeTilCured(int timeTilCured){
        this.timeTilCured = timeTilCured;
    }

    public void setInfectionRate(int infectionRate){
        this.infectionRate = infectionRate;
    }

    public void setActiveRate(int activeRate){
        this.activeRate = activeRate;
    }
}