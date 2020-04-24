package map;

import random.Dice;

public class Human extends Being implements IMovable, IDiseaseSensitive {
    public Human(int sex, int age)
    {
        super("Citizen "+ humanCounter, ((sex==1)?'k':'m'));
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
        humanCounter++;
    }

    public Human()
    {
        super("Citizen "+ humanCounter, ((Dice.d2()==1)?'k':'m'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
        isInfected = false;
        isAlive = true;
        humanCounter++;
    }

    protected Human(int sex, int age, char representation) //doctors only!
    {
        super("Citizen "+ humanCounter, 'd');
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
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
        
    }

    private int healthPoints;
    private boolean isInfected;
    private boolean isAlive;
    private final int sex; //1==female, 2 == male
    private int age;
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

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public int getAge()
    {
        return age;
    }
}