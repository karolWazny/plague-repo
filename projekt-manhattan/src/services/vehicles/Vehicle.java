package services.vehicles;

import java.util.List;
import java.util.ArrayList;

import container.IMovable;
import container.Coordinates;
import container.IRecord;
import map.Being;

public abstract class Vehicle extends Being implements IMovable{
    private int capacity;
    private int velocity;
    protected Coordinates destination;
    protected final Coordinates home; 
    private static int numVeh = 0;
    private IGPS gps;
    protected List<IRecord> passengers;
   
    ////////////////////////////

    // public Vehicle(Coordinates home){
    //     super("Vehicle",'V');
    //     passengers = new ArrayList<>();
    //     this.home = new Coordinates(home);
    //     numVeh++;
    // }

    public Vehicle(String id, char representation, int capacity, int velocity, Coordinates home, IGPS gps){
        super(id, representation);
        this.gps = gps;
        this.capacity = capacity;
        this.velocity = velocity;
        this.home = new Coordinates(home);
        numVeh++;
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Vehicle nr " + numVeh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    ////////////////////////////

    
    @Override
    public Coordinates move(Coordinates currentPosition){
        Coordinates newPosition = gps.navigate(currentPosition, destination, velocity);        
        return newPosition;
    }

    ////////////////////////////
    //Dodaję pasażera do pojazdu, jeśli nie ma miejsca, nie robię tego
    public void addPassenger(IRecord passenger){
        if(passengers.size()<this.capacity){
            this.passengers.add(passenger);
        }
        else{
            return;
        }   
    }

    public void setGPS (IGPS gps) {
        this.gps = gps;
    }

    ////////////////////////////

    public int getVelocity(){
        return velocity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumVeh(){
        return numVeh;
    }
    public List<IRecord> getPassengers(){
        return passengers;
    }

    public IGPS getIGPS() {
        return gps;
    }
}