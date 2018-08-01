import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BiSolver {

    static ArrayList<Double> coefs = new ArrayList<Double>();
    static Double k = new Double(0);
    static Double l = new Double(0);
    static Double esp = new Double(0);
    static Integer max = new Integer(0);

    public static void main(String[] args) {
//        System.out.println();
        Double result = new Double(0);
        read();
        System.out.println("obliczony: " + calcPolymonial(2.0));
        result = solve();
        if (result == null)
            System.out.println("przekroczono maksymalną ilość iteracji");
        else
            System.out.println("wynik to " + result);
    }

    public static Double calcPolymonial(Double x) {
        Double result = 0.0;
        int pow = 0;
        Collections.reverse(coefs);
        for (var el : coefs) {
            result =+ el * Math.pow(x, pow);
            pow++;
        }
        return result;
    }

    public static Double solve() {
        Double med = (l - k) / 2;
        for (int i = 0; i < max; i++) {
            if (med < esp) return med;

        }
        return null;
    }

    public static void read() {
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Write polymonial coefficients in the form of only numbers for example for 3x^2+1 write 3 0 1");
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
        String strMax = sc.nextLine();
        Scanner scMax = new Scanner(strMax);
        if (scMax.hasNextInt())
            max = sc.nextInt();


    }
}
