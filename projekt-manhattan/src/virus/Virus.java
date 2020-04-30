package virus;

import random.Dice;
import map.Human;

public class Virus extends Disease {
    //pola

    //metody
    @Override
    public void progress(Human infected) {

    }

    @Override
    public void infect(Human human) {
        infector.performInfection(human, this);
        human.setIsInfected(true);
    }
    //konstruktor
    public Virus(Human infected) {
        super(Dice.d100()>5, "korona", 5, 50, 25);
    }
    // get/set
}