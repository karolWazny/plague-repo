package services.dispatching;


import java.util.List;
import container.IRecord;
import java.util.LinkedList;

public class Dispatching {

    private List<IRecord> list;

    public Dispatching(){
        list = new LinkedList<IRecord>();
    }

    public List<IRecord> getList(){
        return list;
    }

    public void addPatient(IRecord record){
        list.add(record);
    }

    public void pickUpPatient(){
        for(IRecord obj:list){
            
        }
    }
}