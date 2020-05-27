package services.vehicles;

import java.util.List;

import container.Coordinates;
import container.IRecord;

public class Ambulance extends Vehicle {
    //Dodać jakieś pole
    private static int numAmb = 0;
    public boolean isFree = true;
    public List<IRecord> list;
    

    ////////////////////////////

    public Ambulance(){
        super("Ambulance", 'A', 5, 100, destination);
        numAmb++;
    }

    public Ambulance(String id, char representation, int capacity, int velocity, Coordinates coords){
        super(id, representation, capacity, velocity, coords);
        numAmb++;
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Ambulance nr " + numAmb;
    }

    ////////////////////////////

    //Jak się pojawią pola, to settery i gettery też stykną
    public int getNumAmb(){
        return numAmb;
    }

    public boolean getIsFree(){
        return isFree;
    }

    public void setIsFreeFalse(){
        isFree = false;
    }

    public void setIsFreeTrue(){
        isFree = true;
    }

    public void addPatient(IRecord record){
        if(isFree == true){
            list.add(record);
            setIsFreeFalse();
        }
    }
    
    public void removePatient(){
        if(isFree == false){
            list.remove(0);
            setIsFreeTrue();
        }
    }
}