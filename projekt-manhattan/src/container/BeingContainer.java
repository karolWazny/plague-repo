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
 * Klasa, ktora jest swoistym kontenerem bytow
 * W jej wnetrzu przechowywane sa wszystkie informacje o symulacji, o obiektach 
 * tworzonych w jej trakcie i interakcjach miedzy nimi
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
     * Pole, ktore jest lista rekordow - serce kontenera
     */
    private List<IRecord> list;
    /**
     * Pole, ktore posiada o informacje o uzywanej mapie
     */
    private Map map;
    /**
     * Pole, ktore posiada obiekt zarzadzajacy pojazdami
     */
    private Dispatching dispatching;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt tej klasy
     * @param map mapa, po ktorej bedziemy sie poruszac
     * @param dispatching obiekt zarzadzajacy pojazdami
     */
    public BeingContainer(Map map, Dispatching dispatching){
        list = new ArrayList<IRecord>();
        this.map = map;
        this.dispatching = dispatching;
    }

    /**
     * Metoda, ktora wykonuje ruch i wszystkie inne czynnosci dla obiektow zawartych
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
     * Metoda, ktora iteruje po kazdym obiekcie z listy i symuluje zarazanie
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
     * Metoda, ktora wykonuje rozwoj choroby dla wszystkich obiektow na mapie
     * @return tablica z liczba zabitych i ozdrowieńcow
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
     * Metoda, ktora iteruje po rekordach i dokonuje leczenia obiektow
     */
    public void performRecoveryRound() {
        for(IRecord obj:list) {
            obj.performRecovery();
        }
    }

    /**
     * Metoda, ktora dodaje do listy rekordow nowy obiekt rekordu
     * @param being byt, ktory dodajemy
     * @param coords koordynaty bytu
     * @return stan logiczny, ze dodano rekord
     */
    public boolean addRecord(Being being, Coordinates coords) {
        list.add(new Record(being, coords));
        map.setField((IPrintable)being, coords);
        return true;
    }

    /**
     * Metoda, ktora w losowym miejscu na mapie dodaje obiekty do listy rekordow
     * @param being Byt, ktory chcemy dodac
     */
    public void addRecord(Being being) {
        List<Coordinates> list = map.emptyFieldsList();
        Coordinates coords = new Coordinates(list.get(Dice.custom(list.size())-1));
        addRecord(being, coords);
    }

    /**
     * MEtoda, getter, ktora zwraca liste obiektow bedacych w kontenerze
     * @return lista rekordow
     */
    public List<IRecord> getList(){
        return list;
    }

    /**
     * Metoda, getter, zwracajaca mape, ktorej uzywamy
     * @return mapa
     */
    public Map getMap(){
        return map;
    }
}