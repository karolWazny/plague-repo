package app;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * Klasa, która jest odpowiedzialna za przechowywanie informacji 
 * dotyczących wstępnego uruchomienia symulacji.
 * Ponadto posiada ona metodę wczytującą te dane z pliku.
 * @version 1.0
 */
public class SimulationParameters implements Serializable{
    /**
     * Informacja do interfejsu Serializable
     */
    private static final long serialVersionUID = -4042477513098162866L;
    /** Pole przechowujące długość mapy */
    int mapLength;
    /** Pole przechowujące szerokość mapy */
    int mapWidth;
    /** Pole przechowujące liczbę ludzi */
    int numPeople;
    /** Pole przechowujące liczbę lekarzy */
    int numDocs;
    /** Pole przechowujące liczbę karetek */
    int numAmbulance;
    /** Pole przechowujące liczbę karawanów */
    int numHearse;
    /** Pole przechowujące liczbę kości do losowania dla wirusa */
    int power1;
    /** Pole przechowujące liczbę ścian kości dla wirusa */
    int power2;
    /** Pole przechowujące czas potrzebny do zainfekowania */
    int timeTilInfect;
    /** Pole przechowujące czas potrzebny do wyzdrowienia */
    int timeTilCured;
    /** Pole przechowujące wskaźnik infekcji */
    int infectionRate;
    /** Pole przechowujące szansę na wystąpienie objawów */
    int activeRate;

    /**
     * Metoda, konstruktor, która tworzy obiekt z parametrami wejściowymi symulacji
     * @param mapLength długość mapy
     * @param mapWidth szerokość mapy
     * @param numPeople liczba ludzi
     * @param numDocs liczba lekarzy
     * @param numAmbulance liczba karetek
     * @param numHearse liczba karawanów
     * @param power1 liczba kości dla wirusa 
     * @param power2 liczba ścian na kości dla wirusa
     * @param timeTilInfect czas do zainfekowania
     * @param timeTilCured czas do wyzdrowienia
     * @param infectionRate wskaźnik infekcji
     * @param activeRate szansa na wystąpienie objawów
     */
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

    /**
     * Metoda, konstruktor, która domyślnie ustawia parametry symulacji
     */
    public SimulationParameters(){
        this(50, 50, 1200, 0, 5, 0, 6, 6, 1, 50, 50, 50);
    }

    /**
     * Metoda, konstruktor, która tworzy obiekt na wzór obiektu
     * w argumencie - obiekt tej samej klasy
     * @param params obiekt klasy SimulationParameters
     */
    public SimulationParameters(SimulationParameters params) {
        this.mapLength = params.mapLength;
        this.mapWidth = params.mapWidth;
        this.numPeople = params.numPeople;
        this.numDocs = params.numDocs;
        this.numAmbulance = params.numAmbulance;
        this.numHearse = params.numHearse;
        this.power1 = params.power1;
        this.power2 = params.power2;
        this.timeTilInfect = params.timeTilInfect;
        this.timeTilCured = params.timeTilCured;
        this.infectionRate = params.infectionRate;
        this.activeRate = params.activeRate;
    }

    /**
     * Metoda, która jest odpowiedzialna za wczytywania informacji dla 
     * obiektu tej klasy z pliku tekstowego 
     * Plik jest specjalnie sformatowany, wczytuje linijka po linijce jak tylko
     * napotka na ciąg znaków START i kończy, gdy napotka END
     * @param plik zmienna plikowa z parametrami
     * @throws FileNotFoundException Wyrzuca błąd w sytuacji nieznalezienia pliku
     */
    public void ReadFromFile(File plik) throws FileNotFoundException{

            Scanner in = new Scanner(plik);
            int index1 = 0;
            String line, name, number;

            while(in.hasNextLine()){
                line = in.nextLine();

                if(line.equals("START")){
                    
                    while(!line.equals("END")){
                        line = in.nextLine();
                        index1 = 0;
                        index1 = line.indexOf("=");
                    
                        if(index1 > 0){
                            name = line.substring(0, index1);
          
                            number = line.substring(index1+1);

                            if(name.equals("mapLength")){
                                this.mapLength = Integer.valueOf(number);
                            }
                            else if(name.equals("mapWidth")){
                                this.mapWidth = Integer.valueOf(number);
                            }
                            else if(name.equals("numPeople")){
                                this.numPeople = Integer.valueOf(number);
                            }
                            else if(name.equals("numDocs")){
                                this.numDocs = Integer.valueOf(number);
                            }
                            else if(name.equals("numAmbulance")){
                                this.numAmbulance = Integer.valueOf(number);
                            }
                            else if(name.equals("numHearse")){
                                this.numHearse = Integer.valueOf(number);
                            }
                            else if(name.equals("power1")){
                                this.power1 = Integer.valueOf(number);
                            }
                            else if(name.equals("power2")){
                                this.power2 = Integer.valueOf(number);
                            }
                            else if(name.equals("timeTilInfect")){
                                this.timeTilInfect = Integer.valueOf(number);
                            }
                            else if(name.equals("timeTilCured")){
                                this.timeTilCured = Integer.valueOf(number);
                            }
                            else if(name.equals("infectionRate")){
                                this.infectionRate = Integer.valueOf(number);
                            }
                            else if(name.equals("activeRate")){
                                this.activeRate = Integer.valueOf(number);
                            }
                        }
                    }
                }
            }
            in.close();
    }

