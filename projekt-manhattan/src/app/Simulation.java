package app;

import map.Map;
import container.*;
import java.util.List;
import random.Dice;
import human.Human;
import human.Doctor;
import virus.Virus;

public class Simulation {
    private Map map;
    private BeingContainer container;
    private Virus strain;

    ////////////////////////

    Simulation(SimulationParameters parameters) {
        map = new Map(parameters.mapLength, parameters.mapWidth);
        container = new BeingContainer(map);
        List<Coordinates> list = map.emptyFieldsList();
        int listLength = list.size();
        if((parameters.numPeople + parameters.numDocs + parameters.numAmbulance + parameters.numHearse + 8)>listLength)
         return;
        int roll;
        for(int i = 0; i<parameters.numPeople - parameters.numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            container.addRecord(new Human(), new Coordinates(list.get(roll)));
            list.remove(roll);
            listLength--;
        }
        for(int i = 0; i < parameters.numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            container.addRecord(new Doctor(), new Coordinates(list.get(roll)));
            list.remove(roll);
            listLength--;
        }
        strain = new Virus(parameters.power1, parameters.power2, parameters.timeTilInfect, parameters.timeTilCured, parameters.infectionRate, parameters.activeRate);
    }


    /////////////////

    ////////////////

}