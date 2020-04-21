package map;

import java.util.List;
import java.util.ArrayList;

public class BeingContainer {
    private List<IMapable> list;
    
    public BeingContainer()
    {
        list = new ArrayList<IMapable>();
    }
    
    public List<IMapable> getList()
    {
        return list;
    }

    public void performMovementRound()
    {
        for(IMapable obj:list)
        {
            obj.move();
        }
    }
}