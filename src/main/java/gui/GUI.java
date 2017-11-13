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

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import abstracts.AbstractActor;
import abstracts.AbstractSensor;
import actors.AirConditioner;
import actors.Window;
import interfaces.Actor;
import interfaces.Sensor;
import sensors.Anemometer;
import sensors.Clock;
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

	public JPanel getPanel() {
		return panel;
	}

	public void start() {
    	getContentPane().add(panel, BorderLayout.NORTH);
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
    	if(s instanceof Clock) {
    		addClock(s);
    	} else if(s instanceof Anemometer) {
    		addAnemometer(s);
    	} else if(s instanceof Thermometer) {
    		addThermometer(s);
    	}
    }
     
    private void addThermometer(Sensor s) {
    	JLabel thermometerLabel = new JLabel(((AbstractSensor) s).getProperties().getName());
        thermometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JSlider thermometerSlider = new JSlider(
        		JSlider.HORIZONTAL,
                Thermometer.MIN_VALUE, 
                Thermometer.MAX_VALUE, 
                0
        );
        thermometerSlider.setMajorTickSpacing(50);
        thermometerSlider.setMinorTickSpacing(25);
        thermometerSlider.setPaintTicks(true);
        thermometerSlider.setPaintLabels(true);
        thermometerSlider.addChangeListener(new ThermometerListener(thermometerLabel, s));
        
        panel.add(thermometerLabel);
        panel.add(thermometerSlider);
	}

	private void addAnemometer(Sensor s) {
		JLabel anemometerLabel = new JLabel(((AbstractSensor) s).getProperties().getName());
        anemometerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JSlider anemometerSlider = new JSlider(
        		JSlider.HORIZONTAL,
                Anemometer.MIN_VALUE, 
                Anemometer.MAX_VALUE, 
                6
        );
        anemometerSlider.setMajorTickSpacing(4);
        anemometerSlider.setMinorTickSpacing(2);
        anemometerSlider.setPaintTicks(true);
        anemometerSlider.setPaintLabels(true);
        anemometerSlider.addChangeListener(new AnemometerListener(anemometerLabel, s));
        
        panel.add(anemometerLabel);
        panel.add(anemometerSlider);
	}

	private void addClock(Sensor s) {
		JLabel timeLabel = new JLabel(((AbstractSensor) s).getProperties().getName());
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JTextField timeTextField = new JTextField();
        timeTextField.setHorizontalAlignment(SwingConstants.CENTER);
        timeTextField.addKeyListener(new ClockListener(timeLabel, timeTextField, s));
        
        panel.add(timeLabel);
        panel.add(timeTextField);
	}
	
	public void addActor(Actor a) {
		if(a instanceof AirConditioner) {
			addAirConditioner(a);
		} else if(a instanceof Window) {
			addWindow(a);
		}
	}

	private void addAirConditioner(Actor a) {
		JLabel airConditionerLabel = new JLabel(((AbstractActor) a).getProperties().getName());
        airConditionerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        JSlider airConditionerSlider = new JSlider(JSlider.HORIZONTAL, 0, 2, 1);
        airConditionerSlider.setPaintLabels(true);
        airConditionerSlider.setPaintTicks(true);
        airConditionerSlider.setMajorTickSpacing(3);
        airConditionerSlider.setMinorTickSpacing(1);
        
        Dictionary<Integer, Component> airConditionerLabelTable = new Hashtable<Integer, Component>();
        airConditionerLabelTable.put(AirConditioner.OFF, new JLabel("OFF"));
        airConditionerLabelTable.put(AirConditioner.COOLER_MODE, new JLabel("COOLER"));
        airConditionerLabelTable.put(AirConditioner.HEATER_MODE, new JLabel("HEATER"));
   
        airConditionerSlider.setLabelTable(airConditionerLabelTable);
        airConditionerSlider.setEnabled(false);
        
        panel.add(airConditionerLabel);
        panel.add(airConditionerSlider);
	}
	
	private void addWindow(Actor a) {
		JLabel windowLabel = new JLabel("Window");
        windowLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(windowLabel);
        
        JSlider windowSlider = new JSlider(JSlider.HORIZONTAL,
                0, 1, 1);
        windowSlider.setPaintLabels(true);
        windowSlider.setPaintTicks(true);
        windowSlider.setMajorTickSpacing(3);
        windowSlider.setMinorTickSpacing(1);
        
        Dictionary<Integer, Component> windowLabelTable = new Hashtable<Integer, Component>();
        windowLabelTable.put(Window.CLOSE, new JLabel("CLOSE"));
        windowLabelTable.put(Window.OPEN,  new JLabel("OPEN"));
   
        windowSlider.setLabelTable(windowLabelTable);
        windowSlider.setEnabled(false);
        panel.add(windowSlider);
	}

	public void addComponentsToPane(final Container pane) {
        pane.add(panel, BorderLayout.NORTH);
        Dimension d = new Dimension(600,350);
        pane.setPreferredSize(d);
        Border padding = BorderFactory.createEmptyBorder(10, -100, 10, 10);

        panel.setBorder(padding);
    }
     
    public static void main(String[] args) {
    	//Create and set up the window.
    	GUI frame = new GUI("Automatic House");
        
        //Set up the content pane.
        frame.addTitle("eka");
        frame.addComponentsToPane(frame.getContentPane());
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
