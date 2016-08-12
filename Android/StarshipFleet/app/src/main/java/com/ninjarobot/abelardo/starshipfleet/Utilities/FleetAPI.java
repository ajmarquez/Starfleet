package com.ninjarobot.abelardo.starshipfleet.Utilities;

import com.ninjarobot.abelardo.starshipfleet.entities.StartShipWrapper;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ajmarquez on 12/08/16.
 */
public interface FleetAPI {

    @GET("/api/starships/")
    Call<StartShipWrapper> getEntity();


}


