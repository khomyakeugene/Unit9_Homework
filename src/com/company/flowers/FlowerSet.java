package com.company.flowers;

import com.company.utils.Collections;
import com.company.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class FlowerSet {
    private ArrayList<Flower> flowers;

    public FlowerSet() {
        // Init "bouquet space"
        flowers = new ArrayList<>();
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void showFlowerSet() {
        Utils.printMessage(String.format("%s:",getClass().getName()));
        Collections.printList(getFlowers());
    }
}
