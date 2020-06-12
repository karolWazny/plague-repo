package random;

/**
 * Klasa, ktora symuluje rzut standardowo spotykana w RPG kostka
 * Mozna powiedziec, ze sa to gereratory liczb losowych dla okreslonych wartosci
 * @version 1.0
 */
public class Dice {
    /**
     * Metoda symulujaca rzut kostka dwuscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka dwuscienna
     * @return wynik losowy
     */
    public static int d2() {
        return d2(1);
    }

    /**
     * Metoda symulujaca rzut kostka czteroscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka czteroscienna
     * @return wynik losowy
     */
    public static int d4() {
        return d4(1);
    }
    
    /**
     * Metoda symulujaca rzut kostka szescioscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka szescioscienna
     * @return wynik losowy
     */
    public static int d6() {
        return d6(1);
    }

    /**
     * Metoda symulujaca rzut kostka osmioscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka osmioscienna
     * @return wynik losowy
     */
    public static int d8() {
        return d8(1);
    }

    /**
     * Metoda symulujaca rzut kostka dziesiecioscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka dziesiecioscienna
     * @return wynik losowy
     */
    public static int d10() {
        return d10(1);
    }

    /**
     * Metoda symulujaca rzut kostka dwunastoscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka dwunastoscienna
     * @return wynik losowy
     */
    public static int d12() {
        return d12(1);
    }

    /**
     * Metoda symulujaca rzut kostka dwudziestoscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka dwudziestoscienna
     * @return wynik losowy
     */
    public static int d20() {
        return d20(1);
    }

    /**
     * Metoda symulujaca rzut kostka stuscienna
     * @param arg ilosc kosci
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
     * Metoda symulujaca rzut jedna kostka stuscienna
     * @return wynik losowy
     */
    public static int d100() {
        return d100(1);
    }

    /**
     * Metoda symulujaca rzut kostka dowolnych rozmiarow
     * @param diceRange rozmiar
     * @param diceNumber ilosc
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
     * Metoda symulujaca rzut jedna kostka o dowolnej liczbie scian
     * @param diceRange liczba scian
     * @return wynik losowy
     */
    public static int custom(int diceRange){
        return custom(diceRange, 1);
    }
}