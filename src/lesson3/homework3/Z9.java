package lesson3.homework3;

import java.io.PrintWriter;
import java.util.*;

public class Z9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a;
        a = in.nextInt();
        in = new Scanner(System.in);

        String b = in.nextLine().trim();

        Integer[] arr = new Integer[a];
        String[] arrS = b.split(" ", a);
        int sumPositive = 0;
        int mulInterval = 1;
        int positionMin = 0;
        int positionMax = 0;
        int minValue = 100;
        int maxValue = -100;
        int maxMulValue = 30000;
        int temp;

        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(arrS[i]);
            if (arr[i] > 0)
                sumPositive += arr[i];
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                positionMax = i;
            }
            if (arr[i] < minValue) {
                minValue = arr[i];
                positionMin = i;
            }
        }

        if (positionMax < positionMin) {
            temp = positionMax;
            positionMax = positionMin;
            positionMin = temp;
        }

        for (int i = (positionMin + 1); i < positionMax; i++) {
            mulInterval *= arr[i];
        }

        if (Math.abs(mulInterval) > maxMulValue) {
            mulInterval = maxMulValue;
        }
        if (Math.abs(sumPositive) > maxMulValue) {
            sumPositive = maxMulValue;
        }
        out.println(sumPositive + " " + mulInterval);

        out.flush();
    }

}
