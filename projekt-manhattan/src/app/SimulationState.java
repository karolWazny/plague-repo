package app;

/**
 * Klasa, której obiekty przechowują informacje na temat konkretnej
 * rundy poruszania się, chorowania, itp. na mapie
 * @version 1.0
 */
public class SimulationState {
    /**
     * Pole opisujące całkowitą liczbę ludzi na mapie
     */
    private final int numPeople;
    /**
     * Pole opisujące całkowitą liczbę zainfekowanych na mapie
     */
    private final int numInfected;

    /**
     * Metoda, konstruktor, która tworzy obiekt klasy przechowującej informacje
     * o stanie ludzkiej populacji po jednej rundzie
     * @param numPeople całkowita liczba ludzi
     * @param numInfected całkowita liczba zainfekowanych
     */
    public SimulationState (int numPeople, int numInfected) {
        this.numPeople = numPeople;
        this.numInfected = numInfected;
    }

    /**
     * Metoda, która zwraca ciąg znaków opisujący obiekt tej klasy
     * @return ciąg znaków opisujących obiekt
     */
    public String toString(){
        return "Alive: "+numPeople+", infected: "+numInfected;
    }

    /**
     * Metoda, getter, która zwraca liczbę ludzi zapisaną w obiekcie
     * @return liczba ludzi
     */
    public int getNumPeople() {
        return numPeople;
    }

    /**
     * Metoda, getter, która zwraca liczbę zainfekowanych zapisaną w obiekcie
     * @return liczba zainfekowanych
     */
    public int getNumInfected(){
        return numInfected;
    }
}