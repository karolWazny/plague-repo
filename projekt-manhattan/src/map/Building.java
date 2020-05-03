package map;

public abstract class Building extends Being{
    
    //Pola
    private static int blockCounter = 0;
    private int capacity;
    
    //Konstruktor
    public Building(){
        super("Block "+ blockCounter, 'B');
        blockCounter++;
    }
    public Building(String id, char representation, int capacity){ //Hospital
        super(id, representation);
        this.capacity = capacity;
        blockCounter++;
    }

    //Metody
    public int getCapacity(){
        return capacity;
    }
    
    public int getblockCounter(){
        return blockCounter;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
}