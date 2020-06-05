package services.vehicles;

import java.util.Iterator;

import container.Coordinates;
import container.IRecord;
import human.IRecoverable;
import services.buildings.Hospital;
import human.Human;

/**
 * Klasa, która rozszerza klasę pojazd
 * Posiada informacje dodatkowe, które są potrzebne
 * @version 1.0
 * @see container.Coordinates
 * @see container.IRecord
 * @see human.IRecoverable
 * @see services.buildings.Hospital
 * @see human.Human
 */
public class Ambulance extends Vehicle implements IRecoverable {
    /** Pole, które posiada informacje o potrzebującym pomocy */
    private IRecord caller;
    /** Licznik karetek */
    private static int numAmb = 0;
    /** Stan logiczny czy jest wolna */
    public boolean isFree = true;
    /** Pole z informacjami o szpitalu, do którego należy */
    private Hospital hospital;

    /**
     * Metoda, konstruktor, która tworzy obiekty klasy karetki i przypisuje im cechy
     * @param home garaż
     * @param gps nawigator, GPS
     * @param hospital szpital, dla którego pracuje
     */
    public Ambulance(Coordinates home, IGPS gps, Hospital hospital){
        super("Ambulance "+numAmb, 'A', 1, 20, home, gps);
        this.hospital = hospital;
        numAmb++;
    }

    /**
     * Metoda, która zwraca ciąg znaków informujący o danym obiekcie
     * @return ciąg znaków z informacjami
     */
    public String toString(){
        return "Ambulance nr " + numAmb;
    }

    /**
     * Metoda, która wykonuje ruch karetki i jako parametr przyjmuje aktualną jej pozycję
     * @param currentPosition aktualna pozycja
     * @return nowe koordynaty
     */
    public Coordinates move(Coordinates currentPosition){
        Coordinates out = super.move(currentPosition);
        if(out.isNextTo(destination)){
            if(destination.equals(home)){
                hospital.getList().addAll(passengers);
                passengers.clear();
                isFree = true;
            } else{
                super.addPassenger(caller);
                super.getIGPS().getMap().emptyField(caller.getVerHor());//złamana zasada Demeter (znowu...)
                caller.setVerHor(null);
                caller = null;
                super.destination = new Coordinates(home);
                if(passengers.size()<super.getCapacity()){
                    isFree=true;
                }
            }
        }
        return out;
    }

    /**
     * Metoda, która pozwala w przyspieszony sposób wracać do zdrowia pasażerom
     */
    public void recover(){
        Iterator <IRecord>iterator = passengers.iterator();
        Human patient;
        while(iterator.hasNext()){
            patient = (Human)iterator.next().getBeing();
            if(!patient.getIsAlive()){
                iterator.remove();
                isFree = true;
                continue;
            }
            patient.setHealthPoints(patient.getHealthPoints()+5);
        }
    }

    /**
     * Metoda, getter, która zwraca aktualną ilość karetek na mapie
     * @return ilość karetek
     */
    public int getNumAmb(){
        return numAmb;
    }

    /**
     * Metoda, getter, która zwraca stan logiczny odpowiadający na pytanie: 
     * czy karetka jest wolna?
     * @return stan logiczny
     */
    public boolean getIsFree(){
        return isFree;
    }

    /**
     * Maetoda, setter, która dodaje pasażera do listy pasażerów
     * @param caller potrzebujący pomocy
     */
    public void setCaller(IRecord caller){
        this.caller = caller;
        destination = new Coordinates(caller.getVerHor());
        isFree = false;
    }

    /**
     * Metoda, getter, która zwraca obiekt będący pasażerem karetki
     * @return pasażer karetki
     */
    public IRecord getCaller(){
        return caller;
    }
}