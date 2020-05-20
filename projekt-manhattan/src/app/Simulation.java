package app;

import map.Map;
import container.*;
import java.util.List;
import random.Dice;
import human.Human;
import human.Doctor;
import virus.DiseaseRecord;
import virus.Virus;

public class Simulation {
    private Map map;
    private BeingContainer container;
    private Virus strain;
    private int numPeople;
    private int numInfected;

    ////////////////////////

    Simulation(SimulationParameters parameters) {
        numPeople = parameters.numPeople;
        map = new Map(parameters.mapLength, parameters.mapWidth);
        container = new BeingContainer(map);
        strain = new Virus(parameters.power1, parameters.power2, parameters.timeTilInfect, parameters.timeTilCured, parameters.infectionRate, parameters.activeRate);
        List<Coordinates> list = map.emptyFieldsList();
        int listLength = list.size();
        if((parameters.numPeople + parameters.numDocs + parameters.numAmbulance + parameters.numHearse + 8)>listLength)
            return;
        int roll;
        for(int i = 0; i<parameters.numPeople - parameters.numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            if(i==0) {
                Human patientZero = new Human();
                patientZero.getDiseases().add(new DiseaseRecord(strain, patientZero));
                patientZero.setIsInfected(true);
                container.addRecord(patientZero, new Coordinates(list.get(roll)));
            } else {
                container.addRecord(new Human(), new Coordinates(list.get(roll)));
            }
            list.remove(roll);
            listLength--;
        }
        for(int i = 0; i < parameters.numDocs; i++) {
            roll = Dice.custom(listLength) - 1;
            container.addRecord(new Doctor(), new Coordinates(list.get(roll)));
            list.remove(roll);
            listLength--;
        }
    }


    /////////////////

    private void performRound() {
        container.performMovementRound();
        container.performInfectRound();
        container.performDiseaseRound();
        container.performRecoveryRound();
        map.displayMap();
    }

    public void doSimulation() {
        for(int i = 0; i < 20; i++) {
            performRound();
            System.out.println("///////////////////");
        }
    }

    ////////////////

}