package lesson1;

import java.io.PrintWriter;
import java.util.Scanner;

public class Z757 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        long c = in.nextLong();
        long h = in.nextLong();
        long o = in.nextLong();

        long[] spirit = new long[3];
        spirit[0] = c / 2;
        spirit[1] = h / 6;
        spirit[2] = o;

        long min = spirit[0];

        for (int i = 1; i < spirit.length; i++) {
            if (min > spirit[i]){
                min = spirit[i];
            }
        }

        out.println(min);
        out.flush();
    }

}