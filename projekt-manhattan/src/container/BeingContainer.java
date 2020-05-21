package container;

import java.util.List;
import java.util.ArrayList;
import map.Map;
import map.IPrintable;
import map.EmptySlot;
import map.Being;
import random.Dice;

public class BeingContainer {
    private List<IRecord> list;
    private Map map;

    ////////////////////////////

    public BeingContainer(Map map){
        list = new ArrayList<IRecord>();
        this.map = map;
    }

    ////////////////////////////
    
    public void performMovementRound()
    {
        Coordinates currentVerHor = new Coordinates(0,0);
        Coordinates newVerHor = new Coordinates(0,0);
        for(IRecord obj:list)
        {
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

    public int performInfectRound() {
        int output = 0;
        for(IRecord obj:list) {
            output += obj.infectNeighbours(map);
        }
        return output;
    }

    public int [] performDiseaseRound() {
        int killCure []= new int[]{0,0};
        int buffer;
        for(IRecord obj:list) {
            buffer = obj.progressIllness();
            if(buffer == -1) {
                killCure[0]++;
            } else if(buffer == 1) {
                killCure[1]++;
            }
        }
        return killCure;
    }

    public void performRecoveryRound() {
        for(IRecord obj:list) {
            obj.performRecovery();
        }
    }

    public boolean addRecord(Being being, Coordinates coords) {
        if(!(map.getField(coords) instanceof EmptySlot)) {
            addRecord(being); //nie wiem, czy dobre rozwiązanie problemu
        }
        list.add(new Record(being, coords));
        map.setField((IPrintable)being, coords);
        return true;
    }

    public void addRecord(Being being) {
        List<Coordinates> list = map.emptyFieldsList();
        Coordinates coords = new Coordinates(list.get(Dice.custom(list.size())-1));
        addRecord(being, coords);
    }
    ////////////////////////////

    ////////////////////////////

    public List<IRecord> getList(){
        return list;
    }

    public Map getMap(){
        return map;
    }
}