    /**
     * Metoda, która zwraca ciąg znaków opisujący obiekt klasy parametrów symulacji
     * @return ciąg znaków o parametrach symulacji
     */
    public String toString() {
        String out = new String();
        out+="Simulation parameters:\nMap size:\n\twidth: "+mapWidth+", length: "+mapLength;
        out+="\nInitial number of people: "+numPeople+", including "+numDocs;
        out+=" doctors\nNumber of ambulances: "+numAmbulance;
        out += "\nVirus characteristics:\n\tPower: "+power1+"d"+power2;
        out += "\n\tNominal time between beeing infected and infecting others: "+timeTilInfect;
        out += "\n\tNominal time between being infected and being cured: "+timeTilCured;
        out += "\n\tInfection rate: "+infectionRate;
        out += "%\n\tPercentage of active instances of virus: "+activeRate+"%";
        return out;
    }

    /**
     * Metoda, getter, która zwraca długość mapy
     * @return długość mapy
     */
    public int getMapLength(){
        return mapLength;
    }

    /**
     * Metoda, getter, która zwraca szerokość mapy
     * @return szerokość mapy
     */
    public int getMapWidth(){
        return mapWidth;
    }

    /**
     * Metoda, getter, która zwraca liczbę ludzi
     * @return liczba ludzi
     */
    public int getNumPeople(){
        return numPeople;
    }

    /**
     * Metoda, getter, która zwraca liczbę lekarzy
     * @return liczba lekarzy
     */
    public int getNumDocs(){
        return numDocs;
    }

    /**
     * Metoda, getter, która zwraca liczbę karetek
     * @return liczba karetek
     */
    public int getNumAmbulance(){
        return numAmbulance;
    }

    /**
     * Metoda, getter, która zwraca liczbę kości dla wirusa
     * @return liczba kości dla wirusa
     */
    public int getPower1(){
        return power1;
    }

    /**
     * Metoda, getter, która zwraca liczbę ścian kości wirusa
     * @return liczba ścian kości wirusa
     */
    public int getPower2(){
        return power2;
    }

    /**
     * Metoda, getter, która zwraca czas do zainfekowania
     * @return czas potrzebny do zainfekowania
     */
    public int getTimeTilInfect(){
        return timeTilInfect;
    }

    /**
     * Metoda, getter, która zwraca czas do wyzdrowienia
     * @return czas do wyzdrowienia
     */
    public int getTimeTilCured(){
        return timeTilCured;
    }

    /**
     * Metoda, getter, która zwraca wskaźnik infekcji
     * @return wskaźnik infekcji
     */
    public int getInfectionRate(){
        return infectionRate;
    }

    /**
     * Metoda, getter, która zwraca szansę na wystąpienie objawów
     * @return szansa ba wystąpienie objawów
     */
    public int getActiveRate(){
        return activeRate;
    }

    /**
     * Metoda, setter, która ustawia wartość długości mapy
     * @param mapLength długość mapy
     */
    public void setMapLength(int mapLength){
        this.mapLength = mapLength;
    }

    /**
     * Metoda, setter, która ustawia wartość szerokości mapy
     * @param mapWidth szerokość mapy
     */
    public void setMapWidth(int mapWidth){
        this.mapWidth = mapWidth;
    }

    /**
     * Metoda, setter, która ustawia wartość liczby ludzi
     * @param numPeople liczba ludzi
     */
    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }

    /**
     * Metoda, setter, która ustawia wartość liczby lekarzy
     * @param numDocs liczba lekarzy
     */
    public void setNumDocs(int numDocs){
        this.numDocs = numDocs;
    }

    /**
     * Metoda, setter, która ustawia wartość liczby karetek
     * @param numAmbulance liczba karetek
     */
    public void setNumAmbulance(int numAmbulance){
        this.numAmbulance = numAmbulance;
    }

    /**
     * Metoda, setter, która ustawia wartość liczby kości dla wirusa
     * @param power1 liczba kości dla wirusa
     */
    public void setPower1(int power1){
        this.power1 = power1;
    }

    /**
     * Metoda, setter, która ustawia wartość liczby ścian kości wirusa
     * @param power2 liczba ścian kości dla wirusa
     */
    public void setPower2(int power2){
        this.power2 = power2;
    }

    /**
     * Metoda, setter, która ustawia wartość czasu do zainfekowania
     * @param timeTilInfect czas potrzebny do zainfekowania
     */
    public void setTimeTilInfect(int timeTilInfect){
        this.timeTilInfect = timeTilInfect;
    }

    /**
     * Metoda, setter, która ustawia wartość czasu do wyzdrowienia
     * @param timeTilCured czas potrzebny do wyzdrowienia
     */
    public void setTimeTilCured(int timeTilCured){
        this.timeTilCured = timeTilCured;
    }

    /**
     * Metoda, setter, która ustawia wartość wskaźnika infekcji
     * @param infectionRate wskaźnik infekcji
     */
    public void setInfectionRate(int infectionRate){
        this.infectionRate = infectionRate;
    }

    /**
     * Metoda, setter, która ustawia wartość szansy na wystąpienie objawów
     * @param activeRate szansa na wystąpienie objawów
     */
    public void setActiveRate(int activeRate){
        this.activeRate = activeRate;
    }
}