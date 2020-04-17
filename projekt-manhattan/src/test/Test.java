package test;

import map.IPrintable;
import map.EmptySlot;

public class Test {
    public static void main(String[] Args) {
        IPrintable[][] pustePola = new IPrintable[10][10];
        for(int i = 0; i<10; i++) {
            for(int k = 0; k<10 ; k++)
            {
                pustePola[i][k] = new EmptySlot();
            }
        }
        for(int i = 0; i<10 ; i++) 
        {
            for(int k = 0; k<10; k++)
            {
                System.out.print(pustePola[i][k].toString());
            }
            System.out.println("");
        }
    }
}