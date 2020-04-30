package map;

import virus.DiseaseRecord;

public abstract class  Record implements IMapable {
    private Being being;
    private Coordinates position;

    public Record(Being being, Coordinates position) 
    {
        this.being = being;
        this.position = new Coordinates(position);
    }

    public Being getBeing()
    {
        return being;
    }

    @Override
    public void move()
    {
        if(being instanceof IDiseaseSensitive) {
            if(((IDiseaseSensitive)being).getIsAlive()==false)
            return; //trupy nie chodzą
        }
        if(being instanceof IMovable){
            IMovable being = (IMovable) this.being;
            position.addVector(being.move());
        }
    }

    public void infectNeighbours(Map map) {
        if(!(being instanceof IDiseaseSensitive)) {
            return;
        }
        Being neighbour;
        for(DiseaseRecord disease:((IDiseaseSensitive)being).getDiseases()) {
            for(int i = 0; i<8; i++) {
                neighbour = (Being)map.getField(position.neighboursClockwise(i));
                if(neighbour instanceof IDiseaseSensitive) {
                    disease.infect((Human)neighbour);
                }
            }
        }
    }

    @Override
    public Coordinates getVerHor()
    {
        return position;
    }

    @Override
    public void setVerHor(Coordinates newVerHor)
    {
        position = newVerHor;
    }
}