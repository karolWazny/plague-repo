package services.buildings;

import map.Being;

/**
 * Klasa, ktora abstrakcyjnie przedstawia budynki, ktore posiadaja zdolnosć 
 */
public abstract class Building extends Being{
    /** Pole, ktore jest licznikiem budynkow */
    private static int blockCounter = 0;
    /** Pojemnosć budynku */
    private int capacity;
   
    /**
     * Metoda, konstruktor, ktora tworzy obiekty klasy building
     * @param id ciag znakow identyikujacych
     * @param representation reprezentacja znakowa
     * @param capacity pojemnosć
     */
    public Building(String id, char representation, int capacity){ //Hospital
        super(id, representation);
        this.capacity = capacity;
        blockCounter++;
    }
    
    /**
     * Metoda, konstruktor domyslny, ktory tworzy obiekt tej klasy o domyslnych parametrach
     */
    public Building(){
        super("Block "+ blockCounter, 'B');
        blockCounter++;
    }

    /**
     * Metoda, setter, ktora ustawia pojemnosć budynku
     * @param capacity pojemnosć
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    /**
     * Metoda, getter, ktora zwraca wartosć pojemnosci budynku
     * @return pojemnosć
     */
    public int getCapacity(){
        return capacity;
    }
    
    /**
     * Metoda, ktora zwraca statyczna wartosć dla obiektow tej klasy
     * @return licznik budynkow
     */
    public int getblockCounter(){
        return blockCounter;
    }
}