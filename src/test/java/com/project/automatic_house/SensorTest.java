package com.project.automatic_house;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SensorTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		MainController m = new MainController();
		m.addSensor(new Clock("Clock", new ClockPrompt()));
		m.addSensor(new Anemometer("Anemometer", new AnemometerPrompt()));
		m.addSensor(new Thermometer("Thermometer", new ThermometerPrompt()));
		
		WindowController w = new WindowController();
		w.addWindow(new Window("Window", new WindowPrinter()));
		
		AirConditionerController ac = new AirConditionerController();
		ac.addAirConditioner(new AirConditioner("Air Conditioner", new AirConditionerPrinter()));
		
		m.addSubController(w);
		m.addSubController(ac);
		m.begin();
	}

}
