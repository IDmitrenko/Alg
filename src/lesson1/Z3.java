package lesson1;

import java.io.PrintWriter;
import java.util.Scanner;

public class Z3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        if (n < 1)
            n = 1;
        if (n > 100)
            n = 100;
        int x;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            x = in.nextInt();
            if (x == 1) {
                a++;
            } else {
                b++;
            }
        }

        out.println(Math.min(a, b));

        out.flush();
    }
}
