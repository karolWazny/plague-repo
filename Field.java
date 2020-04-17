package map;

import person.*;
import java.util.ArrayList;
import java.util.List;

public class Field {

    int capacity;
    List<Object> list = new ArrayList<Object>();

    public Field(){

    }

    public void addPerson(Person human){
        if(list.size()<capacity)
        list.add(human);
    }
    public void removePerson(Person human){
        if(list.size()!=0)
        list.remove(human);
    }
        
    }
