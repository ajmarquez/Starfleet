package com.ninjarobot.abelardo.starshipfleet;

import com.ninjarobot.abelardo.starshipfleet.ui.fragments.FleetFragment;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ajmarquez on 05/08/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", packageName = "com.ninjarobot.abelardo.starshipfleet")

public class FleetFragmentTest {

    private FleetFragment mFleetFragment;
    private List<StarShip> mDataSet;

    @Before
    public void init(){

        mFleetFragment = new FleetFragment();
        mDataSet = mFleetFragment.getDataset();

    }

    @Test
    public void testStarShipObject() throws Exception {

//        assertNotNull(mDataSet);
//
//        for (int i = 0; i < mDataSet.length; i++){
//
//            assertNotNull("NULL object in the array", mDataSet[i]);
//            assertEquals("Not the right class", StarShip.class, mDataSet[i].getClass());
//
//            //Check individual properties
//            assertNotNull("Field is NULL", mDataSet[i].getName());
//            assertNotNull("Field is NULL", mDataSet[i].getModel());
//            assertNotNull("Field is NULL", mDataSet[i].getManufacturer());
//            assertNotNull("Field is NULL", mDataSet[i].getCapacity());
//
//            //Check that Strings are longer than 0
//
//            assertTrue("Field has blank string", mDataSet[i].getName() != "");
//            assertTrue("Field is blank string", mDataSet[i].getModel() != "");
//            assertTrue("Field is blank string", mDataSet[i].getManufacturer() != "");
//
//        }


    }

//    @Test
//    public void testOnCreateView() throws Exception {
//
//    }
}