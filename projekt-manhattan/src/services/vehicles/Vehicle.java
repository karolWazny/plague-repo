package services.vehicles;

import java.util.List;
import java.util.ArrayList;

import container.IMovable;
import container.Coordinates;
import container.IRecord;
import map.Being;

/**
 * Klasa, ktora definiuje cechy ogolnie pojetych pojazdow
 * Posiada wszystkie niezbedne funkcjonalnosci do poruszania sie po mapie i 
 * do przewozenia obiektow
 * @version 1.0
 * @see container.IMovable
 * @see container.Coordinates
 * @see container.IRecord
 * @see map.Being
 */
public abstract class Vehicle extends Being implements IMovable{
    /** Pole z pojemnoscia pojazdu */
    private int capacity;
    /** Predkosc pojazdu */
    private int velocity;
    /** Cel podrozy */
    protected Coordinates destination;
    /** koordynaty garazu */
    protected final Coordinates home; 
    /** zmienna statyczna - ilosc pojazdow */
    private static int numVeh = 0;
    /** pole z obiektem gps */
    private IGPS gps;
    /** Lista pasazerow pojazdu */
    protected List<IRecord> passengers;
    
    /**
     * Metoda, konstruktor, ktora tworzy obiekty klasy pojazd
     * @param id identyfikator - ciag znakow
     * @param representation reprezentacja znakowa
     * @param capacity pojemnosc
     * @param velocity szybkosc
     * @param home koordynaty garazu
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
     * Metoda, ktora zwraca reprezentacje znakowa konkretnej instancji obiektu
     * @return ciag znakow charakterystyczny dla obiektu
     */
    public String toString(){
        return "Vehicle nr " + numVeh + " with capacity " + this.capacity + 
        " and velocity " + this.velocity;
    }

    /** 
     * Metoda, ktora jest odpowiedzialna za ruch
     * @param currentPosition aktualna pozycja 
     * @return nowa pozycja
     */
    public Coordinates move(Coordinates currentPosition){
        Coordinates newPosition = gps.navigate(currentPosition, destination, velocity);        
        return newPosition;
    }

    //Dodaje pasazera do pojazdu, jesli nie ma miejsca, nie robie tego
    /**
     * Metoda, ktora dodaje pasazera do pojazdu, jesli nie ma miejsca, nie robie tego
     * @param passenger obiekt pasazer
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
     * Metoda, setter, ktora ustawia pole gps
     * @param gps pole gps
     */
    public void setGPS (IGPS gps) {
        this.gps = gps;
    }

    /**
     * Metoda, getter, ktora zwraca szybkosc pojazdu
     * @return szybkosc pojazdu
     */
    public int getVelocity(){
        return velocity;
    }

    /**
     * Metoda, getter, ktora zwraca pojemnosc pojazdu
     * @return pojemnosc pojazdu
     */
    public int getCapacity(){
        return capacity;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe wszystkich instancji klasy pojazd
     * @return liczba pojazdow
     */
    public int getNumVeh(){
        return numVeh;
    }

    /**
     * Metoda, getter, ktora zwraca liste pasazerow pojazdu
     * @return lista pasazerow
     */
    public List<IRecord> getPassengers(){
        return passengers;
    }

    /**
     * Metoda, getter, ktora zwraca obiekt pelniacy role GPS
     * @return GPS
     */
    public IGPS getIGPS() {
        return gps;
    }
}