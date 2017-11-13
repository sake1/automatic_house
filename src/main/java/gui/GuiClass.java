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

public class GuiClass extends JFrame{
	static final int TEMPERATURE_MIN = -273;
	static final int TEMPERATURE_MAX = 100;
	static final int TEMPERATURE_INIT = -86; 
	
	static final int WINDSPEED_MIN = 0;
	static final int WINDSPEED_MAX = 12;
	static final int WINDSPEED_INIT = 6; 
	
	static final String TIME_INIT = "12:00";
    static final String gapList[] = {"0", "10", "15", "20"};
    final static int maxGap = 20;
    JComboBox horGapComboBox;
    JComboBox verGapComboBox;
    JButton applyButton = new JButton("Apply gaps");
    GridLayout experimentLayout = new GridLayout(0,5);
    
    public GuiClass(String name) {
        super(name);
        setResizable(false);
    }
     
    public void initGaps() {
        horGapComboBox = new JComboBox(gapList);
        verGapComboBox = new JComboBox(gapList);
    }
     
    public void addComponentsToPane(final Container pane) {
        initGaps();
        final JPanel compsToExperiment = new JPanel();
        compsToExperiment.setLayout(experimentLayout);
        JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(2,4));
         
        //Set up components preferred size
        JButton b = new JButton("Just fake button");
        Dimension buttonSize = b.getPreferredSize();
        compsToExperiment.setPreferredSize(new Dimension(800,600));
        /**First Row**/ 
        //Add buttons to experiment with Grid Layout
        JLabel sensorLabel = new JLabel("Sensor");
        sensorLabel.setFont(new Font("Serif", Font.BOLD, 17));
        sensorLabel.setVerticalAlignment(SwingConstants.CENTER);
        sensorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(sensorLabel);
        
        compsToExperiment.add(new JLabel(""));
        compsToExperiment.add(new JLabel(""));
        
        JLabel actorLabel = new JLabel("Actor");
        actorLabel.setFont(new Font("Serif", Font.BOLD, 17));
        actorLabel.setVerticalAlignment(SwingConstants.CENTER);
        actorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(actorLabel);
        
        compsToExperiment.add(new JLabel(""));
        /**First Row**/ 
        
        /**Second Row**/ 
        JLabel thermometerLabel = new JLabel("Temperature " + TEMPERATURE_INIT);
        thermometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(thermometerLabel);
        
        JSlider temperatureSlider = new JSlider(JSlider.HORIZONTAL,
                TEMPERATURE_MIN, TEMPERATURE_MAX, TEMPERATURE_INIT);

        temperatureSlider.setMajorTickSpacing(75);
        temperatureSlider.setPaintTicks(true);
        temperatureSlider.setPaintLabels(true);
        temperatureSlider.addChangeListener(new ThermometerListener(thermometerLabel));
        compsToExperiment.add(temperatureSlider);
        compsToExperiment.add(new JLabel(""));
        
        JLabel airConditionerLabel = new JLabel("Air Conditioner");
        airConditionerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(airConditionerLabel);
        
        JSlider airConditionerSlider = new JSlider(JSlider.HORIZONTAL,
                0, 2, 1);
        airConditionerSlider.setPaintLabels(true);
        airConditionerSlider.setPaintTicks(true);
        airConditionerSlider.setMajorTickSpacing(3);
        airConditionerSlider.setMinorTickSpacing(1);
        
        Dictionary<Integer, Component> airConditionerLabelTable = new Hashtable<Integer, Component>();
        airConditionerLabelTable.put(0, new JLabel("HEATER"));
        airConditionerLabelTable.put(1, new JLabel("COOLER"));
        airConditionerLabelTable.put(2, new JLabel("OFF"));
   
        airConditionerSlider.setLabelTable(airConditionerLabelTable);
        airConditionerSlider.setEnabled(false);
        compsToExperiment.add(airConditionerSlider);
        /**Second Row**/ 
        
        /**Third Row**/ 
        JLabel anemometerLabel = new JLabel("Wind Speed " + WINDSPEED_INIT);
        anemometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(anemometerLabel);
        
        JSlider anemometerSlider = new JSlider(JSlider.HORIZONTAL,
                WINDSPEED_MIN, WINDSPEED_MAX, WINDSPEED_INIT);

        anemometerSlider.setMajorTickSpacing(2);
        anemometerSlider.setPaintTicks(true);
        anemometerSlider.setPaintLabels(true);
        anemometerSlider.addChangeListener(new AnemometerListener(anemometerLabel));
        compsToExperiment.add(anemometerSlider);
        compsToExperiment.add(new JLabel(""));
        
        JLabel windowLabel = new JLabel("Window");
        windowLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(windowLabel);
        
        JSlider windowSlider = new JSlider(JSlider.HORIZONTAL,
                0, 1, 1);
        windowSlider.setPaintLabels(true);
        windowSlider.setPaintTicks(true);
        windowSlider.setMajorTickSpacing(3);
        windowSlider.setMinorTickSpacing(1);
        
        Dictionary<Integer, Component> windowLabelTable = new Hashtable<Integer, Component>();
        windowLabelTable.put(0, new JLabel("OPEN"));
        windowLabelTable.put(1, new JLabel("CLOSE"));
   
        windowSlider.setLabelTable(windowLabelTable);
        windowSlider.setEnabled(false);
        compsToExperiment.add(windowSlider);
        /**Third Row**/ 
        
        /**Fourth Row**/ 
        JLabel timeLabel = new JLabel("Time " + TIME_INIT);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        compsToExperiment.add(timeLabel);
        
        JTextField timeTextField = new JTextField("1200");
        timeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        timeTextField.addKeyListener(new ClockListener(timeLabel, timeTextField));
        compsToExperiment.add(timeTextField);
        
        compsToExperiment.add(new JLabel(""));
        compsToExperiment.add(new JLabel(""));
        compsToExperiment.add(new JLabel(""));
        /**Fourth Row**/ 
         
        experimentLayout.setVgap(5);
        experimentLayout.setHgap(5);
        
        pane.add(compsToExperiment, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(controls, BorderLayout.SOUTH);
        String time = "240";
        time = new StringBuffer(time).insert(time.length()-2, ":").toString();
        System.out.println(time);
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
    	GuiClass frame = new GuiClass("GridLayoutDemo");
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
    
    class ThermometerListener implements ChangeListener {
        private JLabel thermometerLabel;
    	public ThermometerListener(JLabel thermometerLabel){
        	this.thermometerLabel = thermometerLabel;
        }
        
    	public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int temperature = (int)source.getValue();
                thermometerLabel.setText("Thermometer " + temperature);
            }    
        }
    }
    
    class AnemometerListener implements ChangeListener {
        private JLabel anemometerLabel;
    	public AnemometerListener(JLabel anemometerLabel){
        	this.anemometerLabel = anemometerLabel;
        }
        
    	public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int windSpeed = (int)source.getValue();
                anemometerLabel.setText("Wind Speed " + windSpeed);
            }    
        }
    }
    
    class ClockListener implements KeyListener {
    	 private JLabel timeLabel;
    	 private JTextField timeTextField;
     	public ClockListener(JLabel timeLabel, JTextField timeTextField){
         	this.timeLabel = timeLabel;
         	this.timeTextField = timeTextField;
         }
     	
		public void keyReleased(KeyEvent arg0) {
			String time = timeTextField.getText();
            time = new StringBuffer(time).insert(time.length()-2, ":").toString();
           
            timeLabel.setText("Time " + time);
			
		}

		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
}
