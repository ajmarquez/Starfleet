package com.ninjarobot.abelardo.starshipfleet;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import com.ninjarobot.abelardo.starshipfleet.Interfaces.ApiCallback;
import com.ninjarobot.abelardo.starshipfleet.Utilities.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.Utilities.StarshipFactory;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import java.util.List;


/**
 * create a starship entity,
 * start writing test cases for entity, viewmodels
 *
 */

public class FleetActivity extends AppCompatActivity implements ApiCallback {

    FleetFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d(FleetConstants.STATUS_DEBUG, "OnCreate");
        
        setContentView(R.layout.activity_fleet);
        FragmentManager fm = getSupportFragmentManager();
        StarshipFactory factory = new StarshipFactory();

        if (fragment == null) {

            fragment = new FleetFragment();
            factory.getStarships(this);
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment, FleetFragment.TAG)
                    .commit();

        }else{

            //This gets called when the screen is flipped
            fragment = (FleetFragment) fm.findFragmentById(R.id.fragment_container);
            factory.getStarships(this);

        }
    }

    @Override
    public void ShipCallback(List<StarShip> ships) {
        fragment.setMyDataset(ships);
    }
}
