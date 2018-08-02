package BisectionSoluter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiSolver {

//    static ArrayList<Double> coefs = new ArrayList<Double>();
//    static Double k = 0.0;
//    static Double l = 0.0;
//    static Double esp = 0.0;
//    static Integer max = 0;

    static ArrayList<Double> coefs = new ArrayList<Double>(3);

    static Double k = -0.5;
    static Double l = 6.0;
    static Double esp = 0.05;
    static Integer max = 1000;

    public static void main(String[] args) {

//        System.out.println();
        coefs.add(1.0);
        coefs.add(-1.0);
        coefs.add(-6.0);

//        read();
        Collections.reverse(coefs);
        Result result = solve();
        if (result.isOverLimit())
            System.out.println("przekroczono maksymalną ilość iteracji, najbliższy wynik to: " + result.getSolution());
        else
            System.out.println("wynik to " + result.getSolution());
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
//            System.out.println("med: " + med);
//            System.out.println("Left: " + calcPolymonial(med)*calcPolymonial(k));
//            System.out.println("Right: " + calcPolymonial(med)*calcPolymonial(l));
            if (calcPolymonial(med).equals(0.0) || Math.abs(l - k) <esp) return new Result(med,false);
            else if (calcPolymonial(med) * calcPolymonial(k) < 0)
            {
//                System.out.println("lewy");
                l = med;
            }
            else
            {
//                System.out.println("prawy");
                k = med;
            }

        }
        return new Result(med,true);
    }

    public static void read() {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Write polymonial coefficients in the form of only numbers for example for 3x^2+1 write 3.0 0.0 1.0");
        String polymonial = sc.nextLine();
        Scanner scPoly = new Scanner(polymonial);
        while (scPoly.hasNextDouble()) {
            coefs.add(scPoly.nextDouble());
        }


        System.out.println("write the boudaries in the form of only numbers for example -2.0 2.5");
        String boundaries = sc.nextLine();
        Scanner scBound = new Scanner(boundaries);
        if (scBound.hasNextDouble())
            k = scBound.nextDouble();
        if (scBound.hasNextDouble())
            l = scBound.nextDouble();

        System.out.println("write the accuracy, for example for a solution in range of 0.005, write 0.005");
        String strEsp = sc.nextLine();
        Scanner scEsp = new Scanner(strEsp);
        if (scEsp.hasNextDouble())
            esp = sc.nextDouble();


        System.out.println("write the max number of iterations, for example for 200 iterations write 200");
//        String strMax = sc.nextLine();
//        Scanner scMax = new Scanner(strMax);
//        if (scMax.hasNextDouble())
//            max = sc.nextInt();

//        String strMax = sc.nextLine();
//        Scanner scMax = new Scanner(strMax);
        if (sc.hasNextInt())
            max = sc.nextInt();


    }
}
