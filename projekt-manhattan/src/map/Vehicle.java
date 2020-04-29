package map;

public abstract class Vehicle extends Being{
    private int capacity;
    private int velocity;
    private static int num_Veh = 0;
    
    //Konstruktory
    public Vehicle(){
        super("Vehicle",'V');
        num_Veh++;
    }

    public Vehicle(int capacity, int velocity){
        super("Vehicle",'V');
        this.capacity = capacity;
        this.velocity = velocity;
        num_Veh++;
    }

    @Override
    public String toString(){
        return "Vehicle nr " + num_Veh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    public int getVelocity(){
        return velocity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getNumVeh(){
        return num_Veh;
    }
}