package services.buildings;

import map.Being;

public abstract class Building extends Being{
    private static int blockCounter = 0;
    private int capacity;
    
    ////////////////////////////

    public Building(){
        super("Block "+ blockCounter, 'B');
        blockCounter++;
    }
    public Building(String id, char representation, int capacity){ //Hospital
        super(id, representation);
        this.capacity = capacity;
        blockCounter++;
    }

    ////////////////////////////
    
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    
    ////////////////////////////
    
    public int getCapacity(){
        return capacity;
    }
    
    public int getblockCounter(){
        return blockCounter;
    }
}