package app;

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
}