package com.ninjarobot.abelardo.starshipfleet.Interfaces;

import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ajmarquez on 12/08/16.
 */
public interface FleetAPI {

    @GET("/api/starships/")
    Call<StartShipWrapper> getEntity();


}


