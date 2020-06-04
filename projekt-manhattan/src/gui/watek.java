package gui;

import app.Simulation;

public static class watek extends Thread{
    private Simulation sim;
    private SimulationRuntimeWindow srw;
    public boolean start=false;
    public watek(Simulation simulation, SimulationRuntimeWindow srw){
        super();
        sim=simulation;
        this.srw = srw;
    }
    public void run(){

        //srw.finish(sim.getLog().toString());
        if(!start){
            srw = new SimulationRuntimeWindow(sim);
        } else {
            srw.nextRound(sim.getLog().getLast().toString());
        }
    }

}