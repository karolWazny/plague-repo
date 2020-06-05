package app;

import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

import gui.frames.SimulationRuntimeWindow;
import map.Map;
import container.*;
import random.Dice;
import human.Human;
import human.Doctor;
import virus.DiseaseRecord;
import virus.Virus;
import services.buildings.Hospital;
import services.dispatching.Dispatching;
import services.vehicles.Ambulance;
import services.vehicles.GPS1;


/**
 * Klasa główna całej symulacji - w tym miejscu spinane jest wszystko w jedną spójną całość
 * W tym miejscu tworzone są obiekty wszystkich głównych klas
 * @version 1.0
 * @see map.Map;
 * @see container.*;
 * @see random.Dice;
 * @see human.Human;
 * @see human.Doctor;
 * @see virus.DiseaseRecord;
 * @see virus.Virus;
 * @see services.buildings.Hospital;
 * @see services.dispatching.Dispatching;
 * @see services.vehicles.Ambulance;
 * @see services.vehicles.GPS1;
 */
public class Simulation {
    /** Pole, w którym znajduje się mapa */
    private Map map;
    /** Pole dla kontenera bytów */
    private BeingContainer container;
    /** Pole, w którym przechowywana jest postać wirusa */
    private Virus strain;
    /** Pole, w którym zapisana jest liczb ludzi */
    private int numPeople;
    /** Pole, w którym zapisana jest liczba zainfekowanych */
    private int numInfected;
    /** Pole, w którym przechowywane są parametry początkowe symulacji */
    private SimulationParameters params;
    /** Pole, w którym przechowywane są informacje o przebiegu całej symulacji */
    SimulationLog log;
    /** Pole, w którym przechowujemy okno przebiegu symulacji */
    SimulationRuntimeWindow srw;
    /** Pole, w którym jest obiekt zarządzający pojazdami */
    private Dispatching dispatching;

    /**
     * Metoda, konstruktor, który tworzy obiekt klasy symulacji
     * @param parameters parametry wstępne symulacji
     * @throws IncorrectParametersException Wyrzuca wyjątek jak są nieprawidłowe parametry
     */
    public Simulation(SimulationParameters parameters) throws IncorrectParametersException{
        params = parameters;
        numPeople = parameters.numPeople;
        numInfected = 1;
        map = new Map(parameters.mapLength, parameters.mapWidth);

        dispatching = new Dispatching();

        container = new BeingContainer(map, dispatching);
        strain = new Virus(parameters.power1, parameters.power2, parameters.timeTilInfect, parameters.timeTilCured, parameters.infectionRate, parameters.activeRate);
        List<Coordinates> list = map.emptyFieldsList();
        
        int listLength = list.size();

        if((parameters.numPeople + parameters.numDocs + parameters.numAmbulance + parameters.numHearse + 8)>listLength)
        {
            throw new IncorrectParametersException();
        }

        
        int roll = Dice.custom(listLength)-1;

        Hospital hospital = new Hospital(map);
        Coordinates hospCoords = new Coordinates(list.get(roll));

        list.remove(roll);

        listLength-=1;

        container.addRecord(hospital, hospCoords);

        Ambulance ambulance;

        for(int i = 0; i<parameters.numAmbulance; i++){
            roll = Dice.custom(listLength) - 1;
            ambulance = new Ambulance(hospCoords, new GPS1(map), hospital);
            container.addRecord(ambulance, list.get(roll));
            dispatching.addAmbulance(ambulance);
            listLength--;
        }

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
        return;
    }

    /**
     * Metoda wykonująca rundę całej symulacji
     */
    public void performRound() {
        int [] buffer;
        container.performMovementRound();
        numInfected += container.performInfectRound();
        buffer = container.performDiseaseRound();
        numInfected -= buffer[0];
        numInfected -= buffer[1];
        numPeople -= buffer[0];
        container.performRecoveryRound();
    }

    /**
     * Metoda, tworzy obiekt przechowujący wszystkie info o przebiegu symulacji 
     * @return obiekt typu SimulationLog
     */
    public SimulationLog doSimulation() {
        log = new SimulationLog(params);
        Simulation sim = this;

        SwingUtilities.invokeLater(new Runnable(){
            //@Override
            public void run(){
                srw = new SimulationRuntimeWindow(sim);
            }
        });
        
        boolean whetherToContinue = true;
        while(whetherToContinue) {
            try{
                
                TimeUnit.MILLISECONDS.sleep(250); //ustawienie zmiany szybkości
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            performRound();
            log.addRecord(numPeople, numInfected);
                if(numPeople == 0) {
                    log.setOutput("All dead");
                    whetherToContinue = false;
                }

                if(numInfected == 0) {
                    log.setOutput("All cured");
                    whetherToContinue = false;
                }

                SwingUtilities.invokeLater(new Runnable(){
                    //@Override
                    public void run(){
                        srw.nextRound(log.getLast().toString());
                    }
                });

            }
        SwingUtilities.invokeLater(new Runnable(){
            //@Override
            public void run(){
            srw.finish(log.toString());
            }
        });
        return log;
    }

    /**
     * Metoda, która wyświetla mapę w konsoli
     */
    public void display() {
        map.displayMap();
    }

    /**
     * Metoda, getter, która zwraca obiekt typu mapa
     * @return obiekt mapy
     */
    public Map getMap(){
        return map;
    }

    /**
     * Metoda, getter, która zwraca obiekt z zapisem przebiegu
     * @return obiekt z zapisem przebiegu
     */
    public SimulationLog getLog(){
        return log;
    }
}