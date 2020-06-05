package services.buildings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import human.IDiseaseSensitive;
import human.IRecoverable;
import container.Coordinates;
import container.IMovable;
import container.IRecord;
import map.IPrintable;
import map.Map;

/**
 * Klasa, która odzwierciedla budynek jako szpital
 * Posiada funkcjonalności typowe dla szpitala.
 * @version 1.0
 * @see human.IDiseaseSensitive
 * @see human.IRecoverable
 * @see container.Coordinates
 * @see container.IMovable
 * @see container.IRecord
 * @see map.IPrintable
 * @see map.Map
 */
public class Hospital extends Building implements IMovable, IRecoverable{
    /** Pole, które posiada informację o mapie */
    private Map map;
    /** Pole, które jest licznikiem szpitali wszystkich */
    private static int hospitalCounter = 0;
    /** Pole, które posiada listę Recordów */
    private List<IRecord> list;

    /**
     * Metoda, konstruktor, który tworzy obiekt klasy Szpital 
     * @param map mapa
     */
    public Hospital(Map map){
        super("Hospital", 'H', 100);
        this.map = map;
        hospitalCounter++;
        list = new ArrayList<IRecord>();
    }

    /**
     * Metoda, getter, która zwraca liczbę szpitali na mapie
     * @return liczba szpitali
     */
    public int getHospitalCounter(){
        return hospitalCounter;
    }

    /**
     * Metoda, getter, która zwraca listę rekordów 
     * @return lista rekordów
     */
    public List<IRecord> getList(){
        return list;
    }
    
    /**
     * Metoda, która symuluje zdrowienie 
     */
    public void recover(){
        for(int i = 0; i < 2; i++){
            for(IRecord obj:list){
                obj.performRecovery();
            }
        }
    }

    /**
     * Metoda, która przyjmuje jako parametr obiekt typu koordynaty i zwraca 
     * nowe koordynaty 
     * @param currentPosition aktualna pozycja
     * @return nowe koordynaty
     */
    public Coordinates move(Coordinates currentPosition){
        Iterator<IRecord> iterator = list.iterator();
        IDiseaseSensitive humanBuffer;
        IRecord recordBuffer;
        Coordinates coords;
        while(iterator.hasNext()){
            recordBuffer = iterator.next();
            humanBuffer = (IDiseaseSensitive)recordBuffer.getBeing();
            if(!humanBuffer.getIsAlive()){
                iterator.remove();
                continue;
            } else if(!humanBuffer.getIsInfected()){
                coords = map.emptyFieldsList().get(0);
                recordBuffer.setVerHor(new Coordinates(coords));
                map.setField((IPrintable)humanBuffer, coords);
                iterator.remove();
            }
        }
        return currentPosition;
    }
}   