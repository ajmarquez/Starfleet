package com.ninjarobot.abelardo.starshipfleet.Utilities;

import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Created by ajmarquez on 12/08/16.
 */
public class StarshipFactory {

    public static final String BASE_URL = "https://swapi.co/";
    List<StarShip> starshipList;


    public List<StarShip> StarshipFactory () {


//        Retrofit restAdapter = new Retrofit.Builder().baseUrl("").build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();




        FleetAPI service = restAdapter.create(FleetAPI.class);
        Call<StartShipWrapper> call = service.getEntity();

        call.enqueue(new Callback<StartShipWrapper>() {
            @Override
            public void onResponse(Call<StartShipWrapper> call, Response<StartShipWrapper> response) {

                starshipList = response.body().getResults();

            }

            @Override
            public void onFailure(Call<StartShipWrapper> call, Throwable t) {

            }
        });


    }
}
