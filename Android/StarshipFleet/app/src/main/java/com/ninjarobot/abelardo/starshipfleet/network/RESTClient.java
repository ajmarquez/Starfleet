package com.ninjarobot.abelardo.starshipfleet.network;

import android.util.Log;

import com.ninjarobot.abelardo.starshipfleet.network.interfaces.FleetAPI;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;
import com.ninjarobot.abelardo.starshipfleet.utils.FleetConstants;
import com.ninjarobot.abelardo.starshipfleet.utils.function.Consumer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Created by ajmarquez on 12/08/16.
 */
public class RESTClient {

    public static final String BASE_URL = "https://swapi.co/";
    List<StarShip> starships;


    public Retrofit createFactory() {

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }


    public void getResourse(Consumer consumer) {

        FleetAPI service = createFactory().create(FleetAPI.class);
        Call<StartShipWrapper> call = service.getEntity();

        call.enqueue(new Callback<StartShipWrapper>() {
            @Override
            public void onResponse(Call<StartShipWrapper> call, Response<StartShipWrapper> response) {
                if (response.isSuccessful()) {

                    Log.d(FleetConstants.STATUS_DEBUG, "Success");
                    starships = response.body().getResults();
                    consumer.consume(starships);
                }
            }

            @Override
            public void onFailure(Call<StartShipWrapper> call, Throwable t) {

                Log.d(FleetConstants.STATUS_DEBUG, "FAILURE");

            }
        });

    }
//
//    public void getResources(Consumer<T> consumer){
//
//        consumer.consume();
//    }
//
//    public void postResources(Consumer<T> consumer){
//
//        consumer.consume();
//    }
//
//    public void deleteResources(Consumer<T> consumer){
//
//        consumer.consume();
//    }
//
//    public void patchResources(Consumer<T> consumer){
//
//        consumer.consume();
//    }
}
