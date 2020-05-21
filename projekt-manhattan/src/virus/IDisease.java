package virus;

import human.IDiseaseSensitive;

public interface IDisease {
    public int infect(IDiseaseSensitive human);
    public int progress(IDiseaseSensitive infected, DiseaseRecord record);
    public int getInfectionRate();
    public int getActiveRate();
    public int getTimeTilSymptoms();
}