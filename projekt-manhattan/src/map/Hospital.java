package map;

public class Hospital extends Building {
<<<<<<< HEAD

    //Pola
    private static int hospitalCounter = 0;

=======
    private static int hospitalCounter = 0;

    ////////////////////////////
>>>>>>> d8a5de7b4aa593db16f7eaff2f43881aa1e3f02a
    //Konstruktor
    public Hospital(){
        super("Hospital", 'H', 100);
        hospitalCounter++;
    }

    public Hospital(String id, char representation, int capacity){
        super(id, representation, capacity);
        hospitalCounter++;
<<<<<<< HEAD
    }

    //Metody
    public int getHospitalCounter(){
        return hospitalCounter;
=======
>>>>>>> d8a5de7b4aa593db16f7eaff2f43881aa1e3f02a
    }

    ////////////////////////////

    ////////////////////////////
    //Metody
    public int getHospitalCounter(){
        return hospitalCounter;
    }
}