package human;

import random.Dice;

/**
 * Klasa, która przedstawia typ Doktora
 * Dziedziczy po człowieku
 * @version 1.0
 * @see random.Dice
 * @see human.Human
 */
public final class Doctor extends Human{
    /**
     * Metoda, konstruktor doktora, która tworzy doktora
     */
    public Doctor(){
        super(Dice.d2(), 25 + Dice.d20(2), 'd');
    }

    /**
     * Metoda, która symuluje przyspieszone leczenie człowieka - działalność doktora
     * @param patient
     */
    public void heal(Human patient){
        
    }
}