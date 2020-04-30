package map;

public class Ambulance extends Vehicle{
    //Dodać jakieś pole
    private static int numAmb = 0;

    public Ambulance(){
        super("Ambulance", 'A', 5, 100);
        numAmb++;
    }

    public Ambulance(String id, char representation, int capacity, int velocity){
        super(id, representation, capacity, velocity);
        numAmb++;
    }

    @Override
    public String toString(){
        return "Ambulance nr " + numAmb;
    }

    //Jak się pojawią pola, to settery i gettery też stykną
    public int getNumAmb(){
        return numAmb;
    }
}