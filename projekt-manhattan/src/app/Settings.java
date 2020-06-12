package app;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;

/**
 * Klasa sluzaca do przechowywania informacji o ustawieniach
 * @version 1.0
 * @see app.SimulationParameters
 */
public class Settings implements Serializable{
    /**
     * Pole z numerem do serializacji
     */
    private static final long serialVersionUID = -1525600418539269674L;
    /**
     * Pole z parametrami symulacji
     */
    SimulationParameters params;
    /**
     * Pole z informacja o sciezce dostepu do folderu z plikami tekstowymi przebiegow
     */
    String outPath;
    /**
     * Pole z informacja o sciezce do odczytu pliku z parametrami symulacji
     */
    String paramPath;

    /**
     * Metoda, konstruktor domyslny tworzaca obiekt klasy ustawienia
     * Istenieje tylko ten jeden sposob tworzenia obiektu
     */
    public Settings(){
        boolean wasException = false;
        try {
            Settings temp = load();
            params = temp.params;
            outPath = temp.outPath;
            paramPath = temp.paramPath;
        } catch (FileNotFoundException e) {
            setDefaultAll();
            wasException = true;
        } catch (IOException e) {
            setDefaultAll();
            wasException = true;
        } catch (ClassNotFoundException e){
            setDefaultAll();
            wasException = true;
        }

        if(wasException){
            try {
                serialize();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Zaczytuje informacje z pliku
     * @return obiekt typu Settings
     * @throws FileNotFoundException Wyrzuca wyjatek, gdy nie ma pliku
     * @throws IOException Wyrzuca wyjatek, gdy sa bledy na wejsciu-wyjsciu
     * @throws ClassNotFoundException Wyrzuca wyjatek, gdy nie znajdzie klasy
     */
    private Settings load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Settings.bin"));
        Settings temp = (Settings)inputStream.readObject();
        inputStream.close();
        return temp;
    }

    /**
     * Metoda, ktora wysyla ustawienia do pliku binarnego
     * @throws IOException wyrzuca blad na wejsciu-wyjsciu
     */
    public void serialize() throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Settings.bin"));
        outputStream.writeObject(this);
        outputStream.close();
        return;
    }

    /**
     * Metoda ustawiajaca wszystko domyslnie
     */
    void setDefaultAll(){
        setDefaultParameters();
        setDefaultOutPath();
        setDefaultParamPath();
        return;
    }

    /**
     * Metoda, getter, ktora zwraca obiekt z parametrami symulacji
     * @return obiekt z parametrami symulacji
     */
    public SimulationParameters getParameters(){
        return params;
    }

    /**
     * Metoda, ktora ustawia wszystkie parametry na domyslne wartosci
     */
    public void setDefaultParameters(){
        params = new SimulationParameters();
        try {
            serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, setter, ktora ustawia parametry w zaleznosci od obiektu, ktory otrzymuje
     * @param parameters obiekt parametrow, ktore maja byc przyjete
     */
    public void setParameters(SimulationParameters parameters){
        params  = new SimulationParameters(parameters);
        try {
            serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, setter, ktora ustawia domyslnie sciezke do pliku tekstowego
     */
    public void setDefaultParamPath(){
        paramPath = "Config.txt";
        try {
            serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, setter, ktora ustawia sciezke do odczytu z pliku
     * @param paramPath sciezka do pliku
     * @throws FileNotFoundException Wyrzuca wyjatek braku pliku
     */
    public void setParamPath(String paramPath) throws FileNotFoundException {
        this.paramPath = paramPath;
        File file = new File(paramPath);
        params.ReadFromFile(file);
        try {
            serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda, setter, ktora domyslnie ustawia OutPath
     */
    public void setDefaultOutPath(){
        outPath = "sim_out\\";
    }

    /**
     * Metoda, getter, ktora zwraca sciezke do plku z parametrami
     * @return ciag znakow - sciezka
     */
    public String getParamPath(){
        return paramPath;
    }

    /**
     * MEtoda, getter, ktora zwraca wartosc pola outPath
     * @return ciag znakow outPath
     */
    public String getOutPath(){
        return outPath;
    }

    /**
     * Metoda, setter, ktora ustawia pole outPath 
     * @param outPath ciag znakow, ktory chcemy ustawic
     * @throws FileNotFoundException Wyrzuca wyjatek, gdy nie znajdzie pliku
     */
    public void setOutPath(String outPath) throws FileNotFoundException {
        this.outPath = outPath+"\\";
        File test = new File(outPath);
        if(!test.isDirectory()){
            if(outPath.equals("sim_out\\")){
                test.mkdir();
            } else{
                throw new FileNotFoundException();
            }
        }
        try {
            serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}