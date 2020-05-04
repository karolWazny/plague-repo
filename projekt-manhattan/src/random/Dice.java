package random;

public class Dice {
    //symulacja rzutu (arg)k(x) dla standardowo spotykanych w RPG kości
    //tak, ta klasa powstała w ramach innego projektu, ale to tylko dowodzi, że była warta napisania
    public static int d2(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*2)+1;
        }
        return wynik;
    }

    public static int d2() {
        return d2(1);
    }

    public static int d4(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*4)+1;
        }
        return wynik;
    }

    public static int d4() {
        return d4(1);
    }
    
    public static int d6(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*6)+1;
        }
        return wynik;
    }

    public static int d6() {
        return d6(1);
    }

    public static int d8(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*8)+1;
        }
        return wynik;
    }

    public static int d8() {
        return d8(1);
    }

    public static int d10(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*10)+1;
        }
        return wynik;
    }

    public static int d10() {
        return d10(1);
    }

    public static int d12(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*12)+1;
        }
        return wynik;
    }

    public static int d12() {
        return d12(1);
    }

    public static int d20(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*20)+1;
        }
        return wynik;
    }

    public static int d20() {
        return d20(1);
    }

    public static int d100(int arg) {
        int wynik = 0;
        for(int i = 0; i<arg; i++) {
            wynik+=(int)(Math.random()*100)+1;
        }
        return wynik;
    }

    public static int d100() {
        return d100(1);
    }

    public static int custom(int diceRange, int diceNumber){
        int wynik = 0;
        for(int i = 0; i<diceNumber; i++) {
            wynik+=(int)(Math.random()*diceRange)+1;
        }
        return wynik;
    }

    public static int custom(int diceRange){
        return custom(diceRange, 1);
    }
}