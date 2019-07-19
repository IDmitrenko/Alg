package lesson2.homework2;

import java.io.PrintWriter;
import java.util.*;

/*
Условие
        В заданном наборе целых чисел найти сумму всех положительных элементов,
        затем найти где в заданной последовательности находятся максимальный и минимальный элемент
        и вычислить произведение чисел, расположенных в этой последовательности между ними.
        Так же известно, что минимальный и максимальный элемент встречаются
        в заданном множестве чисел только один раз и не являются соседними.
Входные данные
        В первой строке входного файла INPUT.TXT записано единственное число N – количество элементов массива.
        Вторая строка содержит N целых чисел, представляющих заданный массив. Все элементы массива разделены пробелом.
        Каждое из чисел во входном файле, в том числе и N, не превышает 100 по абсолютной величине.

Выходные данные
        В единственную строку выходного файла OUTPUT.TXT нужно вывести два числа, разделенных пробелом:
        сумму положительных элементов и произведение чисел,
        расположенных между минимальным и максимальным элементами.
        Значения суммы и произведения не превышают по модулю 30000.
*/
public class Z9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = 0;
        if (in.hasNextInt()) {
            a = in.nextInt();
        }
        in = new Scanner(System.in);

        String b = in.nextLine().trim();

        a = validation(a, true);

        Integer[] arr = new Integer[a];
        String[] arrS = new String[a];
        String[] arrSE = b.split(" ", a);
        for (int i = 0; i < arrSE.length; i++) {
            arrS[i] = arrSE[i];
        }
        int sumPositive = 0;
        int mulInterval = 1;
        int positionMin = 0;
        int positionMax = 0;
        int minValue;
        int maxValue;
        int maxMulValue = 30000;
        int temp = 0;
        int oldPos = 0;

        for (int i = 0; i < a; i++) {
            if ((arrS[i] == null) || !isNumeric(arrS[i]))
                arrS[i] = String.valueOf(Math.round(Math.random()*100));
            arr[i] = validation(Integer.parseInt(arrS[i]), false);
            if (arr[i] > 0)
                sumPositive += arr[i];
        }
        Map<Integer, Integer> unique = new HashMap<>();
        Integer count;
        for (int i = 0; i < a; i++) {
            count = unique.get(arr[i]);
            if (count == null) {
                unique.put(arr[i], 1);
            } else {
                unique.put(arr[i], ++count);
            }
        }

        List<Integer> uniqEl = new ArrayList<>();
        for (Map.Entry<Integer, Integer> element : unique.entrySet()) {
            if (element.getValue().equals(1))
                uniqEl.add(element.getKey());
        }

        boolean isBegin = false;
        maxValue = arr[0];
        minValue = arr[0];
        for (int i = 0; i < a; i++) {
            if (arr[i] > maxValue && uniqEl.contains(arr[i])
                    && (!isBegin || (Math.abs(i - positionMin) > 1))) {
                maxValue = arr[i];
                positionMax = i;
                isBegin = true;
            } else if (arr[i] < minValue && uniqEl.contains(arr[i])
                    && (!isBegin || (Math.abs(i - positionMax) > 1))) {
                minValue = arr[i];
                positionMin = i;
                isBegin = true;
            }
        }

        if (Math.abs(positionMax - positionMin) < 2) {
            oldPos = positionMin;
            temp = minValue;
            positionMin = -1;
            minValue = 100;
            for (int i = 0; i < a; i++) {
                if (arr[i] < minValue && uniqEl.contains(arr[i])
                        && (oldPos != i) && (Math.abs(i - positionMax) > 1)) {
                    minValue = arr[i];
                    positionMin = i;
                }
            }
        }

        if ((positionMin == -1) || (Math.abs(positionMax - positionMin) < 2)) {
            positionMin = oldPos;
            minValue = temp;
            oldPos = positionMax;
            temp = maxValue;
            positionMax = -1;
            maxValue = -100;
            for (int i = 0; i < a; i++) {
                if (arr[i] > maxValue && uniqEl.contains(arr[i])
                        && (oldPos != i) && (Math.abs(i - positionMin) > 1)) {
                    maxValue = arr[i];
                    positionMax = i;
                }
            }
        }

        if (positionMax < positionMin) {
            temp = positionMax;
            positionMax = positionMin;
            positionMin = temp;
        }

        for (int i = (positionMin + 1); i < positionMax; i++) {
            temp = mulInterval;
            mulInterval *= arr[i];
            if (Math.abs(mulInterval) > maxMulValue) {
                mulInterval = temp;
                break;
            }
        }

        out.println(sumPositive + " " + mulInterval);

        out.flush();
    }

    private static int validation(int number, boolean isOption) {
        if (Math.abs(number) > 100)
            return 100;
        if (isOption) {
            number = Math.abs(number);
            if (number < 3)
                number = 3;
        }
        return number;
    }

    private static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }
}
