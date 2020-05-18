package app;

import map.Map;
import container.*;
import java.util.List;
import random.Dice;
import human.Human;
import human.Doctor;

public class Simulation {
    private Map map;
    private BeingContainer container;

    ////////////////////////

    Simulation(int mapLength, int mapWidth, int numPeople, int numDocs, int numAmbulance, int numHearse) {
        map = new Map(mapLength, mapWidth);
        container = new BeingContainer(map);
        List<Coordinates> list = map.emptyFieldsList();
        int listLength = list.size();
        if((numPeople + numDocs + numAmbulance + numHearse + 8)>listLength)
         return;
        int roll;
        for(int i = 0; i<numPeople - numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            container.addRecord(new Human(), new Coordinates(list.get(roll)));
            list.remove(roll);
            listLength--;
        }
        for(int i = 0; i < numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            container.addRecord(new Doctor(), new Coordinates(list.get(roll)));
            list.remove(roll);
            listLength--;
        }
    }


    /////////////////

    ////////////////

}