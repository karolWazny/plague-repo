package services.buildings;

import map.Being;

/**
 * Klasa, ktora abstrakcyjnie przedstawia budynki, ktore posiadaja zdolnosc 
 */
public abstract class Building extends Being{
    /** Pole, ktore jest licznikiem budynkow */
    private static int blockCounter = 0;
    /** Pojemnosc budynku */
    private int capacity;
   
    /**
     * Metoda, konstruktor, ktora tworzy obiekty klasy building
     * @param id ciag znakow identyikujacych
     * @param representation reprezentacja znakowa
     * @param capacity pojemnosc
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
     * Metoda, setter, ktora ustawia pojemnosc budynku
     * @param capacity pojemnosc
     */
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc pojemnosci budynku
     * @return pojemnosc
     */
    public int getCapacity(){
        return capacity;
    }
    
    /**
     * Metoda, ktora zwraca statyczna wartosc dla obiektow tej klasy
     * @return licznik budynkow
     */
    public int getblockCounter(){
        return blockCounter;
    }
}