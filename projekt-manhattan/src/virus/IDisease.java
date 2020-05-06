package virus;

import map.Human;

public interface IDisease {
    public void infect(Human human);
    public void progress(Human infected, DiseaseRecord record);
    public int getInfectionRate();
    public int getActiveRate();
    public int getTimeTilSymptoms();
}