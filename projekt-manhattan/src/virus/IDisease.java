package virus;

import human.IDiseaseSensitive;

public interface IDisease {
    public void infect(IDiseaseSensitive human);
    public void progress(IDiseaseSensitive infected, DiseaseRecord record);
    public int getInfectionRate();
    public int getActiveRate();
    public int getTimeTilSymptoms();
}