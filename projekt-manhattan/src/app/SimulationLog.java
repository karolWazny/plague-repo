package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class SimulationLog {
    public final Date startTime;
    private SimulationParameters parameters;
    private List<SimulationState> log;
    private String output;

    //////////////////////////////

    public SimulationLog (SimulationParameters parameters) {
        startTime = new Date(System.currentTimeMillis());
        this.parameters = new SimulationParameters(parameters);
        log = new LinkedList<>();
    }
    
    ///////////////////////////////

    public void addRecord(SimulationState state) {
        log.add(state);
    }

    public void addRecord(int alive, int infected) {
        log.add(new SimulationState(alive, infected));
    }

    @Override
    public String toString(){
        if(this.output == null) {
            return "Simulation not finished yet";
        }
        String output = new String();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        output += "Simulation run at: ";
        output += formatter.format(startTime) + '\n';
        output += parameters.toString()+'\n';
        output += "Simulation length: "+(log.size()-1)+" rounds";
        output += "Simulation output: " +this.output+'\n';
        output+="Details of the run:\n";
        for(SimulationState state:log) {
            output += "Alive: "+state.getNumPeople()+", infected: "+state.getNumInfected()+'\n';
        }
        return output;
    }

    //////////////////////////////
    public boolean setOutput (String output) {
        if(output == "All dead" || output == "All cured") {
            this.output = new String(output);
            return true;
        }
        return false;
    }
}