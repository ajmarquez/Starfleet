package com.ninjarobot.abelardo.starshipfleet.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajmarquez on 11/08/16.
 */


public class StartShipWrapper {

    private int count;
    private String next;
    private String previous;
    List<StarShip> results = new ArrayList<StarShip>();

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<StarShip> getResults() {
        return results;
    }

}

