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



public class Hospital extends Building implements IMovable, IRecoverable{

    private Map map;
    private static int hospitalCounter = 0;
    private List<IRecord> list;
   
    ////////////////////////////
    //Konstruktor
    public Hospital(Map map){
        super("Hospital", 'H', 100);
        this.map = map;
        hospitalCounter++;
        list = new ArrayList<IRecord>();
    }

    ////////////////////////////

    ////////////////////////////
    //Metody
    public int getHospitalCounter(){
        return hospitalCounter;
    }

    public List<IRecord> getList(){
        return list;
    }
    
    public void recover(){
        for(int i = 0; i < 2; i++){
            for(IRecord obj:list){
                obj.performRecovery();
            }
        }
    }

    //@Override
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