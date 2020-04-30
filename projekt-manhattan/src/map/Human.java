package map;

import random.Dice;
import virus.DiseaseRecord;
import java.util.ArrayList;
import java.util.List;

public class Human extends Being implements IMovable, IDiseaseSensitive {
    public Human(int sex, int age)
    {
        super("Citizen "+ humanCounter, ((sex==1)?'k':'m'));
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }

    public Human()
    {
        super("Citizen "+ humanCounter, ((Dice.d2()==1)?'k':'m'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }

    protected Human(int sex, int age, char representation) //doctors only!
    {
        super("Citizen "+ humanCounter, 'd');
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }

    @Override
    public Coordinates move() {
        Coordinates newPosition = new Coordinates(0,0);
        switch(Dice.d4())
        {
            case 1: newPosition.setVertical(1);
                break;
            case 2: newPosition.setVertical(-1);
                break;
            case 3: newPosition.setHorizontal(1);
                break;
            case 4: newPosition.setHorizontal(-1);
                break;
        }
        return newPosition;
    }

    @Override
    public void performIllness() {
        for(DiseaseRecord illness:diseases) {
            illness.progress(this);
        }
    }

    @Override
    public void recover() {
        healthPoints+=10-(age/10)+Dice.d6(2);
        if(healthPoints>100)
            healthPoints = 100;
    }

    private int healthPoints;
    private boolean isInfected;
    private boolean isAlive;
    private final int sex; //1==female, 2 == male
    private int age;
    private List<DiseaseRecord> diseases; 
    private static int humanCounter = 1;
    

    public String getSex()
    {
        return (sex==2)? "male":"female"; 
    }

    public int getHealthPoints()
    {
        return healthPoints;
    }

    public boolean getIsInfected()
    {
        return isInfected;
    }

    public void setIsInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public List<DiseaseRecord> getDiseases() {
        return diseases;
    }
}