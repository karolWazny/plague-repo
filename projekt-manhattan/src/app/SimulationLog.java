package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.util.Iterator;
import java.text.SimpleDateFormat;

/**
 * Klasa, która zbiera informacje o przebiegu symulacji
 * W niej są przechowywane wszystkie "rundy", które wykonuje symulacja
 * @version 1.0
 * @see app.SimulationState
 * @see app.SimulationParameters
 */
public class SimulationLog {
    /**
     * Pole finalne, które przechowuje informację o dacie startu symulacji
     */
    public final Date startTime;
    /**
     * Pole przechowujące obiekt parametrów symulacji
     */
    private SimulationParameters parameters;
    /**
     * Pole - lista przechowująca wszystkie stany symulacji
     */
    private List<SimulationState> log;
    /**
     * Pole przechowują informację czy All cured or all dead
     */
    private String output;

    /**
     * Metoda, konstruktor, która tworzy obiekt klasy SimulationLog
     * @param parameters parametry, które przyjmuje symulacja
     */
    public SimulationLog (SimulationParameters parameters) {
        startTime = new Date(System.currentTimeMillis());
        this.parameters = new SimulationParameters(parameters);
        log = new LinkedList<>();
    }

    /**
     * Metoda, konstuktor domyślny, która ustawia wszystkie pola na null
     */
    public SimulationLog (){
        startTime = null;
        parameters = null;
        log = null;
        output = null;
    }

    /**
     * Metoda, która dodaje do naszej listy stanów nowy stan z przebiegu symulacji
     * @param state stan po przejściu rundy
     */
    public void addRecord(SimulationState state) {
        log.add(state);
    }

    /**
     * Metoda, która również dodaje informację o stanie, ale bardziej w sposób bezpośredni
     * nie przekazujemy obiektu SimulationState od razu
     * @param alive liczba żywych
     * @param infected liczba zainfekowanych
     */
    public void addRecord(int alive, int infected) {
        log.add(new SimulationState(alive, infected));
    }

    /**
     * Metoda, która zwraca ciąg znakowy opisujący cały obiekt typu SimulationState
     * A także przedstawia jego całą zawartość - przede wszystkim.
     * @return Ciąg znaków z opisem całej symulacji
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
     * Metoda, setter, która ustawia pole output na all cured lub all dead
     * @param output Ciąg znaków z informacją
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
     * Metoda, getter, która zwraca ostatni stan pojedynczej rundy symulacji
     * @return obiekt SimulationState - ostatni z listy
     */
    public SimulationState getLast(){
        return log.get(log.size()-1);
    }

    /**
     * Metoda, getter, która zwraca listę stanów symulacji
     * @return lista stanów symulacji
     */
    public List<SimulationState> getList(){
        return this.log;
    }

    /**
     * Metoda, getter, która zwraca czas startu symulacji
     * @return czas początku symulacji
     */
    public Date getStartTime(){
        return startTime;
    }
}