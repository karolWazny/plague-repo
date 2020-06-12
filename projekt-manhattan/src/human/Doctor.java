package human;

import random.Dice;

/**
 * Klasa, ktora przedstawia typ Doktora
 * Dziedziczy po czlowieku
 * @version 1.0
 * @see random.Dice
 * @see human.Human
 */
public final class Doctor extends Human{
    /**
     * Metoda, konstruktor doktora, ktora tworzy doktora
     */
    public Doctor(){
        super(Dice.d2(), 25 + Dice.d20(2), 'd');
    }

    /**
     * Metoda, ktora symuluje przyspieszone leczenie czlowieka - dzialalnosc doktora
     * @param patient
     */
    public void heal(Human patient){
        
    }
}