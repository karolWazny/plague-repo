package services.dispatching;

import human.IDiseaseSensitive;

import java.util.List;
import container.IRecord;
import map.Being;
import services.vehicles.Ambulance;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Klasa, która jest zarządzającym obiektem dla wszystkich karetek
 * Posiada informacje o karetkach i pacjentach
 * @version 1.0
 * @see container.IRecord
 * @see map.Being
 * @see services.vehicles.Ambulance 
 * @see human.IDiseaseSensitive 
 */
public class Dispatching extends Being{
    /** Lista rekordów dla ludzi, którzy potrzebują pomocy */
    private List<IRecord> callerList;
    /** Lista rekordów z karetkami */
    private List<Ambulance> ambulanceList;

    /**
     * Metoda, konstruktor domyślny, która tworzy obiekt klasy Dispatching
     */
    public Dispatching(){
        super("disp", 'i');
        callerList = new LinkedList<IRecord>();
        ambulanceList = new LinkedList<>();
    }

    /**
     * Metoda, getter, która zwraca listę obiektów oczekujących na pomoc
     * @return lista obiektów oczekujących na karetkę
     */
    public List<IRecord> getCallerList(){
        return callerList;
    }

    /**
     * Metoda, która dodaje nowe rekordy do listy potrzebujących 
     * @param record nowy potrzebujący pomocy
     */
    public void addCaller(IRecord record){
        callerList.add(record);
    }

    /**
     * Metoda, która dodaje nowy rekord ambulansu do listy ambulansów
     * @param ambulance karetka
     */
    public void addAmbulance(Ambulance ambulance){
        ambulanceList.add(ambulance);
    }

    /**
     * Metoda, która dysponuje karetkami do potrzebujących
     */
    public void doTheJob(){
        Iterator <IRecord> iterator= callerList.iterator();
        while(iterator.hasNext()){
            if(!((IDiseaseSensitive)iterator.next().getBeing()).getIsAlive()){
                iterator.remove();
            }
        }

        for(Ambulance elem:ambulanceList){
            if(callerList.isEmpty()) {
                return;
            }
            if(elem.isFree){
                elem.setCaller(callerList.get(0));
                callerList.remove(0);
            }
        }
    }

    /**
     * Metoda, getter, która pobiera obydwie listy naraz 
     * @return łączona lista wszystkich obiektów
     */
    public List<IRecord> getBothLists(){
        List<IRecord> output = new LinkedList<>();
        output.addAll(callerList);
        IRecord buffer;
        for(Ambulance elem:ambulanceList){
            buffer = null;
            buffer = elem.getCaller();
            if(buffer != null){
                output.add(buffer);
            }
        }
        return output;
    }
}