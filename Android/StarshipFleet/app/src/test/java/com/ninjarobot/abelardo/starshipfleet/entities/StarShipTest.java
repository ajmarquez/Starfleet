package com.ninjarobot.abelardo.starshipfleet.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


/**
 * Created by ajmarquez on 04/08/16.
 */

public class StarShipTest {

    private StarShip starShip = new StarShip();

    @Before
    public void before(){
        starShip.setName("Tie fighter");
        starShip.setModel("Deluxe");
        starShip.setManufacturer("The Republic");
        starShip.setCapacity(1234);
    }

    @Test
    public void testNotNull(){
        assertNotNull("Starship NAME is Null", starShip.getName());
        assertNotNull("Star MODEL is Null", starShip.getModel());
        assertNotNull("Star MANUFACTURER is Null", starShip.getManufacturer());
        assertNotNull("Star CAPACITY is Null", starShip.getCapacity());
    }

    @Test
    public void testType(){
        assertSame("Star NAME is a STRING", String.class, starShip.getName().getClass());
        assertSame("Star MODEL is a STRING", String.class, starShip.getModel().getClass());
        assertSame("Star MANUFACTURER is a STRING", String.class, starShip.getManufacturer().getClass());
        assertTrue(Integer.class.isInstance(starShip.getCapacity()));
    }

    @Test
    public void testNullString(){

        starShip.setName(null);
        starShip.setModel(null);
        starShip.setManufacturer(null);

        assertNull("Starship NAME is Null", starShip.getName());
        assertNull("Star MODEL is Null", starShip.getModel());
        assertNull("Star MANUFACTURER is Null", starShip.getManufacturer());

    }




}
