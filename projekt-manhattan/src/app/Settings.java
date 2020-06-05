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
 * Klasa służąca do przechowywania informacji o ustawieniach
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
     * Pole z informacją o ścieżce dostępu do folderu z plikami tekstowymi przebiegów
     */
    String outPath;
    /**
     * Pole z informacją o ścieżce do odczytu pliku z parametrami symulacji
     */
    String paramPath;

    /**
     * Metoda, konstruktor domyślny tworząca obiekt klasy ustawienia
     * Istenieje tylko ten jeden sposób tworzenia obiektu
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
     * @throws FileNotFoundException Wyrzuca wyjątek, gdy nie ma pliku
     * @throws IOException Wyrzuca wyjątek, gdy są błędy na wejściu-wyjściu
     * @throws ClassNotFoundException Wyrzuca wyjatek, gdy nie znajdzie klasy
     */
    private Settings load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Settings.bin"));
        Settings temp = (Settings)inputStream.readObject();
        inputStream.close();
        return temp;
    }

    /**
     * Metoda, która wysyła ustawienia do pliku binarnego
     * @throws IOException wyrzuca błąd na wejściu-wyjściu
     */
    public void serialize() throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Settings.bin"));
        outputStream.writeObject(this);
        outputStream.close();
        return;
    }

    /**
     * Metoda ustawiająca wszystko domyślnie
     */
    void setDefaultAll(){
        setDefaultParameters();
        setDefaultOutPath();
        setDefaultParamPath();
        return;
    }

    /**
     * Metoda, getter, która zwraca obiekt z parametrami symulacji
     * @return obiekt z parametrami symulacji
     */
    public SimulationParameters getParameters(){
        return params;
    }

    /**
     * Metoda, która ustawia wszystkie parametry na domyślne wartości
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
     * Metoda, setter, która ustawia parametry w zależności od obiektu, który otrzymuje
     * @param parameters obiekt parametrów, które mają być przyjęte
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
     * Metoda, setter, która ustawia domyślnie ścieżkę do pliku tekstowego
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
     * Metoda, setter, która ustawia ścieżkę do odczytu z pliku
     * @param paramPath ścieżka do pliku
     * @throws FileNotFoundException Wyrzuca wyjątek braku pliku
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
     * Metoda, setter, która domyślnie ustawia OutPath
     */
    public void setDefaultOutPath(){
        outPath = "sim_out\\";
    }

    /**
     * Metoda, getter, która zwraca ścieżkę do plku z parametrami
     * @return ciąg znaków - ścieżka
     */
    public String getParamPath(){
        return paramPath;
    }

    /**
     * MEtoda, getter, która zwraca wartość pola outPath
     * @return ciąg znaków outPath
     */
    public String getOutPath(){
        return outPath;
    }

    /**
     * Metoda, setter, która ustawia pole outPath 
     * @param outPath ciąg znaków, który chcemy ustawić
     * @throws FileNotFoundException Wyrzuca wyjątek, gdy nie znajdzie pliku
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