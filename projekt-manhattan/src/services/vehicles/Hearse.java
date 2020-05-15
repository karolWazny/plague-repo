package services.vehicles;

public class Hearse extends Vehicle{
    private static int numHear = 0;

    ////////////////////////////

    public Hearse(){
        super("Hearse", '+', 5, 100);
        numHear++;
    }

    public Hearse(String id, char representation, int capacity, int velocity){
        super(id, representation, capacity, velocity);
        numHear++;
    }

    ////////////////////////////

    @Override
    public String toString(){
        return "Hearse nr " + numHear;
    }

    ////////////////////////////

    ////////////////////////////
    //Jak się pojawią pola, to settery i gettery też stykną
    public int getNumHear(){
        return numHear;
    }
}