package map;

public abstract class Building extends Being{
    private static int blockCounter = 0;
    
    ////////////////////////////

    public Building(){
        super("Block "+ blockCounter, 'B');
    }
    public Building(char representation){ //Hospital
        super("Block "+ blockCounter, 'H');
    }
    
    ////////////////////////////
    
}