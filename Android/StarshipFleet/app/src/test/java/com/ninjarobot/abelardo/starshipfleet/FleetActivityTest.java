package com.ninjarobot.abelardo.starshipfleet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by ajmarquez on 05/08/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, manifest = "src/main/AndroidManifest.xml", packageName = "com.ninjarobot.abelardo.starshipfleet")
public class FleetActivityTest {

    private FleetActivity mActivity;

    @Test
    public void testOnCreate() throws Exception {

        mActivity = Robolectric.buildActivity(FleetActivity.class).create().get();
        FleetFragment fleetFragment = (FleetFragment) mActivity.
                getSupportFragmentManager().findFragmentByTag(FleetFragment.TAG);
        assertNotNull(fleetFragment);
        assertEquals(FleetFragment.class, fleetFragment.getClass());
    }
}