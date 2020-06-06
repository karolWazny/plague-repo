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
 * Klasa, której obiekty odpowiedzialne są za wyświetlanie
 * aktualnej sytuacji na mapie
 * @version 1.0
 * @see map.Map
 */
public class PanelMap extends JPanel{
    /** Pole potrzebne do serializacji */
    private static final long serialVersionUID = -4468016093122501126L;
    /** Pole, które przechowuje aktualną mapę */
    private Map map;
    /** Pole, które przechowuje ikonę mężczyzny */
    private BufferedImage maleIcon;
    /** Pole, które przechowuje ikonę kobiety */
    private BufferedImage femaleIcon;
    /** Pole, które przechowuje jednolitą ikonę obiektu zainfekowanego */
    private BufferedImage infectedIcon;
    /** Pole, które przechowuje ikonę doktora */
    private BufferedImage doctorIcon;
    /** Pole, które przechowuje ikonę szpitala */
    private BufferedImage hospitalIcon;
    /** Pole, które przechowuje ikonę karetki */
    private BufferedImage ambulanceIcon;
    /** Pole, które przechowuje wysokość ikony */
    private int iconHeight = 16;
    /** Pole, które przechowuje szerokość ikony */
    private int iconWidth = 16;

    /**
     * Metoda, konstruktor, która tworzy obiekty tej klasy
     * @param map używana mapa
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
     * Metoda, która jest odpowiedzialna za przydzielanie obiektom
     * z mapy odpowiednich ikon
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