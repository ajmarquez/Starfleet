package com.ninjarobot.abelardo.starshipfleet;

/**
 * Created by ajmarquez on 04/08/16.
 */
public class Starship {

    private String mName;
    private String mModel;
    private String mManufacturer;
    private int mCapacity;

    public Starship(String name, String model, String manufacturer, int capacity){
        mName = name;
        mModel = model;
        mManufacturer = manufacturer;
        mCapacity = capacity;
    }

    public String getName() {
        return mName;
    }

    public String getModel() {
        return mModel;
    }

    public String getManufacturer() {
        return mManufacturer;
    }

    public int getCapacity() {
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

    public void setCapacity(int capacity) {
        mCapacity = capacity;
    }
}
