package human;

import java.util.ArrayList;
import java.util.List;
import random.Dice;
import virus.DiseaseRecord;
import map.Being;
import container.IMovable;
import container.Coordinates;

/**
 * Klasa, ktora posiada wszelkie informacje i funkcjonalnosci, by abstrakcyjnie
 * przedstawic czlowieka
 * @version 1.0
 * @see random.Dice 
 * @see virus.DiseaseRecord
 * @see map.Being
 * @see container.IMovable
 * @see container.Coordinates
 */
public class Human extends Being implements IMovable, IDiseaseSensitive {
    /** Pole z iloscia punktow zycia */
    private int healthPoints;
    /** Pole z informacja czy jest zarazony */
    private boolean isInfected;
    /** Pole z informacja czy jest zywy */
    private boolean isAlive;
    /** Pole z informacja o plci 1==female, 2 == male */
    private final int sex;
    /** Pole z informacja o wieku */
    private int age;
    /** Pole z lista chorob czlowieka */
    private List<DiseaseRecord> diseases; 
    /** Statyczne pole z liczba ludzi */
    private static int humanCounter = 1;
    
    /**
     * Metoda, konstruktor klasy czlowieka, ktora jako parametry przyjmuje plec i wiek
     * @param sex informacja o plci
     * @param age wiek
     */
    public Human(int sex, int age){
        super("Citizen "+ humanCounter, ((sex==1)?'k':'m'));
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }
    
    /**
     * Metoda, konstruktor domyslny czlowieka, plec i inne 
     * parametry sa przydzielane losowo badz odgornie
     */
    public Human(){
        super("Citizen "+ humanCounter, ((Dice.d2()==1)?'k':'m'));
        sex = ((super.representation=='k')?1:2);
        age = Dice.d4(20);
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }

    /**
     * Metoda, konstruktor, ktory zostal stworzony na potrzeby dziedziczenia dla doktora
     * @param sex plec
     * @param age wiek
     * @param representation reprezentacja znakowa
     */
    protected Human(int sex, int age, char representation){ //doctors only!
        super("Citizen "+ humanCounter, 'd');
        this.sex = sex;
        this.age = age;
        isInfected = false;
        isAlive = true;
        diseases = new ArrayList<>();
        healthPoints = 100;
        humanCounter++;
    }

    /**
     * Metoda, ktora zwraca ciag znakow z informacjami o konkretnej instancji
     * @return Reprezentacja znakowa obiektu
     */
    public String toString(){
        return "Human " + humanCounter;
    }

    /**
     * Metoda, ktora wykonuje losowy ruch dla czlowieka
     * @param currentPosition Aktualna pozycja
     * @return koordynaty nowego miejsca
     */
    public Coordinates move(Coordinates currentPosition) {
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
        newPosition.addVector(currentPosition);
        return newPosition;
    }

    /**
     * Metoda, ktora symuluje rozwoj choroby
     * @return informacja o rozwoju choroby
     */
    public int performIllness() {
        int output = 0;
        boolean wasInfected = isInfected;
        for(DiseaseRecord illness:diseases) {
            illness.progress(this);
        }
        if(!isAlive) {
            output = -1;
        } else if((!isInfected)&&wasInfected) {
            output = 1;
        }
        return output;
    }

    /** 
     * Metoda, ktora symuluje zdrowienie czlowieka
     */
    public void recover() {
        healthPoints+=10-(age/10)+Dice.d6(2);
        if(healthPoints>100)
            healthPoints = 100;
    }

    /**
     * Metoda, setter, ktora ustawia wartosc punktow zdrowia
     * @param healthPoints ilosc punktow zdrowia
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
   
    /**
     * Metoda, setter, ktora ustawia wartosc pola czy jest zainfekowany
     * @param isInfected Stan logiczny czy jest zainfekowany
     */
    public void setIsInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    /**
     * Metoda, setter, ktora ustawia wartosc pola czy jest zywy
     * @param isAlive Stan logiczny czy jest zywy
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc plci
     * @return wartosc liczbowa odpowiadajaca plci
     */
    public String getSex(){
        return (sex==2)? "male":"female"; 
    }

    /**
     * Metoda, getter, ktora zwraca wartosc punktow zdrowia
     * @return punkty zdrowia
     */
    public int getHealthPoints(){
        return healthPoints;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc logiczna czy jest zainfekowany
     * @return stan logiczny czy jest zainfekowany
     */
    public boolean getIsInfected(){
        return isInfected;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc logiczna czy jest zywy
     * @return stan logiczny czy jest zywy
     */
    public boolean getIsAlive(){
        return isAlive;
    }

    /**
     * Metoda, getter, ktora zwraca wartosc wieku czlowieka
     * @return wiek
     */
    public int getAge(){
        return age;
    }

    /**
     * Metoda, getter, ktora zwraca liste chorob czlowieka
     * @return choroby
     */
    public List<DiseaseRecord> getDiseases(){
        return diseases;
    }

    /**
     * MEtoda, getter, ktora zwraca reprezentacje znakowa obiektu
     * @return znak reprezentujacy obiekt
     */
    public char getRepresentation(){
        if(isInfected){
            return 'r';
        }
        return super.getRepresentation();
    }
}