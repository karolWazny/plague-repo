package virus;

import map.Human;

public interface IDisease {
    public void infect(Human human);
    public void progress(Human infected);
    public boolean getIsActive();
}