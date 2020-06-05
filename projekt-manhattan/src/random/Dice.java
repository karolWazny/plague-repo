package random;

/**
 * Klasa, która symuluje rzut standardowo spotykaną w RPG kostką
 * Można powiedzieć, że są to gereratory liczb losowych dla określonych wartości
 * @version 1.0
 */
public class Dice {
    /**
     * Metoda symulująca rzut kostką dwuścienną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d2(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*2)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką dwuścienną
     * @return wynik losowy
     */
    public static int d2() {
        return d2(1);
    }

    /**
     * Metoda symulująca rzut kostką czterościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d4(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*4)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką czterościenną
     * @return wynik losowy
     */
    public static int d4() {
        return d4(1);
    }
    
    /**
     * Metoda symulująca rzut kostką sześciościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d6(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*6)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką sześciościenną
     * @return wynik losowy
     */
    public static int d6() {
        return d6(1);
    }

    /**
     * Metoda symulująca rzut kostką ośmiościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d8(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*8)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką ośmiościenną
     * @return wynik losowy
     */
    public static int d8() {
        return d8(1);
    }

    /**
     * Metoda symulująca rzut kostką dziesięciościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d10(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*10)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką dziesięciościenną
     * @return wynik losowy
     */
    public static int d10() {
        return d10(1);
    }

    /**
     * Metoda symulująca rzut kostką dwunastościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d12(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*12)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką dwunastościenną
     * @return wynik losowy
     */
    public static int d12() {
        return d12(1);
    }

    /**
     * Metoda symulująca rzut kostką dwudziestościenną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d20(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*20)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką dwudziestościenną
     * @return wynik losowy
     */
    public static int d20() {
        return d20(1);
    }

    /**
     * Metoda symulująca rzut kostką stuścienną
     * @param arg ilość kości
     * @return wynik losowy
     */
    public static int d100(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*100)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką stuścienną
     * @return wynik losowy
     */
    public static int d100() {
        return d100(1);
    }

    /**
     * Metoda symulująca rzut kostką dowolnych rozmiarów
     * @param diceRange rozmiar
     * @param diceNumber ilość
     * @return wynik losowy
     */
    public static int custom(int diceRange, int diceNumber){
        int wynik = 0;
        for(int i = 0; i<diceNumber; i++) {
            wynik+=(int)(Math.random()*diceRange)+1;
        }
        return wynik;
    }

    /**
     * Metoda symulująca rzut jedną kostką o dowolnej liczbie ścian
     * @param diceRange liczba ścian
     * @return wynik losowy
     */
    public static int custom(int diceRange){
        return custom(diceRange, 1);
    }
}