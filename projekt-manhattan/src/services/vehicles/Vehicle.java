package services.vehicles;

import java.util.List;
import java.util.ArrayList;

import container.IMovable;
import container.Coordinates;
import container.IRecord;
import map.Being;

/**
 * Klasa, która definiuje cechy ogólnie pojętych pojazdów
 * Posiada wszystkie niezbędne funkcjonalności do poruszania się po mapie i 
 * do przewożenia obiektów
 * @version 1.0
 * @see container.IMovable
 * @see container.Coordinates
 * @see container.IRecord
 * @see map.Being
 */
public abstract class Vehicle extends Being implements IMovable{
    /** Pole z pojemnością pojazdu */
    private int capacity;
    /** Prędkość pojazdu */
    private int velocity;
    /** Cel podróży */
    protected Coordinates destination;
    /** koordynaty garażu */
    protected final Coordinates home; 
    /** zmienna statyczna - ilość pojazdów */
    private static int numVeh = 0;
    /** pole z obiektem gps */
    private IGPS gps;
    /** Lista pasażerów pojazdu */
    protected List<IRecord> passengers;
    
    /**
     * Metoda, konstruktor, która tworzy obiekty klasy pojazd
     * @param id identyfikator - ciąg znaków
     * @param representation reprezentacja znakowa
     * @param capacity pojemność
     * @param velocity szybkość
     * @param home koordynaty garażu
     * @param gps obiekt gps-u
     */
    public Vehicle(String id, char representation, int capacity, int velocity, Coordinates home, IGPS gps){
        super(id, representation);
        this.gps = gps;
        this.capacity = capacity;
        this.velocity = velocity;
        this.home = new Coordinates(home);
        destination = new Coordinates(home);
        passengers = new ArrayList<>();
        numVeh++;
    }

    /**
     * Metoda, która zwraca reprezentację znakową konkretnej instancji obiektu
     * @return ciąg znaków charakterystyczny dla obiektu
     */
    public String toString(){
        return "Vehicle nr " + numVeh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    /** 
     * Metoda, która jest odpowiedzialna za ruch
     * @param currentPosition aktualna pozycja 
     * @return nowa pozycja
     */
    public Coordinates move(Coordinates currentPosition){
        Coordinates newPosition = gps.navigate(currentPosition, destination, velocity);        
        return newPosition;
    }

    //Dodaję pasażera do pojazdu, jeśli nie ma miejsca, nie robię tego
    /**
     * Metoda, która dodaje pasażera do pojazdu, jeśli nie ma miejsca, nie robię tego
     * @param passenger obiekt pasażer
     */
    public void addPassenger(IRecord passenger){
        if(passengers.size()<this.capacity){
            this.passengers.add(passenger);
        }
        else{
            return;
        }   
    }

    /**
     * Metoda, setter, która ustawia pole gps
     * @param gps pole gps
     */
    public void setGPS (IGPS gps) {
        this.gps = gps;
    }

    /**
     * Metoda, getter, która zwraca szybkość pojazdu
     * @return szybkość pojazdu
     */
    public int getVelocity(){
        return velocity;
    }

    /**
     * Metoda, getter, która zwraca pojemność pojazdu
     * @return pojemność pojazdu
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Metoda, getter, która zwraca liczbę wszystkich instancji klasy pojazd
     * @return liczba pojazdów
     */
    public int getNumVeh(){
        return numVeh;
    }

    /**
     * Metoda, getter, która zwraca listę pasażerów pojazdu
     * @return lista pasażerów
     */
    public List<IRecord> getPassengers(){
        return passengers;
    }

    /**
     * Metoda, getter, która zwraca obiekt pełniący rolę GPS
     * @return GPS
     */
    public IGPS getIGPS() {
        return gps;
    }
}