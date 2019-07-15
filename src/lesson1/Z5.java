package lesson1;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Z5 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n;
        try {n = in.nextInt();
        } catch (InputMismatchException ex) {
            n = 1;
        }

        if (n < 1) {
            n = 1;
        }
        if (n > 1000) {
            n = 1000;
        }
        int sumNumber = n + 1;

        for (int i = (n - 1); i > 1; i--) {
            if ((n % i) == 0)
                sumNumber += i;
        }

        out.println(sumNumber);

        out.flush();
    }
}
