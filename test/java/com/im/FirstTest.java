package com.im;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.function.Executable;
import org.junit.runners.Parameterized;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest {

    static First first;

    @BeforeAll
    static void creationFirstClassObject() {
        first = new First();
    }

    @Test
    void shouldReturnNewStringWhenSubstringFound() {
        //given
        String mainString = "This is to the new";
        String subString = "to the new";
        String replacedString = "Harsh Yadav";
        String expectedString = "this is Harsh Yadav";

        //when
        String calculateString = first.replaceSubString(mainString, subString, replacedString);

        //then
        assertEquals(expectedString, calculateString);
    }

    @Test
    void shouldReturnOriginalStringWhenSubstringNotFound() {
        //given
        String mainString = "this is Harsh Yadav";
        String subString = "Yadav";
        String replacedString = "to the new";
        String expectedString = "this is Harsh savage";

        //when
        String calculateString = first.replaceSubString(mainString, subString, replacedString);

        //then
        assertEquals(expectedString, calculateString);

    }

    @Test
    void shouldReturnOddElementOnlyWhenOddElementExistAfterFilterEvenElement() {
        //given
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            list.add(i);
        }
        List<Integer> expectedlist = new ArrayList<>();
        expectedlist.add(1);
        expectedlist.add(3);
        expectedlist.add(5);

        //when
        List calculatelist = first.filterEvenElements(list);

        //then
        assertEquals(expectedlist, calculatelist);

    }

    @Test
    void shouldThrowExceptionInvalidInputWhenListNotExist() {
        //given
        List<BigDecimal> list = null;
        //List<BigDecimal> list=new ArrayList<>();

        //when
        try {
            first.calculateAverage(list);
        }

        //then
        catch (RuntimeException e) {
            System.out.println(e);

        }
    }

    @Test
    void shouldThrowExceptionInvalidInputWhenListIsEmpty() {
        //given
        List<BigDecimal> list = new ArrayList<>();

        //when
        try {
            first.calculateAverage(list);
        }

        //then
        catch (RuntimeException r) {
            System.out.println(r);

        }
    }

    @Test
    void shouldReturnAveragevalueWhenListContainsElement() {

        //given
        List<BigDecimal> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new BigDecimal(1212121));
            list.add(new BigDecimal(1212121));
            list.add(new BigDecimal(1212121));
            list.add(new BigDecimal(1212121));
        }
        BigDecimal expectedAverage = new BigDecimal(1212121);

        //when
        BigDecimal calculateAverage = first.calculateAverage(list);

        //then
        assertEquals(expectedAverage, calculateAverage);
    }

    @Test
    void shouldReturnTrueWhenStringIspalindrome() {
        //given
        String originalinput = "ababa";

        //when
        boolean palindromecheck = first.isPallindrome(originalinput);

        //then
        assertFalse(palindromecheck);

    }
}
