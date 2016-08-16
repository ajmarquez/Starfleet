package com.ninjarobot.abelardo.starshipfleet.Utilities;

import com.ninjarobot.abelardo.starshipfleet.DetailActivity;
import com.ninjarobot.abelardo.starshipfleet.FleetActivity;
import com.ninjarobot.abelardo.starshipfleet.FleetFragment;
import com.ninjarobot.abelardo.starshipfleet.Interfaces.ApiCallback;
import com.ninjarobot.abelardo.starshipfleet.Interfaces.FleetAPI;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import java.util.List;
import java.util.function.Consumer;

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
    public boolean isFleetReady = false;


    public Retrofit createFactory () {

        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }




    public void getStarships(ApiCallback callbackObject){

        FleetAPI service = createFactory().create(FleetAPI.class);
        Call<StartShipWrapper> call = service.getEntity();

        call.enqueue(new Callback<StartShipWrapper>() {
            @Override
            public void onResponse(Call<StartShipWrapper> call, Response<StartShipWrapper> response) {
                if (response.isSuccessful()){

                    starshipList = response.body().getResults();
//                    ShipCallback(fragment,starshipList );
                    callbackObject.ShipCallback(starshipList);
                }
            }

            @Override
            public void onFailure(Call<StartShipWrapper> call, Throwable t) {

            }
        });

    }
}
