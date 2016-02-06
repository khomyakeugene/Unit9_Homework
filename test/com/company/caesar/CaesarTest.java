package com.company.caesar;

import com.company.flowers.*;
import com.company.utils.TestUtil;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Yevgen on 05.02.2016 as a part of the project "Unit9_Homework".
 */
public class CaesarTest {
    public final static String RED_COLOUR = "Red";
    public final static String WHITE_COLOUR = "White";
    public final static String ROSE_COLOUR = "Rose";
    public final static String YELLOW_COLOUR = "Yellow";

    public final static int TEST_SHIFT = 20;

    private static Bouquet bouquetForEncode;
    private static Bouquet bouquetForDefaultDecode;
    private static Bouquet bouquetForDecode;

    @BeforeClass
    public static void setUpClass() throws Exception {
        bouquetForEncode = new Bouquet(new Aster(RED_COLOUR));
        bouquetForEncode.addFlower(new Aster(WHITE_COLOUR));
        bouquetForEncode.addFlower(new Tulip(RED_COLOUR));
        bouquetForEncode.addFlower(new Tulip(ROSE_COLOUR));
        bouquetForEncode.addFlower(new Chamomile(WHITE_COLOUR));
        bouquetForEncode.addFlower(new Chamomile(WHITE_COLOUR));
        bouquetForEncode.addFlower(new Chamomile(YELLOW_COLOUR));
        bouquetForEncode.addFlower(new Rose(ROSE_COLOUR));
        bouquetForEncode.addFlower(new Rose(RED_COLOUR, Rose.TYPICAL_ROSE_SCENT, true));

        bouquetForDecode = new Bouquet(new Tulip(ROSE_COLOUR));
        bouquetForDecode.addFlower(new Tulip(WHITE_COLOUR));
        bouquetForDecode.addFlower(new Tulip(ROSE_COLOUR));
        bouquetForDecode.addFlower(new Chamomile(WHITE_COLOUR));
        bouquetForDecode.addFlower(new Aster(YELLOW_COLOUR));

        bouquetForDefaultDecode = new Bouquet(new Aster(ROSE_COLOUR));
        bouquetForDefaultDecode.addFlower(new Tulip(WHITE_COLOUR));
        bouquetForDefaultDecode.addFlower(new Tulip(ROSE_COLOUR));
        bouquetForDefaultDecode.addFlower(new Chamomile(WHITE_COLOUR));
        bouquetForDefaultDecode.addFlower(new Chamomile(YELLOW_COLOUR));
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
                {'a', '-', '4', '+', '}', ' ', 'x', '4', ' ', '#', '*', 'y'};
        final char[] result = Caesar.decodeChars(sourceChars, TEST_SHIFT);

        final char[] expectedResult = {'M', 'y', ' ', 'w', 'i', 'l', 'd', ' ', 'l', 'o', 'v', 'e'};
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
        ArrayList<String> result = Caesar.encodeList(bouquetForEncode.getFlowers(), TEST_SHIFT);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("z #+y&N4U'(y&@4w# #)&N4fyx@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4U'(y&@4w# #)&N4k|}(y@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4h) }$@4w# #)&N4fyx@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4h) }$@4w# #)&N4f#'y@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4W|u!#!} y@4w# #)&N4k|}(y@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4W|u!#!} y@4w# #)&N4k|}(y@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4W|u!#!} y@4w# #)&N4my  #+@4'wy\"(N4+}(|#)(4'wy\"(");
        expected.add("z #+y&N4f#'y@4w# #)&N4f#'y@4'wy\"(N4h-$}wu 4&#'y4'wy\"(@4(|#&\"'4$&y'y\"(N4zu 'y");
        expected.add("z #+y&N4f#'y@4w# #)&N4fyx@4'wy\"(N4h-$}wu 4&#'y4'wy\"(@4(|#&\"'4$&y'y\"(N4(&)y");

        TestUtil.assertArrayListEquals(expected, result);
    }

    @Test (timeout = 1000)
    public void testEncodeListUsingDefaultShift() throws Exception {
        ArrayList<String> result = Caesar.encodeListUsingDefaultShift(bouquetForEncode.getFlowers());

        ArrayList<String> expected = new ArrayList<>();
        expected.add("pvy!o|D*K}~o|6*myvy|D*\\on6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*K}~o|6*myvy|D*ars~o6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*^vsz6*myvy|D*\\on6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*^vsz6*myvy|D*\\y}o6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*Mrkwywsvo6*myvy|D*ars~o6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*Mrkwywsvo6*myvy|D*ars~o6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*Mrkwywsvo6*myvy|D*covvy!6*}mox~D*!s~ry~*}mox~");
        expected.add("pvy!o|D*\\y}o6*myvy|D*\\y}o6*}mox~D*^#zsmkv*|y}o*}mox~6*~ry|x}*z|o}ox~D*pkv}o");
        expected.add("pvy!o|D*\\y}o6*myvy|D*\\on6*}mox~D*^#zsmkv*|y}o*}mox~6*~ry|x}*z|o}ox~D*~|o");

        TestUtil.assertArrayListEquals(expected, result);
    }

    @Test (timeout = 1000)
    public void testDecodeList() throws Exception {
        ArrayList<String> source = Caesar.encodeList(bouquetForDecode.getFlowers(), TEST_SHIFT);
        ArrayList<String> result = Caesar.decodeList(source, TEST_SHIFT);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("flower: Tulip, colour: Rose, scent: without scent");
        expected.add("flower: Tulip, colour: White, scent: without scent");
        expected.add("flower: Tulip, colour: Rose, scent: without scent");
        expected.add("flower: Chamomile, colour: White, scent: without scent");
        expected.add("flower: Aster, colour: Yellow, scent: without scent");

        TestUtil.assertArrayListEquals(expected, result);
    }

    @Test (timeout = 1000)
    public void testDecodeListUsingDefaultShift() throws Exception {
        ArrayList<String> source = Caesar.encodeListUsingDefaultShift(bouquetForDefaultDecode.getFlowers());
        ArrayList<String> result = Caesar.decodeListUsingDefaultShift(source);

        ArrayList<String> expected = new ArrayList<>();
        expected.add("flower: Aster, colour: Rose, scent: without scent");
        expected.add("flower: Tulip, colour: White, scent: without scent");
        expected.add("flower: Tulip, colour: Rose, scent: without scent");
        expected.add("flower: Chamomile, colour: White, scent: without scent");
        expected.add("flower: Chamomile, colour: Yellow, scent: without scent");

        TestUtil.assertArrayListEquals(expected, result);
    }
}