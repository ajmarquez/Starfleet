package com.ninjarobot.abelardo.starshipfleet.entities;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * Created by ajmarquez on 04/08/16.
 */

public class StarShip {

    private String mName;
    private String mModel;
    private String mManufacturer;
    private String mCapacity;

    public StarShip(){}
    public StarShip(String name, String model, String manufacturer, String capacity){
        mName = name;
        mModel = model;
        mManufacturer = manufacturer;
        mCapacity = capacity;
    }


    @JsonGetter("name")
    public String getName() {
        return mName;
    }

    @JsonGetter("model")
    public String getModel() {
        return mModel;
    }

    @JsonGetter("manufacturer")
    public String getManufacturer() {
        return mManufacturer;
    }

    @JsonGetter("passenger")
    public String getCapacity() {
        return mCapacity;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public void setManufacturer(String manufacturer) {
        mManufacturer = manufacturer;
    }

    public void setCapacity(String capacity) {
        mCapacity = capacity;
    }
}
