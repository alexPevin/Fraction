package main;

import model.Fraction;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //new Fraction(1, 0);

        String a = "";
        String[] s = a.split(" ");
        System.out.println(Arrays.toString(s));
        Fraction one = new Fraction(2, 6);
        Fraction two = new Fraction(6, 7);
        Fraction three = new Fraction(9, 8);
        Fraction four = new Fraction(4, 5);
        Fraction five = new Fraction(1, 11);
        Fraction six = new Fraction(2, 3);
        Fraction[] fractions = new Fraction[]{null, null, one, null,  two, three, four, five, six};

        System.out.println(Arrays.toString(fractions));
        /*Fraction fraction = Fraction.maxFraction(fractions);
        System.out.println(fraction);*/

        /*Arrays.sort(fractions, Collections.reverseOrder());
        System.out.println(Arrays.toString(fractions));*/

        /*Fraction division = six.division(one);
        System.out.println(division);*/

        /*Fraction fraction = Fraction.maxFraction(fractions);
        System.out.println(fraction);*/
/*
        Fraction sum = Fraction.sum(fractions);
        System.out.println(sum);*/

        Arrays.sort(fractions, Fraction::compare);
        System.out.println(Arrays.toString(fractions));
    }
}