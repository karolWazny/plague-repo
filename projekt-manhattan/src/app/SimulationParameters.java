package app;

import java.io.File;

public class SimulationParameters {
    int mapLength;
    int mapWidth;
    int numPeople;
    int numDocs;
    int numAmbulance;
    int numHearse;
    int power1;
    int power2;
    int timeTilInfect;
    int timeTilCured;
    int infectionRate;
    int activeRate;

    ///////////////////////////////////

    SimulationParameters(int mapLength, int mapWidth, int numPeople, int numDocs, int numAmbulance, int numHearse, int power1,
    int power2, int timeTilInfect, int timeTilCured, int infectionRate, int activeRate) {
        this.mapLength = mapLength;
        this.mapWidth = mapWidth;
        this.numPeople = numPeople;
        this.numDocs = numDocs;
        this.numAmbulance = numAmbulance;
        this.numHearse = numHearse;
        this.power1 = power1;
        this.power2 = power2;
        this.timeTilInfect = timeTilInfect;
        this.timeTilCured = timeTilCured;
        this.infectionRate = infectionRate;
        this.activeRate = activeRate;
    }

    SimulationParameters(){
        this.mapLength = 50;
        this.mapWidth = 50;
        this.numPeople = 10;
        this.numDocs = 5;
        this.numAmbulance = 2;
        this.numHearse = 2;
        this.power1 = 10;
        this.power2 = 10;
        this.timeTilInfect = 5;
        this.timeTilCured = 10;
        this.infectionRate = 10;
        this.activeRate = 10;
    }

    SimulationParameters(File plik){
        
    }
}