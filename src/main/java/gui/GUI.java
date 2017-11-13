package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import interfaces.Sensor;
import sensors.Anemometer;
import sensors.Thermometer;

public class GUI extends JFrame {
	
	private static final int ROW_COUNT = 0;
	private static final int COL_COUNT = 2;
	
	private JPanel panel;
	
    public GUI(String title) {
        super(title);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(ROW_COUNT, COL_COUNT));
    }
    
    public void start() {
    	pack();
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addTitle(String title) {
    	JLabel titleLabel = new JLabel(title);
    	titleLabel.setFont(new Font("Serif", Font.BOLD, 17));
    	titleLabel.setVerticalAlignment(SwingConstants.CENTER);
    	titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);
        addGap();
    }
    
    public void addGap() {
    	JLabel emptyLabel = new JLabel("");
    	panel.add(emptyLabel);
    }
    
    public void addSensor(Sensor s) {
    	
    }
     
    public void addComponentsToPane(final Container pane) {
//        /**First Row**/ 
//        //Add buttons to experiment with Grid Layout
//        JLabel sensorLabel = new JLabel("Sensor");
//        sensorLabel.setFont(new Font("Serif", Font.BOLD, 17));
//        sensorLabel.setVerticalAlignment(SwingConstants.CENTER);
//        sensorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(sensorLabel);
//        
//        panel.add(new JLabel(""));
//        panel.add(new JLabel(""));
//        
//        JLabel actorLabel = new JLabel("Actor");
//        actorLabel.setFont(new Font("Serif", Font.BOLD, 17));
//        actorLabel.setVerticalAlignment(SwingConstants.CENTER);
//        actorLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(actorLabel);
//        
//        panel.add(new JLabel(""));
//        /**First Row**/ 
//        
//        /**Second Row**/ 
//        JLabel thermometerLabel = new JLabel("Temperature " + TEMPERATURE_INIT);
//        thermometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(thermometerLabel);
//        
//        JSlider temperatureSlider = new JSlider(JSlider.HORIZONTAL,
//                Thermometer.MIN_VALUE, Thermometer.MAX_VALUE, TEMPERATURE_INIT);
//
//        temperatureSlider.setMajorTickSpacing(75);
//        temperatureSlider.setPaintTicks(true);
//        temperatureSlider.setPaintLabels(true);
//        temperatureSlider.addChangeListener(new ThermometerListener(thermometerLabel));
//        panel.add(temperatureSlider);
//        panel.add(new JLabel(""));
//        
//        JLabel airConditionerLabel = new JLabel("Air Conditioner");
//        airConditionerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(airConditionerLabel);
//        
//        JSlider airConditionerSlider = new JSlider(JSlider.HORIZONTAL,
//                0, 2, 1);
//        airConditionerSlider.setPaintLabels(true);
//        airConditionerSlider.setPaintTicks(true);
//        airConditionerSlider.setMajorTickSpacing(3);
//        airConditionerSlider.setMinorTickSpacing(1);
//        
//        Dictionary<Integer, Component> airConditionerLabelTable = new Hashtable<Integer, Component>();
//        airConditionerLabelTable.put(0, new JLabel("HEATER"));
//        airConditionerLabelTable.put(1, new JLabel("COOLER"));
//        airConditionerLabelTable.put(2, new JLabel("OFF"));
//   
//        airConditionerSlider.setLabelTable(airConditionerLabelTable);
//        airConditionerSlider.setEnabled(false);
//        panel.add(airConditionerSlider);
//        /**Second Row**/ 
//        
//        /**Third Row**/ 
//        JLabel anemometerLabel = new JLabel("Wind Speed " + WINDSPEED_INIT);
//        anemometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(anemometerLabel);
//        
//        JSlider anemometerSlider = new JSlider(JSlider.HORIZONTAL,
//                Anemometer.MIN_VALUE, Anemometer.MAX_VALUE, WINDSPEED_INIT);
//
//        anemometerSlider.setMajorTickSpacing(2);
//        anemometerSlider.setPaintTicks(true);
//        anemometerSlider.setPaintLabels(true);
//        anemometerSlider.addChangeListener(new AnemometerListener(anemometerLabel));
//        panel.add(anemometerSlider);
//        panel.add(new JLabel(""));
//        
//        JLabel windowLabel = new JLabel("Window");
//        windowLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(windowLabel);
//        
//        JSlider windowSlider = new JSlider(JSlider.HORIZONTAL,
//                0, 1, 1);
//        windowSlider.setPaintLabels(true);
//        windowSlider.setPaintTicks(true);
//        windowSlider.setMajorTickSpacing(3);
//        windowSlider.setMinorTickSpacing(1);
//        
//        Dictionary<Integer, Component> windowLabelTable = new Hashtable<Integer, Component>();
//        windowLabelTable.put(0, new JLabel("OPEN"));
//        windowLabelTable.put(1, new JLabel("CLOSE"));
//   
//        windowSlider.setLabelTable(windowLabelTable);
//        windowSlider.setEnabled(false);
//        panel.add(windowSlider);
//        /**Third Row**/ 
//        
//        /**Fourth Row**/ 
//        JLabel timeLabel = new JLabel("Time " + TIME_INIT);
//        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        panel.add(timeLabel);
//        
//        JTextField timeTextField = new JTextField("1200");
//        timeTextField.setHorizontalAlignment(SwingConstants.CENTER);
//        timeTextField.addKeyListener(new ClockListener(timeLabel, timeTextField));
//        panel.add(timeTextField);
//        
//        panel.add(new JLabel(""));
//        panel.add(new JLabel(""));
//        panel.add(new JLabel(""));
//        /**Fourth Row**/ 
//         
//        experimentLayout.setVgap(5);
//        experimentLayout.setHgap(5);
//        
//        pane.add(panel, BorderLayout.NORTH);
//        pane.add(new JSeparator(), BorderLayout.CENTER);
//        String time = "240";
//        time = new StringBuffer(time).insert(time.length()-2, ":").toString();
//        System.out.println(time);
    }
     //-273<=temp<=100
    //    0<=anemo<=12
    /**
     * Create the GUI and show it.  For thread safety,
     * this method is invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	GUI frame = new GUI("Automatic House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
