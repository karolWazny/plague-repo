package services.dispatching;

import human.IDiseaseSensitive;

import java.util.List;
import container.IRecord;
import map.Being;
import services.vehicles.Ambulance;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Klasa, ktora jest zarzadzajacym obiektem dla wszystkich karetek
 * Posiada informacje o karetkach i pacjentach
 * @version 1.0
 * @see container.IRecord
 * @see map.Being
 * @see services.vehicles.Ambulance 
 * @see human.IDiseaseSensitive 
 */
public class Dispatching extends Being{
    /** Lista rekordow dla ludzi, ktorzy potrzebuja pomocy */
    private List<IRecord> callerList;
    /** Lista rekordow z karetkami */
    private List<Ambulance> ambulanceList;

    /**
     * Metoda, konstruktor domyslny, ktora tworzy obiekt klasy Dispatching
     */
    public Dispatching(){
        super("disp", 'i');
        callerList = new LinkedList<IRecord>();
        ambulanceList = new LinkedList<>();
    }

    /**
     * Metoda, getter, ktora zwraca liste obiektow oczekujacych na pomoc
     * @return lista obiektow oczekujacych na karetke
     */
    public List<IRecord> getCallerList(){
        return callerList;
    }

    /**
     * Metoda, ktora dodaje nowe rekordy do listy potrzebujacych 
     * @param record nowy potrzebujacy pomocy
     */
    public void addCaller(IRecord record){
        callerList.add(record);
    }

    /**
     * Metoda, ktora dodaje nowy rekord ambulansu do listy ambulansow
     * @param ambulance karetka
     */
    public void addAmbulance(Ambulance ambulance){
        ambulanceList.add(ambulance);
    }

    /**
     * Metoda, ktora dysponuje karetkami do potrzebujacych
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
     * Metoda, getter, ktora pobiera obydwie listy naraz 
     * @return laczona lista wszystkich obiektow
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