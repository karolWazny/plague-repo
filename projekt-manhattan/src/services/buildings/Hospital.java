package services.buildings;

import java.util.ArrayList;
import java.util.List;
import human.Human;
import container.IRecord;
import map.Being;



public class Hospital extends Building {
    private static int hospitalCounter = 0;
    private List<IRecord> list;
   
    ////////////////////////////
    //Konstruktor
    public Hospital(){
        super("Hospital", 'H', 100);
        hospitalCounter++;
        list = new ArrayList<IRecord>();
    }

    public Hospital(String id, char representation, int capacity){
        super(id, representation, capacity);
        hospitalCounter++;
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
    
    public void recoverPatient(){
        for(IRecord obj:list){
           obj.performRecovery();
        }
    }

    public void leaveHospital(){
        for(IRecord obj:list){
            Being buffer = obj.getBeing();
            if(!(obj.getIsInfected()))
            list.remove(obj);
        }
    }
}   