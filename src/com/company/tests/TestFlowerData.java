package com.company.tests;

import com.company.caesar.Caesar;
import com.company.flowers.Bouquet;
import com.company.flowers.Aster;
import com.company.flowers.Chamomile;
import com.company.flowers.Rose;
import com.company.flowers.Tulip;
import com.company.utils.Collections;
import com.company.utils.Utils;

import java.util.ArrayList;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestFlowerData {
    public final static String RED_COLOUR = "Red";
    public final static String WHITE_COLOUR = "White";
    public final static String ROSE_COLOUR = "Rose";
    public final static String YELLOW_COLOUR = "Yellow";
    public final static String ENCODED_DATA_MESSAGE = "Encoded data:";
    public final static String DECODED_DATA_MESSAGE = "Decoded data:";

    private Bouquet bouquet;

    private void collectBouquet() {
        bouquet = new Bouquet(new Aster(RED_COLOUR));

        bouquet.addFlower(new Aster(WHITE_COLOUR));
        bouquet.addFlower(new Tulip(RED_COLOUR));
        bouquet.addFlower(new Tulip(ROSE_COLOUR));
        bouquet.addFlower(new Chamomile(WHITE_COLOUR));
        bouquet.addFlower(new Chamomile(WHITE_COLOUR));
        bouquet.addFlower(new Chamomile(YELLOW_COLOUR));
        bouquet.addFlower(new Rose(ROSE_COLOUR));
        bouquet.addFlower(new Rose(RED_COLOUR, Rose.TYPICAL_ROSE_SCENT, true));
    }

    private void showBouquet() {
        bouquet.showFlowerSet();
    }

    public void demonstrateBouquet() {
        collectBouquet();
        showBouquet();
    }

    public void demonstrateEncipherAndDecipherData() {
        // Encipher data using "Caesar method"
        ArrayList<String> encodeArrayList = Caesar.encodeListUsingDefaultShift(bouquet.getFlowers());
        Utils.printMessage(ENCODED_DATA_MESSAGE);
        Collections.printList(encodeArrayList);

        // Decipher data using "Caesar method"
        ArrayList<String> decodeArrayList = Caesar.decodeListUsingDefaultShift(encodeArrayList);
        Utils.printMessage(DECODED_DATA_MESSAGE);
        Collections.printList(decodeArrayList);
    }


    public void demonstrateData() {
        demonstrateBouquet();

        demonstrateEncipherAndDecipherData();
    }
}
