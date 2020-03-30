package com.company;

import com.sun.xml.internal.bind.v2.TODO;
import jdk.nashorn.internal.ir.LiteralNode;
import jdk.nashorn.internal.ir.PropertyNode;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SpringLayout.SOUTH;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.NORTH;

public class MainFrame extends JFrame {


    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        controlPanel = new ControlPanel(this);
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        init();
    }

    private void init() {

            setVisible(true);
            setSize( 500, 500);

            add(configPanel, BorderLayout.NORTH);
            add(canvas, CENTER);
            add(controlPanel, SOUTH);
            pack();

    }
}
