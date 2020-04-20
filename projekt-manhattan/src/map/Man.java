package map;

import random.Dice;

public class Man extends Being implements IMovable, IDiseaseSensitive {
    public Man(String id, int sex, int age)
    {
        super(id, 'm');
        this.sex = sex;
        this.age = age;
        isInfected = false;
    }

    public Man(String id)
    {
        super(id, ((Dice.d2()==1)?'m':'k'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
    }

    public Man()
    {
        super("Citizen X", ((Dice.d2()==1)?'m':'k'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
    }

    @Override
    public void move() {

    }
    @Override
    public void performIllness() {
        
    }

    private int healthPoints;
    private boolean isInfected;
    private final int sex;
    private int age;

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