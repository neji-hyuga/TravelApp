package com.alura.travelapp.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class TravelPackage implements Serializable {

    private final  String place;
    private final  String image;
    private final  int tripLength;
    private final BigDecimal price;

    public TravelPackage(String place, String image, int tripLength, BigDecimal price) {
        this.place = place;
        this.image = image;
        this.tripLength = tripLength;
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public String getImage() {
        return image;
    }

    public int getTripLength() {
        return tripLength;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
