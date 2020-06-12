package services.vehicles;

import java.util.Iterator;

import container.Coordinates;
import container.IRecord;
import human.IRecoverable;
import services.buildings.Hospital;
import human.Human;

/**
 * Klasa, ktora rozszerza klase pojazd
 * Posiada informacje dodatkowe, ktore sa potrzebne
 * @version 1.0
 * @see container.Coordinates
 * @see container.IRecord
 * @see human.IRecoverable
 * @see services.buildings.Hospital
 * @see human.Human
 */
public class Ambulance extends Vehicle implements IRecoverable {
    /** Pole, ktore posiada informacje o potrzebujacym pomocy */
    private IRecord caller;
    /** Licznik karetek */
    private static int numAmb = 0;
    /** Stan logiczny czy jest wolna */
    public boolean isFree = true;
    /** Pole z informacjami o szpitalu, do ktorego nalezy */
    private Hospital hospital;

    /**
     * Metoda, konstruktor, ktora tworzy obiekty klasy karetki i przypisuje im cechy
     * @param home garaz
     * @param gps nawigator, GPS
     * @param hospital szpital, dla ktorego pracuje
     */
    public Ambulance(Coordinates home, IGPS gps, Hospital hospital){
        super("Ambulance "+numAmb, 'A', 1, 20, home, gps);
        this.hospital = hospital;
        numAmb++;
    }

    /**
     * Metoda, ktora zwraca ciag znakow informujacy o danym obiekcie
     * @return ciag znakow z informacjami
     */
    public String toString(){
        return "Ambulance nr " + numAmb;
    }

    /**
     * Metoda, ktora wykonuje ruch karetki i jako parametr przyjmuje aktualna jej pozycje
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
                super.getIGPS().getMap().emptyField(caller.getVerHor());//zlamana zasada Demeter (znowu...)
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
     * Metoda, ktora pozwala w przyspieszony sposob wracac do zdrowia pasazerom
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
     * Metoda, getter, ktora zwraca aktualna ilosc karetek na mapie
     * @return ilosc karetek
     */
    public int getNumAmb(){
        return numAmb;
    }

    /**
     * Metoda, getter, ktora zwraca stan logiczny odpowiadajacy na pytanie: 
     * czy karetka jest wolna?
     * @return stan logiczny
     */
    public boolean getIsFree(){
        return isFree;
    }

    /**
     * Maetoda, setter, ktora dodaje pasazera do listy pasazerow
     * @param caller potrzebujacy pomocy
     */
    public void setCaller(IRecord caller){
        this.caller = caller;
        destination = new Coordinates(caller.getVerHor());
        isFree = false;
    }

    /**
     * Metoda, getter, ktora zwraca obiekt bedacy pasazerem karetki
     * @return pasazer karetki
     */
    public IRecord getCaller(){
        return caller;
    }
}