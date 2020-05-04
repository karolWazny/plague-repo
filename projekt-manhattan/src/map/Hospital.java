package map;

public class Hospital extends Building {
    private static int hospitalCounter = 0;

    ////////////////////////////
    //Konstruktor
    public Hospital(){
        super("Hospital", 'H', 100);
        hospitalCounter++;
    }

    public Hospital(String id, char representation, int capacity){
        super(id, representation, capacity);
        hospitalCounter++;
    }

    ////////////////////////////

    ////////////////////////////
    //Metody
    public int getHospitalCounter(){
        return hospitalCounter;
    }
}