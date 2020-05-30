package container;

import virus.DiseaseRecord;
import map.Being;
import human.IDiseaseSensitive;
import map.Map;
import services.dispatching.Dispatching;

public class  Record implements IRecord {
    private Being being;
    private Coordinates position;
    private Dispatching dispatching;

    ////////////////////////////

    public Record(Being being, Coordinates position){
        this.being = being;
        this.position = new Coordinates(position);
    }

    ////////////////////////////

    @Override
    public void move(){
        if(being instanceof IDiseaseSensitive) {
            if(!((IDiseaseSensitive)being).getIsAlive())
            return; //trupy nie chodzą
        }
        if( being instanceof IDiseaseSensitive) {
            if(((IDiseaseSensitive)being).getHealthPoints() < 50)
            //dispatching.addPatient(being);
            return;
        }

        if(being instanceof IMovable){
            IMovable being = (IMovable) this.being;
            position = being.move(position);
        }
    }

    @Override
    public int infectNeighbours(Map map){        
        if(!(being instanceof IDiseaseSensitive)) {
            return 0;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return 0; //trupy nie zarażają (chyba, że jednak, i trzeba je sprzątać...)
        }
        Being neighbour;
        int newInfected = 0;
        for(DiseaseRecord disease:((IDiseaseSensitive)being).getDiseases()) {
            for(int i = 0; i<8; i++) {
                neighbour = (Being)map.getField(position.neighboursClockwise(i));
                if(neighbour instanceof IDiseaseSensitive) {
                   newInfected += disease.infect((IDiseaseSensitive)neighbour);
                }
            }
        }
        return newInfected;
    }

    @Override
    public int progressIllness(){
        if(!(being instanceof IDiseaseSensitive)) {
            return 0;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return 0; //trupy nie chorują
        }
        int output = 0;
        output = ((IDiseaseSensitive)being).performIllness();
        return output;
    }

    @Override
    public void performRecovery(){
        if(!(being instanceof IDiseaseSensitive)) {
            return;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return; //trupy nie zdrowieją
        }
        ((IDiseaseSensitive)being).recover();
    }

    ////////////////////////////

    @Override
    public void setVerHor(Coordinates newVerHor){
        position = new Coordinates(newVerHor);
    }

    ////////////////////////////

    @Override
    public Coordinates getVerHor(){
        return position;
    }

    @Override
    public Being getBeing(){
        return being;
    }
}