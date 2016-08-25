package com.ninjarobot.abelardo.starshipfleet.controllers;


import com.ninjarobot.abelardo.starshipfleet.entities.StarShip;
import com.ninjarobot.abelardo.starshipfleet.repositories.StarShipRepository;

import java.util.List;

/**
 * Created by ajmarquez on 19/08/16.
 */
public class FleetController {

    private StarShipRepository repo;

    public FleetController(StarShipRepository repo) {
        this.repo = repo;
    }

    public void getRepository(StarshipsRetrieved retriever) {
        repo.getStarships(starShips -> {
                    List<StarShip> list = starShips;
                    retriever.onStarshipsRetrieved(starShips);
                }
        );
    }

    //    public void onClickedCell(List<T> list, int position, Context context){
//        StarShip starShip = (StarShip) list.get(position);
//        selected.onStarShipSelected(starShip);
//    }
//
    public interface StarshipsRetrieved {

        void onStarshipsRetrieved(List<StarShip> starShips);
    }
}