package map;

import java.util.List;
import java.util.ArrayList;

public class BeingContainer {
    private List<IMapable> list;
    
    private Map map;

    public BeingContainer(Map map)
    {
        list = new ArrayList<IMapable>();
        this.map = map;
    }
    
    public List<IMapable> getList()
    {
        return list;
    }

    public Map getMap()
    {
        return map;
    }

    public void performMovementRound()
    {
        Coordinates currentVerHor;
        Coordinates newVerHor;
        for(IMapable obj:list)
        {
            currentVerHor = obj.getVerHor();
            obj.move();
            newVerHor = obj.getVerHor();
            if(map.getField(newVerHor).getId()!="empty")
            {
                obj.setVerHor(currentVerHor);
            }
        }
    }
}