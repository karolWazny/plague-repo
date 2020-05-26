package services.vehicles;

import container.Coordinates;

public class Ambulance extends Vehicle{
    //Dodać jakieś pole
    private static int numAmb = 0;

    ////////////////////////////

    public Ambulance(Coordinates home){
        super("Ambulance", 'A', 5, 100, home);
        numAmb++;
    }

    public Ambulance(String id, char representation, int capacity, int velocity, Coordinates home){
        super(id, representation, capacity, velocity, home);
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
}