package app;

/**
 * Klasa, ktorej obiekty przechowuja informacje na temat konkretnej
 * rundy poruszania sie, chorowania, itp. na mapie
 * @version 1.0
 */
public class SimulationState {
    /**
     * Pole opisujace calkowita liczbe ludzi na mapie
     */
    private final int numPeople;
    /**
     * Pole opisujace calkowita liczbe zainfekowanych na mapie
     */
    private final int numInfected;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy przechowujacej informacje
     * o stanie ludzkiej populacji po jednej rundzie
     * @param numPeople calkowita liczba ludzi
     * @param numInfected calkowita liczba zainfekowanych
     */
    public SimulationState (int numPeople, int numInfected) {
        this.numPeople = numPeople;
        this.numInfected = numInfected;
    }

    /**
     * Metoda, ktora zwraca ciag znakow opisujacy obiekt tej klasy
     * @return ciag znakow opisujacych obiekt
     */
    public String toString(){
        return "Alive: "+numPeople+", infected: "+numInfected;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe ludzi zapisana w obiekcie
     * @return liczba ludzi
     */
    public int getNumPeople() {
        return numPeople;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe zainfekowanych zapisana w obiekcie
     * @return liczba zainfekowanych
     */
    public int getNumInfected(){
        return numInfected;
    }
}