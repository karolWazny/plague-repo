package map;

import random.Dice;

public class Man extends Being implements IMovable, IDiseaseSensitive {
    public Man(int sex, int age)
    {
        super("Citizen "+ manCounter, ((sex==1)?'k':'m'));
        this.sex = sex;
        this.age = age;
        isInfected = false;
        manCounter++;
    }

    public Man()
    {
        super("Citizen "+ manCounter, ((Dice.d2()==1)?'m':'k'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
        isInfected = false;
        manCounter++;
    }

    protected Man(int sex, int age, char representation) //doctors only!
    {
        super("Citizen "+ manCounter, 'd');
        this.sex = sex;
        this.age = age;
        isInfected = false;
        manCounter++;
    }

    @Override
    public Coordinates move(Coordinates currentCoordinates) {
        Coordinates newPosition = new Coordinates(currentCoordinates);
        switch(Dice.d4())
        {
            case 1: newPosition.setVertical(newPosition.getVertical()+1);
                break;
            case 2: newPosition.setVertical(newPosition.getVertical()-1);
                break;
            case 3: newPosition.setHorizontal(newPosition.getHorizontal()+1);
                break;
            case 4: newPosition.setHorizontal(newPosition.getHorizontal()-1);
                break;
        }
        return newPosition;
    }

    @Override
    public void performIllness() {
        
    }

    private int healthPoints;
    private boolean isInfected;
    private final int sex;
    private int age;
    private static int manCounter = 1;

    public String getSex()
    {
        return (sex==2)? "male":"female"; 
    }

    public int getSexValue()
    {
        return sex;
    }

    public int getHealthPoints()
    {
        return healthPoints;
    }

    public boolean getIsInfected()
    {
        return isInfected;
    }

    public int getAge()
    {
        return age;
    }
}