package container;

import map.Map;
import map.Being;

public interface IRecord {
    public void move();
    public Coordinates getVerHor();
    public void setVerHor(Coordinates currentVerHor);
    public void infectNeighbours(Map map);
    public void progressIllness();
    public void performRecovery();
    public Being getBeing();
}