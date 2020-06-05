package app;

import java.io.Serializable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;

public class Settings implements Serializable{
  
    /**
     *
     */
    private static final long serialVersionUID = -1525600418539269674L;
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

    public void serialize() throws IOException{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Settings.bin"));
        outputStream.writeObject(this);
        outputStream.close();
        return;
    }

    ///////////////////////////////

    void setDefaultAll(){
        setDefaultParameters();
        setDefaultOutPath();
        setDefaultParamPath();
        return;
    }

    //////////////////////////////////

    public SimulationParameters getParameters(){
        return params;
    }

    public void setDefaultParameters(){
        params = new SimulationParameters();
        try {
            serialize();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setParameters(SimulationParameters parameters){
        params  = new SimulationParameters(parameters);
        try {
            serialize();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setDefaultParamPath(){
        paramPath = "Config.txt";
        try {
            serialize();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setParamPath(String paramPath) throws FileNotFoundException {
        this.paramPath = paramPath;
        File file = new File(paramPath);
        params.ReadFromFile(file);
        try {
            serialize();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setDefaultOutPath(){
        outPath = "sim_out\\";
    }

    public String getParamPath(){
        return paramPath;
    }

    public String getOutPath(){
        return outPath;
    }

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}