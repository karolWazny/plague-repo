package gui.panels;

import app.Settings;
import app.SimulationParameters;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

/**
 * Klasa, która jest wzorem do stworzenia obiektu - panelu do
 * manualnego wpisywania parametrów symulacji.
 * @version 1.0
 * @see app.Settings
 * @see app.SimulationParameters
 */
public class InputParamPanel extends JPanel {
    /** Pole, które jest potrzebne do serializacji */
    private static final long serialVersionUID = -5953054514721607983L;
    /** Pole, które przechowuje obiekt z ustawieniami */
    private final Settings settings;
    /** Pole, które przechowuje obiekt z obszarem do wpisania długości mapy */
    private final JTextField mapLengthTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania szerokości mapy */
    private final JTextField mapWidthTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania liczby ludzi */
    private final JTextField numPeopleTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania liczby lekarzy */
    private final JTextField numDocsTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania liczby karetek */
    private final JTextField ambulanceNumTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania liczby kości dla wirusa */
    private final JTextField pow1TField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania liczby ścian kości wirusa */
    private final JTextField pow2TField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania czasu potrzebnego do zarażenia */
    private final JTextField timeTilInfectTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania czasu do wyzdrowienia */
    private final JTextField timeTilCuredTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania wskaźnika infekcji */
    private final JTextField infectionRateTField;
    /** Pole, które przechowuje obiekt z obszarem do wpisania szansy na wyzdrowienie */
    private final JTextField activeRateTField;

    /**
     * Metoda, konstruktor, która jest odpowiedzialna za stworzenie obiektu 
     * tej klasy w zależności od ustawień
     * @param settings obiekt z ustawieniami
     */
    public InputParamPanel(Settings settings) {
        super();
        this.settings = settings;

        final JPanel bigPanel = new JPanel();

        final JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Map length:"));
        panel1.add(new JLabel("Map width:"));
        panel1.add(new JLabel("People number:"));
        panel1.add(new JLabel("Doctors number:"));
        panel1.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel1);

        mapLengthTField = new JTextField();
        mapWidthTField = new JTextField();
        numPeopleTField = new JTextField();
        numDocsTField = new JTextField();
        numDocsTField.setColumns(5);

        final JPanel panel2 = new JPanel();
        panel2.add(mapLengthTField);
        panel2.add(mapWidthTField);
        panel2.add(numPeopleTField);
        panel2.add(numDocsTField);
        panel2.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel2);

        final JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Ambulances number:"));
        panel3.add(new JLabel("Virus power 1:"));
        panel3.add(new JLabel("Virus power 2:"));
        panel3.add(new JLabel("Time til infecting others:  "));
        panel3.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel3);

        ambulanceNumTField = new JTextField();
        ambulanceNumTField.setColumns(5);
        pow1TField = new JTextField();
        pow2TField = new JTextField();
        timeTilInfectTField = new JTextField();

        final JPanel panel4 = new JPanel();
        panel4.add(ambulanceNumTField);
        panel4.add(pow1TField);
        panel4.add(pow2TField);
        panel4.add(timeTilInfectTField);
        panel4.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel4);

        final JPanel panel5 = new JPanel();
        panel5.add(new JLabel("Time til the end of disease:  "));
        panel5.add(new JLabel("Infection rate:"));
        panel5.add(new JLabel("Rate of active cases of virus:"));
        panel5.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel5);

        timeTilCuredTField = new JTextField();
        infectionRateTField = new JTextField();
        activeRateTField = new JTextField();
        activeRateTField.setColumns(5);

        final JPanel panel6 = new JPanel();
        panel6.add(timeTilCuredTField);
        panel6.add(infectionRateTField);
        panel6.add(activeRateTField);
        panel6.setLayout(new GridLayout(0, 1, 5, 8));
        bigPanel.add(panel6);

        bigPanel.setLayout(new BoxLayout(bigPanel, BoxLayout.LINE_AXIS));
        add(bigPanel);

        final JPanel buttonPanel = new JPanel();

        final JButton defaultButt = new JButton("Set default parameters");
        defaultButt.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                settings.setDefaultParameters();
                refresh();

                try {
                    settings.serialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        final JButton confirmButt = new JButton("Confirm new parameters");
        confirmButt.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                SimulationParameters params = new SimulationParameters(settings.getParameters());
                int buffer = -1;

                //mapLength
                try{
                    buffer = Integer.valueOf(mapLengthTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Map length","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setMapLength(buffer);
                    buffer = -1;
                }

                //mapWidth
                try{
                    buffer = Integer.valueOf(mapWidthTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Map width","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setMapWidth(buffer);
                    buffer = -1;
                }

                //numPeople
                try{
                    buffer = Integer.valueOf(numPeopleTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "People number","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setNumPeople(buffer);
                    buffer = -1;
                }

                //numDocs
                try{
                    buffer = Integer.valueOf(numDocsTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Doctors number","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setNumDocs(buffer);
                    buffer = -1;
                }

                //numAmbulance
                try{
                    buffer = Integer.valueOf(ambulanceNumTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Ambulances number","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setNumAmbulance(buffer);
                    buffer = -1;
                }

                //pow1
                try{
                    buffer = Integer.valueOf(pow1TField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Virus power 1","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setPower1(buffer);
                    buffer = -1;
                }

                //pow2
                try{
                    buffer = Integer.valueOf(pow2TField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Virus power 2","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setPower2(buffer);
                    buffer = -1;
                }

                //timeTilInfect
                try{
                    buffer = Integer.valueOf(timeTilInfectTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" +"Time til infecting others","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setTimeTilInfect(buffer);
                    buffer = -1;
                }

                //timeTilCured
                try{
                    buffer = Integer.valueOf(timeTilCuredTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Time til the end of disease","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setTimeTilCured(buffer);
                    buffer = -1;
                }

                //infectionRate
                try{
                    buffer = Integer.valueOf(infectionRateTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Infection rate","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setInfectionRate(buffer);
                    buffer = -1;
                }

                //activeRate
                try{
                    buffer = Integer.valueOf(activeRateTField.getText());
                } catch (NumberFormatException ex){
                    buffer = -1;
                    JOptionPane.showMessageDialog(getParent(), "Incorrect number format in:\n" + "Rate of active cases of virus","Incorrect input",JOptionPane.WARNING_MESSAGE);
                }
                
                if(buffer != -1){
                    params.setActiveRate(buffer);
                    buffer = -1;
                }

                settings.setParameters(params);
                refresh();
                try {
                    settings.serialize();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonPanel.add(defaultButt);
        buttonPanel.add(confirmButt);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        add(buttonPanel);

        refresh();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    /**
     * Metoda, która odpowiedzialna jest za odświeżenie widoku w panelu
     */
    public void refresh(){
        mapLengthTField.setText("" + settings.getParameters().getMapLength());
        mapWidthTField.setText("" + settings.getParameters().getMapWidth());
        numPeopleTField.setText("" + settings.getParameters().getNumPeople());
        numDocsTField.setText("" + settings.getParameters().getNumDocs());
        ambulanceNumTField.setText("" + settings.getParameters().getNumAmbulance());
        pow1TField.setText("" + settings.getParameters().getPower1());
        pow2TField.setText("" + settings.getParameters().getPower2());
        timeTilInfectTField.setText("" + settings.getParameters().getTimeTilInfect());
        timeTilCuredTField.setText("" + settings.getParameters().getTimeTilCured());
        infectionRateTField.setText("" + settings.getParameters().getInfectionRate());
        activeRateTField.setText("" + settings.getParameters().getActiveRate());
    }
}