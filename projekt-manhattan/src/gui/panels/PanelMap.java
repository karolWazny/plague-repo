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

public class PanelMap extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = -4468016093122501126L;
    private Map map;
    private BufferedImage maleIcon;
    private BufferedImage femaleIcon;
    private BufferedImage infectedIcon;
    private int iconHeight = 16;
    private int iconWidth = 16;

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
            setPreferredSize(new Dimension(map.getWidth()*iconWidth, iconHeight*map.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
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
                    default:img = null;
                        break;
                }
                try {
                    g2d.drawImage(img, j*iconWidth, i*iconHeight,this);
                } catch (NullPointerException e){
                    continue;
                }
            }
        }
    }
    
}