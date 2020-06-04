package human;

import java.util.List;
import virus.DiseaseRecord;

public interface IDiseaseSensitive extends IRecoverable {
    public int performIllness();

    /////////////////////////////////

    public boolean getIsAlive();
    public boolean getIsInfected();
    public int getHealthPoints();
    public List<DiseaseRecord> getDiseases();

    //////////////////////////////////////////

    public void setIsInfected(boolean isInfected);
    public void setHealthPoints(int healthPoints);
    public void setIsAlive(boolean isAlive);
}