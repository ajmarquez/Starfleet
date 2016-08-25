package com.ninjarobot.abelardo.starshipfleet;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ninjarobot.abelardo.starshipfleet.ui.fragments.FleetFragment;
import com.ninjarobot.abelardo.starshipfleet.utils.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.List;

/**
 * create a starship entity,
 * start writing test cases for entity, viewmodels
 */

public class MainFleetActivity extends AppCompatActivity {

    private List<StarShip> starshipFleet;
    private FleetFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d(FleetConstants.STATUS_DEBUG, "OnCreate");
        setContentView(R.layout.activity_fleet);
        FragmentManager fm = getSupportFragmentManager();

        fragment = (FleetFragment) fm.findFragmentByTag(FleetFragment.TAG);

        if (fragment == null) {
            fragment = new FleetFragment();
              fm.beginTransaction()
               .add(R.id.fragment_container, fragment, FleetFragment.TAG)
                    .commit();
        }

    }


}
