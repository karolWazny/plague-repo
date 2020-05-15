package container;

import virus.DiseaseRecord;
import map.Being;
import human.IDiseaseSensitive;
import map.Map;

public abstract class  Record implements IRecord {
    private Being being;
    private Coordinates position;

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
        if(being instanceof IMovable){
            IMovable being = (IMovable) this.being;
            position = being.move(position);
        }
    }

    @Override
    public void infectNeighbours(Map map){
        if(!(being instanceof IDiseaseSensitive)) {
            return;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return; //trupy nie zarażają (chyba, że jednak, i trzeba je sprzątać...)
        }
        Being neighbour;
        for(DiseaseRecord disease:((IDiseaseSensitive)being).getDiseases()) {
            for(int i = 0; i<8; i++) {
                neighbour = (Being)map.getField(position.neighboursClockwise(i));
                if(neighbour instanceof IDiseaseSensitive) {
                    disease.infect((IDiseaseSensitive)neighbour);
                }
            }
        }
    }

    @Override
    public void progressIllness(){
        if(!(being instanceof IDiseaseSensitive)) {
            return;
        }
        if(!((IDiseaseSensitive)being).getIsAlive()) {
            return; //trupy nie chorują
        }
        ((IDiseaseSensitive)being).performIllness();
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
        position = newVerHor;
    }

    ////////////////////////////

    @Override
    public Coordinates getVerHor(){
        return position;
    }

    public Being getBeing(){
        return being;
    }
}