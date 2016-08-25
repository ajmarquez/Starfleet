package com.ninjarobot.abelardo.starshipfleet.repositories;


import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.network.RESTClient;
import com.ninjarobot.abelardo.starshipfleet.utils.function.Consumer;

import java.util.List;

/**
 * Created by ajmarquez on 19/08/16.
 */
public class StarShipRepository {

    private List<StarShip> starShips;

    public void getStarships(Consumer<List<StarShip>> consumer) {
        if (starShips == null) {
            RESTClient client = new RESTClient();
            client.getResourse(new Consumer<List<StarShip>>() {
                @Override
                public void consume(List<StarShip> starShips) {
                    List<StarShip> list = starShips;
                    StarShipRepository.this.starShips = starShips;
                    consumer.consume(starShips);
                }
            });
        } else {
            consumer.consume(starShips);
        }
    }
}
