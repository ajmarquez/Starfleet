package com.ninjarobot.abelardo.starshipfleet.repositories;

import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.utils.function.Consumer;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajmarquez on 24/08/16.
 */
public class StarShipRepositoryTest {

    private List<StarShip> starships = new ArrayList<>();
    private StarShipRepository repo = new StarShipRepository();
    private Consumer consumer;

    @Test
    public void testType() {
        repo.getStarships(new Consumer<List<StarShip>>() {
            @Override
            public void consume(List<StarShip> starShips) {
                for (StarShip starShip : starShips){
                    assert starShip instanceof StarShip;
                }
            }
        });
    }

    @Test
    public void testNotNull() {
        repo.getStarships(new Consumer<List<StarShip>>() {
            @Override
            public void consume(List<StarShip> starShips) {

                    Assert.assertNotNull(starShips);


            }
        });
    }

    @Test
    public void testBlankList() {
        repo.getStarships(new Consumer<List<StarShip>>() {
            @Override
            public void consume(List<StarShip> starShips) {
                Assert.assertTrue(starShips.size() > 0);
            }
        });
    }
}