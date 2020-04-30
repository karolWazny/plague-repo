package map;

import java.util.List;
import virus.DiseaseRecord;

public interface IDiseaseSensitive {
    public void performIllness();
    public boolean getIsAlive();
    public void recover();
    public List<DiseaseRecord> getDiseases();
}