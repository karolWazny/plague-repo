package services.vehicles;

import java.util.Iterator;

import container.Coordinates;
import container.IRecord;
import human.IRecoverable;
import services.buildings.Hospital;
import human.Human;

public class Ambulance extends Vehicle implements IRecoverable {
    //Dodać jakieś pole
    private IRecord caller;
    private static int numAmb = 0;
    public boolean isFree = true;
    private Hospital hospital;

    ////////////////////////////

    public Ambulance(Coordinates home, IGPS gps, Hospital hospital){
        super("Ambulance "+numAmb, 'A', 1, 20, home, gps);
        this.hospital = hospital;
        numAmb++;
    }

    // public Ambulance(String id, char representation, int capacity, int velocity, Coordinates coords){
    //     super(id, representation, capacity, velocity, coords);
    //     numAmb++;
    // }

    ////////////////////////////
   
    @Override
    public String toString(){
        return "Ambulance nr " + numAmb;
    }

    @Override
    public Coordinates move(Coordinates currentPosition){
        Coordinates out = super.move(currentPosition);
        if(out.isNextTo(destination)){
            if(destination.equals(home)){
                hospital.getList().addAll(passengers);
                passengers.clear();
                isFree = true;
            } else{
                super.addPassenger(caller);
                super.getIGPS().getMap().emptyField(caller.getVerHor());//złamana zasada Demeter (znowu...)
                caller.setVerHor(null);
                caller = null;
                super.destination = new Coordinates(home);
                if(passengers.size()<super.getCapacity()){
                    isFree=true;
                }
            }
        }
        return out;
    }

    @Override
    public void recover(){
        Iterator <IRecord>iterator = passengers.iterator();
        Human patient;
        while(iterator.hasNext()){
            patient = (Human)iterator.next().getBeing();
            if(!patient.getIsAlive()){
                iterator.remove();
                isFree = true;
                continue;
            }
            patient.setHealthPoints(patient.getHealthPoints()+5);
        }
    }
    ////////////////////////////

    //Jak się pojawią pola, to settery i gettery też stykną
    public int getNumAmb(){
        return numAmb;
    }

    public boolean getIsFree(){
        return isFree;
    }

    public void setCaller(IRecord caller){
        this.caller = caller;
        destination = new Coordinates(caller.getVerHor());
        isFree = false;
    }

    public IRecord getCaller(){
        return caller;
    }
}