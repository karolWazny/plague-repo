package services.buildings;

import map.Being;

/**
 * Klasa, która abstrakcyjnie przedstawia budynki, które posiadają zdolność 
 */
public abstract class Building extends Being{
    /** Pole, które jest licznikiem budynków */
    private static int blockCounter = 0;
    /** Pojemność budynku */
    private int capacity;

    public Building(){
        super("Block "+ blockCounter, 'B');
        blockCounter++;
    }
    
    public Building(String id, char representation, int capacity){ //Hospital
        super(id, representation);
        this.capacity = capacity;
        blockCounter++;
    }

    /**
     * Metoda, konstruktor domyślny, który tworzy obiekt tej klasy o domyślnych parametrach
     */
    public Building(){
        super("Block "+ blockCounter, 'B');
        blockCounter++;
    }

    /**
     * Metoda, setter, która ustawia pojemność budynku
     * @param capacity pojemność
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    /**
     * Metoda, getter, która zwraca wartość pojemności budynku
     * @return pojemność
     */
    public int getCapacity(){
        return capacity;
    }
    
    /**
     * Metoda, która zwraca statyczną wartość dla obiektów tej klasy
     * @return licznik budynków
     */
    public int getblockCounter(){
        return blockCounter;
    }
}