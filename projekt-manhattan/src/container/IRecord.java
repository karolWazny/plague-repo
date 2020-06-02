package container;

import map.Map;
import map.Being;

public interface IRecord {
    public void move();
    public Coordinates getVerHor();
    public void setVerHor(Coordinates currentVerHor);
    public int infectNeighbours(Map map);
    public int[] progressIllness();
    public void performRecovery();
    public Being getBeing();
}