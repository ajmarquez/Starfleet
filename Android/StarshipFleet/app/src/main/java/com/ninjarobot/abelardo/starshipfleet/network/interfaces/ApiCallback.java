package com.ninjarobot.abelardo.starshipfleet.network.interfaces;

import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.List;

/**
 * Created by ajmarquez on 15/08/16.
 */

@FunctionalInterface
public interface ApiCallback {

    void shipCallback(List<StarShip> ships);


}
