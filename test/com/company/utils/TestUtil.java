package com.company.utils;

import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Yevgen on 06.02.2016 as a part of the project "Unit9_Homework".
 */
public class TestUtil {
    public static void assertArrayListEquals(ArrayList<? extends Object> expected, ArrayList<? extends Object> actual) {
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}
