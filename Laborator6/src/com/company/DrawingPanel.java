package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static java.lang.Math.random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }

    public void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.gray); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }


    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            } //Can’t use lambdas, JavaFX does a better job in these cases
        });
    }
    private void drawShape(int x, int y) {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        int radius = (int) ((Math.random() * ((75- 25) + 1)) + 25); //generate a random number
        int sides = (int) frame.configPanel.getSidesField().getValue(); //get the value from UI (in ConfigPanel)

        String color=(String)frame.configPanel.colorField.getValue();

        Color color2;
        color2=new Color(r, g, b);//create a transparent random Color.
        switch (color) {
            case "Rosu":
                color2=Color.RED;
                break;
            case "Verde":
                color2=Color.green;
                break;
            case "Negru":
                color2=Color.black;
                break;
            case "Random":
                color2=new Color(r, g, b);//create a transparent random Color.
                break;
            default:
        }


       // Color color = new Color(r, g, b);//create a transparent random Color.

        graphics.setColor(color2);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
    //...NEXT SLIDE

