package com.ninjarobot.abelardo.starshipfleet.entities;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

/**
 * Created by ajmarquez on 04/08/16.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class StarShip implements Parcelable {

//    @JsonProperty("name")
    private String name;
//    @JsonProperty("model")
    private String model;
//    @JsonProperty("manufacturer")
    private String manufacturer;
//    @JsonProperty("cargo_capacity")
    private int capacity;

    @JsonCreator
    public StarShip(@JsonProperty("name") String name, @JsonProperty("model") String model, @JsonProperty("manufacturer") String manufacturer, @JsonProperty("cargo_capacity") String cargo){
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.capacity = Integer.parseInt(cargo);
    }

//    public StarShip(String name, String model, String manufacturer, Integer capacity){
//        this.name = name;
//        this.model = model;
//        this.manufacturer = manufacturer;
//        this.capacity = capacity;
//    }


    public StarShip () {
    }


//    @JsonGetter("name")
    public String getName() {
        return name;
    }

//    @JsonGetter("model")
    public String getModel() {
        return model;
    }

//    @JsonGetter("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }


//    @JsonGetter("cargo_capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        setCapacity(in.readInt());
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
        parcel.writeInt(getCapacity());

    }
}
