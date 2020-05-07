package map;

import java.util.*;

public abstract class Vehicle extends Being implements IMovable{
    private int capacity;
    private int velocity;
    private static int numVeh = 0;
    private static IGPS gps;
    private List<IMovable> passengers; //Kontener na obiekty
    private int numPassengers = 0;
   
    ////////////////////////////

    public Vehicle(){
        super("Vehicle",'V');
        passengers = new ArrayList<>();
        numVeh++;
        gps = new GPS1();
    }

    public Vehicle(String id, char representation, int capacity, int velocity){
        super(id, representation);
        this.capacity = capacity;
        this.velocity = velocity;
        passengers = new ArrayList<>();
        gps = new GPS1();
        numVeh++;
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Vehicle nr " + numVeh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    ////////////////////////////

    public Coordinates move(){
        Coordinates newPosition = new Coordinates(0,0);
        //Tutaj będzie dużo pierdzielenia z tym ruchem...
        //Bo naszym celem będzie dojechać do szpitala
        //I w jakiś sposób musimy sygnalizować człowiekiem, że tam ma karetka dojechać
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