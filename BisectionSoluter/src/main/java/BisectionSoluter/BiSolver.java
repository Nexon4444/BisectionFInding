package BisectionSoluter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiSolver {

    static ArrayList<Double> coefs = new ArrayList<Double>();
    static Double k = 0.0;
    static Double l = 0.0;
    static Double esp = 0.0;
    static Integer max = 0;

//    static ArrayList<Double> coefs = new ArrayList<Double>(3);
//
//    static Double k = -6.5;
//    static Double l = 6.0;
//    static Double esp = 0.005;
//    static Integer max = 1000;

    public static void main(String[] args) {

//        System.out.println();
//        coefs.add(1.0);
//        coefs.add(-1.0);
//        coefs.add(-6.0);

        read();
        Collections.reverse(coefs);
        Result result = solve();
        if (result.isOverLimit())
            System.out.println("przekroczono maksymalna ilość iteracji, najbliższe znaleziony kandydat na miejsce zerowe to: " + result.getSolution());
        else
            System.out.println("znalezione miejsce zerowe to " + result.getSolution());
    }

    public static Double calcPolymonial(Double x) {

        Double result = 0.0;
        Integer pow = 0;

//        System.out.println(coefs.toString());
        for (Double el : coefs) {
//            System.out.println(el);
//            System.out.println("Math.pow(x, pow);" + Math.pow(x, pow));
            result = result + el * Math.pow(x, pow);
            pow++;
        }
        return result;
    }

    public static Result solve() {
        Double med = 0.0;
        for (int i = 0; i < max; i++) {
//            System.out.println("k - l: " + k + " - " + l);
            med = (l + k) / 2;
            System.out.println("med: " + med);
            System.out.println("Left: " + calcPolymonial(med)*calcPolymonial(k));
            System.out.println("Right: " + calcPolymonial(med)*calcPolymonial(l));
            if (calcPolymonial(med).equals(0.0) || Math.abs(l - k) < esp) return new Result(med, false);
            else if (calcPolymonial(med) * calcPolymonial(k) < 0) {
//                System.out.println("lewy");
                l = med;
            } else {
//                System.out.println("prawy");
                k = med;
            }

        }
        return new Result(med, true);
    }

    public static void read() {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Write polymonial coefficients in the form of Doubles for example for 3x^2+1 write 3.0 0.0 1.0");
        String poly = sc.nextLine();
        Scanner scPoly = new Scanner(poly);
        while (scPoly.hasNextDouble()) {
            coefs.add(sc.nextDouble());
        }
//        System.out.println("next: " + sc.nextLine());

        System.out.println("write the lower boundary in the form of a Double for example -2.0: ");
        k = Double.parseDouble(sc.nextLine());

        System.out.println("write the higher boundary in the form of a Double for example 2.5: ");
        l = Double.parseDouble(sc.nextLine());

        System.out.println("write the accuracy in the form of Double, for example for a solution in range of 0.005, write 0.005: ");
        esp = Double.parseDouble(sc.nextLine());

        System.out.println("write the max number of iterations in the form of an Integer, for example for 200 iterations write 200: ");
        max = Integer.parseInt(sc.nextLine());


    }
}
