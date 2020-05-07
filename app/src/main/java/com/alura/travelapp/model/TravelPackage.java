package com.alura.travelapp.model;

import java.math.BigDecimal;

public class TravelPackage {

    private final  String place;
    private final  String image;
    private final  int tripDuration;
    private final BigDecimal price;

    public TravelPackage(String place, String image, int tripDuration, BigDecimal price) {
        this.place = place;
        this.image = image;
        this.tripDuration = tripDuration;
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
