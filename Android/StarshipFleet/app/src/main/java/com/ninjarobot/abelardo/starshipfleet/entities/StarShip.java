package com.ninjarobot.abelardo.starshipfleet.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ajmarquez on 04/08/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StarShip implements Parcelable {

    private String mName;
    private String mModel;
    private String mManufacturer;
    private String mCapacity;


    public StarShip(String name, String model, String manufacturer, String capacity){
        mName = name;
        mModel = model;
        mManufacturer = manufacturer;
        mCapacity = capacity;
    }


    public StarShip () {

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

    public StarShip(Parcel in) {
        super ();
        readFromParcel(in);
    }


    public static final Parcelable.Creator<StarShip> CREATOR = new Parcelable.Creator<StarShip>() {
        public StarShip createFromParcel(Parcel in) {
            return new StarShip(in);
        }

        public StarShip[] newArray(int size){
            return new StarShip[size];
        }
    };

    public void readFromParcel(Parcel in){
        setName(in.readString());
        setModel(in.readString());
        setManufacturer(in.readString());
        setCapacity(in.readString());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getName());
        parcel.writeString(getModel());
        parcel.writeString(getManufacturer());
        parcel.writeString(getCapacity());

    }
}
