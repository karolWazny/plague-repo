package map;

public abstract class Vehicle extends Being{
    private int capacity;
    private int velocity;
    private static int numVeh = 0;
    
    //Konstruktory
    public Vehicle(){
        super("Vehicle",'V');
        numVeh++;
    }

    public Vehicle(String id, char representation, int capacity, int velocity){
        super(id, representation);
        this.capacity = capacity;
        this.velocity = velocity;
        numVeh++;
    }

    @Override
    public String toString(){
        return "Vehicle nr " + numVeh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    public int getVelocity(){
        return velocity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumVeh(){
        return numVeh;
    }
}