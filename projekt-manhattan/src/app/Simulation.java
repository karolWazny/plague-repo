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
 * Klasa glowna calej symulacji - w tym miejscu spinane jest wszystko w jedna spojna calosć
 * W tym miejscu tworzone sa obiekty wszystkich glownych klas
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
    /** Pole, w ktorym znajduje sie mapa */
    private Map map;
    /** Pole dla kontenera bytow */
    private BeingContainer container;
    /** Pole, w ktorym przechowywana jest postać wirusa */
    private Virus strain;
    /** Pole, w ktorym zapisana jest liczb ludzi */
    private int numPeople;
    /** Pole, w ktorym zapisana jest liczba zainfekowanych */
    private int numInfected;
    /** Pole, w ktorym przechowywane sa parametry poczatkowe symulacji */
    private SimulationParameters params;
    /** Pole, w ktorym przechowywane sa informacje o przebiegu calej symulacji */
    SimulationLog log;
    /** Pole, w ktorym przechowujemy okno przebiegu symulacji */
    SimulationRuntimeWindow srw;
    /** Pole, w ktorym jest obiekt zarzadzajacy pojazdami */
    private Dispatching dispatching;

    /**
     * Metoda, konstruktor, ktory tworzy obiekt klasy symulacji
     * @param parameters parametry wstepne symulacji
     * @throws IncorrectParametersException Wyrzuca wyjatek jak sa nieprawidlowe parametry
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
     * Metoda wykonujaca runde calej symulacji
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
     * Metoda, przeprowadza symulacje, wyswietla jej przebieg w okienku, tworzy obiekt SimulationLog,
     * w ktorym zapisuje przebieg symulacji.
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
                
                TimeUnit.MILLISECONDS.sleep(250); //ustawienie zmiany szybkosci
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
     * Metoda, ktora wyswietla mape w konsoli
     */
    public void display() {
        map.displayMap();
    }

    /**
     * Metoda, getter, ktora zwraca obiekt typu mapa
     * @return obiekt mapy
     */
    public Map getMap(){
        return map;
    }

    /**
     * Metoda, getter, ktora zwraca obiekt z zapisem przebiegu
     * @return obiekt z zapisem przebiegu
     */
    public SimulationLog getLog(){
        return log;
    }
}