package com.ninjarobot.abelardo.starshipfleet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * create a starship entity,
 * start writing test cases for entity, viewmodels
 *
 */

public class FleetActivity extends AppCompatActivity {

    private Button mDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);

        FragmentManager fm = getSupportFragmentManager();

        FleetFragment fragment = (FleetFragment) fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new FleetFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment, FleetFragment.TAG)
                    .commit();
        }
    }


}
