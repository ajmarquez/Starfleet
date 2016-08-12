package com.ninjarobot.abelardo.starshipfleet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ninjarobot.abelardo.starshipfleet.Utilities.HttpUtils;
import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * create a starship entity,
 * start writing test cases for entity, viewmodels
 *
 */

public class FleetActivity extends AppCompatActivity {

    public static final String TAG = FleetFragment.class.getName();
    public static final String BASE_URL = "https://swapi.co/";

    private Button mDetailButton;
    private ExecutorService executor = Executors.newSingleThreadExecutor();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fleet);

        FragmentManager fm = getSupportFragmentManager();

        FleetFragment fragment = (FleetFragment) fm.findFragmentById(R.id.fragment_container);

        /* HERE BEGINS DATA REQUEST BLOCK:
         * Data is requested and Fragment wont be initialized until Json parsing is ready
         */








     /* END OF REQUEST BLOCK */

        if (fragment == null) {
            fragment = new FleetFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment, FleetFragment.TAG)
                    .commit();
        }
    }


}
