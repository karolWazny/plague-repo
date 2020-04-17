package person;



public class Person {

    //enum age{
      //  KID, YOUNG, MIDAGED,ELDERLY;
     //}
    private final int age;
    private final boolean gender;
    private final int health;
    private final boolean infection;

    public Person(int age, boolean gender, int health, boolean infection){
        this.age = age;
        this.gender = gender;
        this.health = health;
        this.infection = infection;
    }

    public int getAge(){
        return age;
    }

    public boolean getGender(){
        return gender;
    }

    public int getHealth(){
        return health;
    }

    public boolean getInfection(){
        return infection;
    }