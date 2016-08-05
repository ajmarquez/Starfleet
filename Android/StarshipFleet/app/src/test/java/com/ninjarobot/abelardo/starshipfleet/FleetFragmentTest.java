package com.ninjarobot.abelardo.starshipfleet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * Created by ajmarquez on 05/08/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", packageName = "com.ninjarobot.abelardo.starshipfleet")

public class FleetFragmentTest {

    private FleetFragment mFleetFragment;

    @Before
    public void init(){

        FragmentManager fm = new FragmentManager() {
        }
    }

    @Test
    public void testOnCreate() throws Exception {

        mFleetFragment = Robolectric.buildFragment(FleetFragment.class).create().get();


    }

    @Test
    public void testOnCreateView() throws Exception {

    }
}