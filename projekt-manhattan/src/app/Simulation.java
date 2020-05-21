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
        numInfected = 1;
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
        int [] buffer;
        container.performMovementRound();
        numInfected += container.performInfectRound();
        buffer = container.performDiseaseRound();
        numInfected -= buffer[0];
        numInfected -= buffer[1];
        numPeople -= buffer[0];
        container.performRecoveryRound();
    }

    public void doSimulation() {
        for(int i = 0; i < 100; i++) {
            performRound();
            System.out.println("People: "+numPeople+", infected: "+numInfected);
        }
    }

    public void display() {
        map.displayMap();
    }

    ////////////////

}