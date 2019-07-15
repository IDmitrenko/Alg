package lesson1;

import java.io.*;
import java.util.*;

public class Z1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        out.println(Math.max(c, Math.max(a, b)) - Math.min(c, Math.min(a, b)));

        out.flush();
    }
}
