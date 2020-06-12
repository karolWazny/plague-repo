package app;

import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

/**
 * Klasa, ktora jest odpowiedzialna za przechowywanie informacji 
 * dotyczacych wstepnego uruchomienia symulacji.
 * Ponadto posiada ona metode wczytujaca te dane z pliku.
 * @version 1.0
 */
public class SimulationParameters implements Serializable{
    /**
     * Informacja do interfejsu Serializable
     */
    private static final long serialVersionUID = -4042477513098162866L;
    /** Pole przechowujace dlugosć mapy */
    int mapLength;
    /** Pole przechowujace szerokosć mapy */
    int mapWidth;
    /** Pole przechowujace liczbe ludzi */
    int numPeople;
    /** Pole przechowujace liczbe lekarzy */
    int numDocs;
    /** Pole przechowujace liczbe karetek */
    int numAmbulance;
    /** Pole przechowujace liczbe karawanow */
    int numHearse;
    /** Pole przechowujace liczbe kosci do losowania dla wirusa */
    int power1;
    /** Pole przechowujace liczbe scian kosci dla wirusa */
    int power2;
    /** Pole przechowujace czas potrzebny do zainfekowania */
    int timeTilInfect;
    /** Pole przechowujace czas potrzebny do wyzdrowienia */
    int timeTilCured;
    /** Pole przechowujace wskaznik infekcji */
    int infectionRate;
    /** Pole przechowujace szanse na wystapienie objawow */
    int activeRate;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt z parametrami wejsciowymi symulacji
     * @param mapLength dlugosć mapy
     * @param mapWidth szerokosć mapy
     * @param numPeople liczba ludzi
     * @param numDocs liczba lekarzy
     * @param numAmbulance liczba karetek
     * @param numHearse liczba karawanow
     * @param power1 liczba kosci dla wirusa 
     * @param power2 liczba scian na kosci dla wirusa
     * @param timeTilInfect czas do zainfekowania
     * @param timeTilCured czas do wyzdrowienia
     * @param infectionRate wskaznik infekcji
     * @param activeRate szansa na wystapienie objawow
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
     * Metoda, konstruktor, ktora domyslnie ustawia parametry symulacji
     */
    public SimulationParameters(){
        this(50, 50, 1200, 0, 5, 0, 6, 6, 1, 50, 50, 50);
    }

    /**
     * Metoda, konstruktor, ktora tworzy obiekt na wzor obiektu
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
     * Metoda, ktora jest odpowiedzialna za wczytywania informacji dla 
     * obiektu tej klasy z pliku tekstowego 
     * Plik jest specjalnie sformatowany, wczytuje linijka po linijce jak tylko
     * napotka na ciag znakow START i kończy, gdy napotka END
     * @param plik zmienna plikowa z parametrami
     * @throws FileNotFoundException Wyrzuca blad w sytuacji nieznalezienia pliku
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
     * Metoda, ktora zwraca ciag znakow opisujacy obiekt klasy parametrow symulacji
     * @return ciag znakow o parametrach symulacji
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
     * Metoda, getter, ktora zwraca dlugosć mapy
     * @return dlugosć mapy
     */
    public int getMapLength(){
        return mapLength;
    }

    /**
     * Metoda, getter, ktora zwraca szerokosć mapy
     * @return szerokosć mapy
     */
    public int getMapWidth(){
        return mapWidth;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe ludzi
     * @return liczba ludzi
     */
    public int getNumPeople(){
        return numPeople;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe lekarzy
     * @return liczba lekarzy
     */
    public int getNumDocs(){
        return numDocs;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe karetek
     * @return liczba karetek
     */
    public int getNumAmbulance(){
        return numAmbulance;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe kosci dla wirusa
     * @return liczba kosci dla wirusa
     */
    public int getPower1(){
        return power1;
    }

    /**
     * Metoda, getter, ktora zwraca liczbe scian kosci wirusa
     * @return liczba scian kosci wirusa
     */
    public int getPower2(){
        return power2;
    }

    /**
     * Metoda, getter, ktora zwraca czas do zainfekowania
     * @return czas potrzebny do zainfekowania
     */
    public int getTimeTilInfect(){
        return timeTilInfect;
    }

    /**
     * Metoda, getter, ktora zwraca czas do wyzdrowienia
     * @return czas do wyzdrowienia
     */
    public int getTimeTilCured(){
        return timeTilCured;
    }

    /**
     * Metoda, getter, ktora zwraca wskaznik infekcji
     * @return wskaznik infekcji
     */
    public int getInfectionRate(){
        return infectionRate;
    }

    /**
     * Metoda, getter, ktora zwraca szanse na wystapienie objawow
     * @return szansa ba wystapienie objawow
     */
    public int getActiveRate(){
        return activeRate;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć dlugosci mapy
     * @param mapLength dlugosć mapy
     */
    public void setMapLength(int mapLength){
        this.mapLength = mapLength;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć szerokosci mapy
     * @param mapWidth szerokosć mapy
     */
    public void setMapWidth(int mapWidth){
        this.mapWidth = mapWidth;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć liczby ludzi
     * @param numPeople liczba ludzi
     */
    public void setNumPeople(int numPeople){
        this.numPeople = numPeople;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć liczby lekarzy
     * @param numDocs liczba lekarzy
     */
    public void setNumDocs(int numDocs){
        this.numDocs = numDocs;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć liczby karetek
     * @param numAmbulance liczba karetek
     */
    public void setNumAmbulance(int numAmbulance){
        this.numAmbulance = numAmbulance;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć liczby kosci dla wirusa
     * @param power1 liczba kosci dla wirusa
     */
    public void setPower1(int power1){
        this.power1 = power1;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć liczby scian kosci wirusa
     * @param power2 liczba scian kosci dla wirusa
     */
    public void setPower2(int power2){
        this.power2 = power2;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć czasu do zainfekowania
     * @param timeTilInfect czas potrzebny do zainfekowania
     */
    public void setTimeTilInfect(int timeTilInfect){
        this.timeTilInfect = timeTilInfect;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć czasu do wyzdrowienia
     * @param timeTilCured czas potrzebny do wyzdrowienia
     */
    public void setTimeTilCured(int timeTilCured){
        this.timeTilCured = timeTilCured;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć wskaznika infekcji
     * @param infectionRate wskaznik infekcji
     */
    public void setInfectionRate(int infectionRate){
        this.infectionRate = infectionRate;
    }

    /**
     * Metoda, setter, ktora ustawia wartosć szansy na wystapienie objawow
     * @param activeRate szansa na wystapienie objawow
     */
    public void setActiveRate(int activeRate){
        this.activeRate = activeRate;
    }
}