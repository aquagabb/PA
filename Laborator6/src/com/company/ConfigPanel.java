package com.company;


import com.sun.xml.internal.bind.v2.TODO;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label; // we’re drawing regular polygons
    JSpinner sidesField; // number of sides
    JSpinner colorField;
    JComboBox colorCombo; // the color of the shape
    String colors[]={"Random","Verde","Negru","Rosu"};

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {

        JLabel sidesLabel = new JLabel("Number of sides:");
        JLabel colorLabel = new JLabel("Color");
        SpinnerListModel model=new SpinnerListModel(colors);
        colorField=new JSpinner(model);

        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);
        add(sidesLabel);
        add(sidesField);
        add(colorLabel);
        add(colorField);



        frame.add(this);
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

}