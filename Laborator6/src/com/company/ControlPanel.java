package com.company;

import com.sun.xml.internal.bind.v2.TODO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton clearBtn = new JButton("Clean");
    JButton loadBtn = new JButton("Load");
    JButton exitBtn = new JButton("Exit");
    //create all buttons (Load, Reset, Exit)
    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        add(saveBtn);
        add(clearBtn);
        add(loadBtn);
        add(exitBtn);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        clearBtn.addActionListener(this::clean);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("C:\\Users\\gabby\\Downloads\\java\\image.png"));
        } catch (IOException ex) { System.err.println(ex); }
    }

    private void load(ActionEvent e) {
        BufferedImage image=null;
        try {

            JFileChooser fileChooser=new JFileChooser();
            int errorCode = fileChooser.showOpenDialog(null);
            if(errorCode == JFileChooser.APPROVE_OPTION)
            {
                this.frame.canvas.image=ImageIO.read(fileChooser.getSelectedFile()) ;

            }
            frame.setVisible(false);
            frame.setVisible(true);

        } catch (IOException ex) { System.err.println(ex); }


    }

    private void clean(ActionEvent e)
    {
        frame.setVisible(false);
        frame.canvas.createOffscreenImage();
        frame.setVisible(true);
    }

    private void exit (ActionEvent e)
    {
       System.exit(0);

    }





}
