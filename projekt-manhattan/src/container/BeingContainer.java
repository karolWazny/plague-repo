package container;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import map.Map;
import map.IPrintable;
import map.Being;
import random.Dice;
import services.dispatching.Dispatching;

/**
 * Klasa, która jest swoistym kontenerem bytów
 * W jej wnętrzu przechowywane są wszystkie informacje o symulacji, o obiektach 
 * tworzonych w jej trakcie i interakcjach między nimi
 * @version 1.0
 * @see map.Map
 * @see map.IPrintable
 * @see map.Being
 * @see random.Dice
 * @see services.dispatching.Dispatching
 * @see container.Coordinates
 */
public class BeingContainer {
    /**
     * Pole, które jest listą rekordów - serce kontenera
     */
    private List<IRecord> list;
    /**
     * Pole, które posiada o informacje o używanej mapie
     */
    private Map map;
    /**
     * Pole, które posiada obiekt zarządzający pojazdami
     */
    private Dispatching dispatching;

    /**
     * Metoda, konstruktor, która tworzy obiekt tej klasy
     * @param map mapa, po której będziemy się poruszać
     * @param dispatching obiekt zarządzający pojazdami
     */
    public BeingContainer(Map map, Dispatching dispatching){
        list = new ArrayList<IRecord>();
        this.map = map;
        this.dispatching = dispatching;
    }

    /**
     * Metoda, która wykonuje ruch i wszystkie inne czynności dla obiektów zawartych
     * w kontenerze.
     * Jest to iteracja po wszystkich obiektach zawartych w kontenerze
     */    
    public void performMovementRound()
    {
        Coordinates currentVerHor = new Coordinates(0,0);
        Coordinates newVerHor = new Coordinates(0,0);
        for(IRecord obj:list)
        {
            if(obj!=null){
                if(obj.getVerHor() != null){
                    currentVerHor.setCoordinates(obj.getVerHor());
                    obj.move();
                    newVerHor.setCoordinates(obj.getVerHor());
                    obj.setVerHor(currentVerHor);
                    if(map.getLength() <= newVerHor.getVertical() || newVerHor.getVertical() < 0)
                    {
                        continue;
                    }
                    if(map.getWidth() <= newVerHor.getHorizontal() || newVerHor.getHorizontal() < 0)
                    {
                        continue;
                    }
                    if(map.getField(newVerHor).getId()!="empty")
                    {
                        continue;
                    }
                    obj.setVerHor(newVerHor);
                    map.emptyField(currentVerHor);
                    map.setField((IPrintable) obj.getBeing(), newVerHor);
                }
            }
        }
        dispatching.doTheJob();
    }

    /**
     * Metoda, która iteruje po każdym obiekcie z listy i symuluje zarażanie
     * @return Liczba zainfekowanych
     */
    public int performInfectRound() {
        int output = 0;
        for(IRecord obj:list) {
            if(obj.getVerHor() != null){
                output += obj.infectNeighbours(map);
            }
        }
        return output;
    }

    /**
     * Metoda, która wykonuje rozwój choroby dla wszystkich obiektów na mapie
     * @return tablica z liczbą zabitych i ozdrowieńców
     */
    public int [] performDiseaseRound() {
        int killCure []= new int[]{0,0};
        int buffer[];
        IRecord obj;
        Iterator<IRecord> iter = list.iterator();
        while(iter.hasNext()) {
            obj = iter.next();
            buffer = obj.progressIllness();
            if(buffer[0] == -1) {
                killCure[0]++;
                map.emptyField(obj.getVerHor());
                iter.remove();
            } else if(buffer[0] == 1) {
                killCure[1]++;
            }
            if(buffer[1] == 1 && !(dispatching.getBothLists().contains(obj))){
                dispatching.addCaller(obj);
            }
        }
        return killCure;
    }

    /**
     * Metoda, która iteruje po rekordach i dokonuje leczenia obiektów
     */
    public void performRecoveryRound() {
        for(IRecord obj:list) {
            obj.performRecovery();
        }
    }

    /**
     * Metoda, która dodaje do listy rekordów nowy obiekt rekordu
     * @param being byt, który dodajemy
     * @param coords koordynaty bytu
     * @return stan logiczny, że dodano rekord
     */
    public boolean addRecord(Being being, Coordinates coords) {
        list.add(new Record(being, coords));
        map.setField((IPrintable)being, coords);
        return true;
    }

    /**
     * Metoda, która w losowym miejscu na mapie dodaje obiekty do listy rekordów
     * @param being Byt, który chcemy dodać
     */
    public void addRecord(Being being) {
        List<Coordinates> list = map.emptyFieldsList();
        Coordinates coords = new Coordinates(list.get(Dice.custom(list.size())-1));
        addRecord(being, coords);
    }

    /**
     * MEtoda, getter, która zwraca listę obiektów będących w kontenerze
     * @return lista rekordów
     */
    public List<IRecord> getList(){
        return list;
    }

    /**
     * Metoda, getter, zwracająca mapę, której używamy
     * @return mapa
     */
    public Map getMap(){
        return map;
    }
}