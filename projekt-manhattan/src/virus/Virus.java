package virus;

import random.Dice;
import map.Human;

public class Virus extends Disease {
    //pola

    //metody
    @Override
    public void progress(Human infected) {

    }

    @Override public void infect(Human human) {

    }
    //konstruktor
    public Virus(Human infected) {
        super(Dice.d100()>5, "korona");
    }
    // get/set
}