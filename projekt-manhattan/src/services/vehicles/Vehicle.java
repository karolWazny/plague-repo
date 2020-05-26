package services.vehicles;

import java.util.*;
import container.IMovable;
import container.Coordinates;
import map.Being;

public abstract class Vehicle extends Being implements IMovable{
    private int capacity;
    private int velocity;
    protected Coordinates destination;
    protected final Coordinates home; 
    private static int numVeh = 0;
    private IGPS gps;
    private List<IMovable> passengers; //Kontener na obiekty
    private int numPassengers = 0;
   
    ////////////////////////////

    public Vehicle(Coordinates home){
        super("Vehicle",'V');
        passengers = new ArrayList<>();
        this.home = new Coordinates(home);
        numVeh++;
    }

    public Vehicle(String id, char representation, int capacity, int velocity, Coordinates home){
        super(id, representation);
        this.capacity = capacity;
        this.velocity = velocity;
        this.home = new Coordinates(home);
        passengers = new ArrayList<>();
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
    public void setPassenger(IMovable patient){
        if(this.numPassengers<this.capacity){
            this.passengers.add(patient);
            this.numPassengers++;
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
    public List<IMovable> getPassengers(){
        return passengers;
    }

    public IGPS getIGPS() {
        return gps;
    }
}