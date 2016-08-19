package com.ninjarobot.abelardo.starshipfleet.entities;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


/**
 * Created by ajmarquez on 04/08/16.
 */
public class StarShipTest {

    private StarShip mStarShip = new StarShip(null, "Deluxe", "Empire Inc.", 1);


    @Test
    public void testConstructor(){
        assertNotNull("Starship NAME is Null", mStarShip.getName());
        assertNotNull("Star MODEL is Null", mStarShip.getModel());
        assertNotNull("Star MANUFACTURER is Null", mStarShip.getManufacturer());
        assertNotNull("Star CAPACITY is Null", mStarShip.getCapacity());
    }



}
