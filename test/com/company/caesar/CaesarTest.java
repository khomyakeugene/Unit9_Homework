package com.company.caesar;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Yevgen on 05.02.2016 as a part of the project "Unit9_Homework".
 */
public class CaesarTest {
    public final static int TEST_SHIFT = 20;

    public void assertArrayListEquals(ArrayList<? extends Object> expecteds, ArrayList<? extends Object> actuals) {
//        expecteds
//                .stream()
//                .forEach(f -> resultList.add(encodeString(f.toString(), shift)));
    }

    @Test (timeout = 1000)
    public void testEncodeChars() throws Exception {
        final char[] sourceChars = {'a', 's', 'd', 'f', 'g', 'h', 'j'};
        final char[] expectedResult = {'u', '\'', 'x', 'z', '{', '|', '~'};

        final char[] result = Caesar.encodeChars(sourceChars, TEST_SHIFT);
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test (timeout = 1000)
    public void testEncodeString() throws Exception {
        final String sourceString = "People are strange when you're a stranger Faces look ugly when you're alone ...";
        final String result = Caesar.encodeString(sourceString, TEST_SHIFT);

        final String expectedResult = "dy#$ y4u&y4'(&u\"{y4+|y\"4-#);&y4u4'(&u\"{y&4Zuwy'4 ##\u007F4){ -4+|y\"4-#);&y4u #\"y4BBB";
        Assert.assertEquals(expectedResult, result);
    }

    @Test (timeout = 1000)
    public void testDecodeChars() throws Exception {
        final char[] sourceChars =
                {'a', '-', '4', '+', '}', ' ', 'x', '4', ' ', '#', '*', 'y', '4', '}', '\'', '4', '&', '}', '\'', '}', '"', '{',};
        final char[] result = Caesar.decodeChars(sourceChars, TEST_SHIFT);

        final char[] expectedResult = {'M', 'y', ' ', 'w', 'i', 'l', 'd', ' ', 'l', 'o', 'v', 'e', ' ', 'i', 's', ' ',
                'r', 'i', 's', 'i', 'n', 'g'};
        Assert.assertArrayEquals(expectedResult, result);
    }

    @Test (timeout = 1000)
    public void testDecodeString() throws Exception {
        final String sourceString = "a##\"4#z4U uvu!u";
        final String result = Caesar.decodeString(sourceString, TEST_SHIFT);

        final String expectedResult = "Moon of Alabama";
        Assert.assertEquals(expectedResult, result);
    }

    @Test (timeout = 1000)
    public void testEncodeList() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("The Changeling");
        arrayList.add("Love Her Madly");
        arrayList.add("Been Down So Long");
        arrayList.add("Cars Hiss by My Window");
        arrayList.add("L.A. Woman");
        arrayList.add("L'America");
        arrayList.add("Hyacinth House");
        arrayList.add("Crawling King Snake");
        arrayList.add("The WASP (Texas Radio and the Big Beat)");
        arrayList.add("Riders on the Storm");

    }

    @Test (timeout = 1000)
    public void testEncodeListUsingDefaultShift() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

    }

    @Test (timeout = 1000)
    public void testDecodeList() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

    }

    @Test (timeout = 1000)
    public void testDecodeListUsingDefaultShift() throws Exception {
        ArrayList<String> arrayList = new ArrayList<>();

    }
}