package com.ninjarobot.abelardo.starshipfleet.Interfaces;

import com.ninjarobot.abelardo.starshipfleet.FleetFragment;
import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;

import java.util.List;

/**
 * Created by ajmarquez on 15/08/16.
 */

@FunctionalInterface
public interface ApiCallback {

    void ShipCallback (List<StarShip> ships);


}
