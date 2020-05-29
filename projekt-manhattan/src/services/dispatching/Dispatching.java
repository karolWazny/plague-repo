package services.dispatching;


import map.Being;

import java.util.List;
import java.util.LinkedList;

public class Dispatching {

    private List<Being> list;

    public Dispatching(){
        list = new LinkedList<Being>();
    }

    public void addPatient(Being record){
        list.add(record);
    }

    public void pickUpPatient(){
        for(Being obj:list){
            
        }
    }
}