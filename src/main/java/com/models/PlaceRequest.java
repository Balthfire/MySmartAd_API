package com.models;

/**
 * Created by Menerith on 17/11/2016.
 */
public class PlaceRequest {

    private int idplace;
    private double latitude;
    private double longitude;
    private double visibility_note;
    private int type_place;

    public PlaceRequest(double latitude, double longitude, double visibility_note, int type_place) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.visibility_note = visibility_note;
        this.type_place = type_place;
    }

    public PlaceRequest() {
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getVisibility_note() {
        return visibility_note;
    }

    public int getType_place() {
        return type_place;
    }
}
