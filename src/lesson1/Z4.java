package lesson1;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Z4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int r1;
        int r2;
        int r3;
        try {r1 = in.nextInt();
        } catch (InputMismatchException ex) {
            r1 = 1;
            in = new Scanner(System.in);
        }
        try {r2 = in.nextInt();
        } catch (InputMismatchException ex) {
            r2 = 1;
            in = new Scanner(System.in);
        }
        try {r3 = in.nextInt();
        } catch (InputMismatchException ex) {
            r3 = 1;
        }

        if (r1 < 1)
            r1 = 1;
        if (r1 > 1000000000)
            r1 = 1000000000;
        if (r2 < 1)
            r2 = 1;
        if (r2 > 1000000000)
            r2 = 1000000000;
        if (r3 < 1)
            r3 = 1;
        if (r3 > 1000000000)
            r3 = 1000000000;


        out.println(((r1 - r2 - r3) >= 0) ? "YES" : "NO");

        out.flush();
    }
}
