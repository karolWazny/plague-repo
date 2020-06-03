package app;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class Settings implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = -282658663089910836L;
    SimulationParameters params;
    String outPath;
    String paramPath;

    ////////////////////////
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

    ///////////////////////////

    private Settings load() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Settings.bin"));
        Settings temp = (Settings)inputStream.readObject();
        inputStream.close();
        return temp;
    }

    //////////////////////////////////

    private void serialize() throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Settings.bin"));
        outputStream.writeObject(this);
        outputStream.close();
        return;
    }

    ///////////////////////////////

    void setDefaultAll(){
        params = new SimulationParameters();
        outPath = new String();
        paramPath = new String();
        return;
    }

    //////////////////////////////////

    public SimulationParameters getParameters(){
        return params;
    }
}