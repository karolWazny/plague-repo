package gui.panels;

import map.Map;
import container.Coordinates;

import java.awt.image.BufferedImage;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 * Klasa, ktorej obiekty odpowiedzialne sa za wyswietlanie
 * aktualnej sytuacji na mapie.
 * @version 1.0
 * @see map.Map
 */
public class PanelMap extends JPanel{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = -4468016093122501126L;
    /** Pole, ktore przechowuje aktualna mape */
    private Map map;
    /** Pole, ktore przechowuje ikone mezczyzny */
    private BufferedImage maleIcon;
    /** Pole, ktore przechowuje ikone kobiety */
    private BufferedImage femaleIcon;
    /** Pole, ktore przechowuje jednolita ikone obiektu zainfekowanego */
    private BufferedImage infectedIcon;
    /** Pole, ktore przechowuje ikone doktora */
    private BufferedImage doctorIcon;
    /** Pole, ktore przechowuje ikone szpitala */
    private BufferedImage hospitalIcon;
    /** Pole, ktore przechowuje ikone karetki */
    private BufferedImage ambulanceIcon;
    /** Pole, ktore przechowuje wysokosc ikony */
    private int iconHeight = 16;
    /** Pole, ktore przechowuje szerokosc ikony */
    private int iconWidth = 16;

    /**
     * Metoda, konstruktor, ktora tworzy obiekty tej klasy
     * @param map uzywana mapa
     */
    public PanelMap(Map map){
        super();
        this.map = map;

        try {
            File icon = new File("male.png");
            maleIcon = ImageIO.read(icon);
            icon = new File("female.png");
            femaleIcon = ImageIO.read(icon);
            icon = new File("infected.png");
            infectedIcon = ImageIO.read(icon);
            icon = new File("doctor.png");
            doctorIcon = ImageIO.read(icon);
            icon = new File("hospital.png");
            hospitalIcon = ImageIO.read(icon);
            icon = new File("ambulance.png");
            ambulanceIcon = ImageIO.read(icon);
            setPreferredSize(new Dimension(map.getWidth()*iconWidth, iconHeight*map.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** 
     * Metoda, ktora jest odpowiedzialna za wydruk mapy do okienka.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        char c = 'q';
        BufferedImage img = null;

        for(int i = 0; i < map.getWidth(); i++) {
            for(int j = 0; j < map.getLength(); j++) {
                c = map.getField(new Coordinates(j, i)).getRepresentation();

                switch(c){
                    case 'm':img = maleIcon;
                        break;
                    case 'k':img = femaleIcon;
                        break;
                    case 'r':img = infectedIcon;
                        break;
                    case 'd':img = doctorIcon;
                        break;
                    case 'H':img = hospitalIcon;
                        break;
                    case 'A':img = ambulanceIcon;
                        break;
                    default:img = null;
                        break;
                }
                try {
                    g2d.drawImage(img, i*iconWidth, j*iconHeight, this);
                } catch (NullPointerException e){
                    continue;
                }
            }
        }
    }
    
}