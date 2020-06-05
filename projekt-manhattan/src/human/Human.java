package human;

import java.util.ArrayList;
import java.util.List;
import random.Dice;
import virus.DiseaseRecord;
import map.Being;
import container.IMovable;
import container.Coordinates;

/**
 * Klasa, która posiada wszelkie informacje i funkcjonalności, by abstrakcyjnie
 * przedstawić człowieka
 * @version 1.0
 * @see random.Dice 
 * @see virus.DiseaseRecord
 * @see map.Being
 * @see container.IMovable
 * @see container.Coordinates
 */
public class Human extends Being implements IMovable, IDiseaseSensitive {
    /** Pole z ilością punktów życia */
    private int healthPoints;
    /** Pole z informacją czy jest zarażony */
    private boolean isInfected;
    /** Pole z informacją czy jest żywy */
    private boolean isAlive;
    /** Pole z informacją o płci 1==female, 2 == male */
    private final int sex;
    /** Pole z informacją o wieku */
    private int age;
    /** Pole z listą chorób człowieka */
    private List<DiseaseRecord> diseases; 
    /** Statyczne pole z liczbą ludzi */
    private static int humanCounter = 1;
    
    /**
     * Metoda, konstruktor klasy człowieka, która jako parametry przyjmuje płeć i wiek
     * @param sex informacja o płci
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
     * Metoda, konstruktor domyślny człowieka, płeć i inne 
     * parametry są przydzielane losowo bądź odgórnie
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
     * Metoda, konstruktor, który został stworzony na potrzeby dziedziczenia dla doktora
     * @param sex płeć
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
     * Metoda, która zwraca ciąg znaków z informacjami o konkretnej instancji
     * @return Reprezentacja znakowa obiektu
     */
    public String toString(){
        return "Human " + humanCounter;
    }

    /**
     * Metoda, która wykonuje losowy ruch dla człowieka
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
     * Metoda, która symuluje rozwój choroby
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
     * Metoda, która symuluje zdrowienie człowieka
     */
    public void recover() {
        healthPoints+=10-(age/10)+Dice.d6(2);
        if(healthPoints>100)
            healthPoints = 100;
    }

    /**
     * Metoda, setter, która ustawia wartość punktów zdrowia
     * @param healthPoints ilość punktów zdrowia
     */
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
   
    /**
     * Metoda, setter, która ustawia wartość pola czy jest zainfekowany
     * @param isInfected Stan logiczny czy jest zainfekowany
     */
    public void setIsInfected(boolean isInfected) {
        this.isInfected = isInfected;
    }

    /**
     * Metoda, setter, która ustawia wartość pola czy jest żywy
     * @param isAlive Stan logiczny czy jest żywy
     */
    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * Metoda, getter, która zwraca wartość płci
     * @return wartość liczbowa odpowiadająca płci
     */
    public String getSex(){
        return (sex==2)? "male":"female"; 
    }

    /**
     * Metoda, getter, która zwraca wartość punktów zdrowia
     * @return punkty zdrowia
     */
    public int getHealthPoints(){
        return healthPoints;
    }

    /**
     * Metoda, getter, która zwraca wartość logiczną czy jest zainfekowany
     * @return stan logiczny czy jest zainfekowany
     */
    public boolean getIsInfected(){
        return isInfected;
    }

    /**
     * Metoda, getter, która zwraca wartość logiczną czy jest żywy
     * @return stan logiczny czy jest żywy
     */
    public boolean getIsAlive(){
        return isAlive;
    }

    /**
     * Metoda, getter, która zwraca wartość wieku człowieka
     * @return wiek
     */
    public int getAge(){
        return age;
    }

    /**
     * Metoda, getter, która zwraca listę chorób człowieka
     * @return choroby
     */
    public List<DiseaseRecord> getDiseases(){
        return diseases;
    }

    /**
     * MEtoda, getter, która zwraca reprezentację znakową obiektu
     * @return znak reprezentujący obiekt
     */
    public char getRepresentation(){
        if(isInfected){
            return 'r';
        }
        return super.getRepresentation();
    }
}