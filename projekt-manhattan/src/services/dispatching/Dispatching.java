package services.dispatching;

import human.IDiseaseSensitive;

import java.util.List;
import container.IRecord;
import map.Being;
import services.vehicles.Ambulance;

import java.util.Iterator;
import java.util.LinkedList;

public class Dispatching extends Being{

    private List<IRecord> callerList;
    private List<Ambulance> ambulanceList;

    public Dispatching(){
        super("disp", 'i');
        callerList = new LinkedList<IRecord>();
        ambulanceList = new LinkedList<>();
    }

    public List<IRecord> getCallerList(){
        return callerList;
    }

    public void addCaller(IRecord record){
        callerList.add(record);
    }

    public void addAmbulance(Ambulance ambulance){
        ambulanceList.add(ambulance);
    }

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