package com.company.flowers;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class Flower {
    public final static String UNKNOWN_FLOWER_TYPE = "Undefined Flower Type";
    public final static String WITHOUT_SCENT_MESSAGE = "without scent";
    public final static String FLOWER_DESCRIPTION_MESSAGE = "flower: {0}, colour: {1}, scent: {2}";

    private String flowerType;
    private String colour;
    private String scent;

    public Flower(String flowerType, String colour, String scent) {
        // Use "setters" here only as a demonstration of the ability of encapsulation and polymorphism
        setFlowerType(flowerType);
        setColour(colour);
        setScent(scent);
    }

    public Flower(String colour) {
        this(UNKNOWN_FLOWER_TYPE, colour, WITHOUT_SCENT_MESSAGE);
    }

    public Flower() {
        this(null);
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        // Use "getters" here only as a demonstration of the ability of encapsulation and polymorphism
        return MessageFormat.format(FLOWER_DESCRIPTION_MESSAGE, getFlowerType(), getColour(), getScent());
    }
}
