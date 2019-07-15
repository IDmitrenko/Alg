package lesson1;

import java.io.*;
import java.util.*;

public class Z2{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x = in.nextInt();
        int y = in.nextInt();
        int z = in.nextInt();

        out.println(((x + y - z) >= 0) ? (x + y - z) : "Impossible");

        out.flush();
    }
}