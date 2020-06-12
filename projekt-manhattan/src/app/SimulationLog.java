package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

/**
 * Klasa, ktora zbiera informacje o przebiegu symulacji.
 * W niej sa przechowywane wszystkie "rundy", ktore wykonuje symulacja.
 * @version 1.0
 * @see app.SimulationState
 * @see app.SimulationParameters
 */
public class SimulationLog {
    /**
     * Pole finalne, ktore przechowuje informacje o dacie startu symulacji.
     */
    public final Date startTime;
    /**
     * Pole przechowujace obiekt parametrow symulacji.
     */
    private SimulationParameters parameters;
    /**
     * Pole - lista przechowujaca wszystkie stany symulacji.
     */
    private List<SimulationState> log;
    /**
     * Pole przechowuja informacje czy All cured or all dead.
     */
    private String output;

    /**
     * Metoda, konstruktor, ktora tworzy obiekt klasy SimulationLog.
     * @param parameters parametry, ktore przyjmuje symulacja
     */
    public SimulationLog (SimulationParameters parameters) {
        startTime = new Date(System.currentTimeMillis());
        this.parameters = new SimulationParameters(parameters);
        log = new LinkedList<>();
    }

    /**
     * Metoda, konstuktor domyslny, ktora ustawia wszystkie pola na null.
     */
    public SimulationLog (){
        startTime = null;
        parameters = null;
        log = null;
        output = null;
    }

    /**
     * Metoda, ktora dodaje do naszej listy stanow nowy stan z przebiegu symulacji.
     * @param state stan po przejsciu rundy
     */
    public void addRecord(SimulationState state) {
        log.add(state);
    }

    /**
     * Metoda, ktora rowniez dodaje informacje o stanie, ale bardziej w sposob bezposredni,
     * nie przekazujemy obiektu SimulationState od razu.
     * @param alive liczba zywych
     * @param infected liczba zainfekowanych
     */
    public void addRecord(int alive, int infected) {
        log.add(new SimulationState(alive, infected));
    }

    /**
     * Metoda, ktora zwraca ciag znakowy opisujacy caly obiekt typu SimulationState.
     * A takze przedstawia jego cala zawartosc - przede wszystkim.
     * @return Ciag znakow z opisem calej symulacji
     */
    public String toString(){
        String output = new String();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        output += "Simulation run at: ";
        output += formatter.format(startTime) + '\n';
        output += parameters.toString()+'\n';
        output += "Simulation length: "+(log.size()==0?'\n':""+(log.size()-1)+" rounds\n");
        output += "Simulation output: " +(this.output==null?"Simulation not finished yet":this.output)+'\n';
        output+="Detailed log:\n";
        Iterator<SimulationState> iterator = log.iterator();
        while(iterator.hasNext()) {
            output += iterator.next().toString()+'\n';
        }
        return output;
    }

    /**
     * Metoda, setter, ktora ustawia pole output na all cured lub all dead.
     * @param output Ciag znakow z informacja
     * @return stan logiczny, czy zmieniono status
     */
    public boolean setOutput (String output) {
        if(output == "All dead" || output == "All cured") {
            this.output = new String(output);
            return true;
        }
        return false;
    }

    /**
     * Metoda, getter, ktora zwraca ostatni stan pojedynczej rundy symulacji.
     * @return obiekt SimulationState - ostatni z listy
     */
    public SimulationState getLast(){
        return log.get(log.size()-1);
    }

    /**
     * Metoda, getter, ktora zwraca liste stanow symulacji.
     * @return lista stanow symulacji
     */
    public List<SimulationState> getList(){
        return this.log;
    }

    /**
     * Metoda, getter, ktora zwraca czas startu symulacji.
     * @return czas poczatku symulacji
     */
    public Date getStartTime(){
        return startTime;
    }
}