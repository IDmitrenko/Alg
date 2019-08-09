package lesson8.homework8;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Одной из классических NP-полных задач является так называемая «Задача о рюкзаке».
 * Формулируется она следующим образом.
 * Дано n предметов, каждый из которых характеризуется весом wi и полезностью pi.
 * Необходимо выбрать некоторый набор этих предметов так,
 * чтобы суммарный вес этого набора не превышал W, а суммарная полезность была максимальна.
 * <p>
 * Ваша задача состоит в том, чтобы написать программу, решающую задачу о рюкзаке.
 * <p>
 * Входные данные
 * Первая строка входного файла INPUT.TXT содержит натуральные числа n (1 ≤ n ≤ 20) и W (1 ≤ W ≤ 109).
 * Каждая из последующих n строк содержит описание одного предмета.
 * Каждое описание состоит из двух чисел: wi – веса предмета и pi – его полезности (1 ≤ wi, pi ≤ 109).
 * <p>
 * Выходные данные
 * В первой строке выходного файла OUTPUT.TXT выведите количество выбранных предметов и их суммарную полезность.
 * Во второй строке выведите через пробел их номера в возрастающем порядке
 * (предметы нумеруются с единицы в порядке, в котором они перечислены во входном файле).
 * <p>
 * Если искомых наборов несколько, выберите тот, в котором наименьшее число предметов.
 * Если же после этого ответ по-прежнему неоднозначен, выберите тот набор,
 * в котором первый предмет имеет наименьший возможный номер, из всех таких выберите тот,
 * в котором второй предмет имеет наименьший возможный номер, и т.д.
 */
// Задача о рюкзаке (метод динамического программирования)
public class BackPack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String[] s = in.nextLine().split(" ");
        int number = Integer.valueOf(s[0]);
        int capacity = Integer.valueOf(s[1]);

        List<Box> cb = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            s = in.nextLine().split(" ");
            Box box = new Box(Integer.valueOf(s[0]), Integer.valueOf(s[1]), i + 1);
            cb.add(box);
        }
        List<Box> result = solve(cb, new ArrayList<>(), capacity);
        out.println(result.size() + " " + result.stream().map(b -> b.getPrice()).reduce((p1, p2) -> p1 + p2).get());
        result.stream().map(b -> b.getPosition()).sorted().forEach(e -> {
            out.printf(e + " ");
        });
        out.flush();
//        System.out.println(result);
//        System.out.println(result.stream().map(b -> b.getPrice()).reduce((p1, p2) -> p1 + p2).get());
//        System.out.println(result.stream().map(b -> b.getWeight()).reduce((p1, p2) -> p1 + p2).get());

    }

    /**
     * boxes - список рассматриваемых коробок
     * takeList - список подходящих коробок
     * capacity - остаточная вместимость
     */
    public static List<Box> solve(List<Box> boxes, List<Box> takeList, int capacity) {
        if (boxes.size() == 1) {
            if (boxes.get(0).weight <= capacity) {
                return addToList(takeList, boxes.get(0));
            } else {
                return takeList;
            }
        } else {
            Box first = boxes.get(0);
            if (first.weight <= capacity) {
                //коробку не  берем
                List<Box> doNotTake = solve(boxes.subList(1, boxes.size()), takeList, capacity);
                //берем коробку, уменьшаем емкость
                List<Box> take = solve(boxes.subList(1, boxes.size()), addToList(takeList, first), capacity - first.weight);

                return checkMaximum(take, doNotTake);
            } else {
                //исключаем коробку (не подходит)
                return solve(boxes.subList(1, boxes.size()), takeList, capacity);
            }
        }
    }

    private static List<Box> addToList(List<Box> old, Box item) {
        List<Box> newList = new ArrayList<>(old);
        newList.add(item);
        return newList;
    }

    private static List<Box> checkMaximum(List<Box> take, List<Box> doNotTake) {
        int takePrice = 0;
        int doNotTakePrice = 0;
        for (Box box : take) {
            takePrice += box.price;
        }
        for (Box box : doNotTake) {
            doNotTakePrice += box.price;
        }
        if (takePrice > doNotTakePrice) {
            return take;
        } else if (takePrice < doNotTakePrice) {
            return doNotTake;
        } else {
            if (take.size() < doNotTake.size()) {
                return take;
            } else if (doNotTake.size() < take.size()) {
                return doNotTake;
            } else {
                for (int i = 0; i < take.size(); i++) {
                    if (take.get(i).getPosition() < doNotTake.get(i).getPosition()) {
                        return take;
                    }
                    if (doNotTake.get(i).getPosition() < take.get(i).getPosition()) {
                        return doNotTake;
                    }
                }
                return take;
            }
        }

    }

    public static class Box {
        private int weight;
        private int price;
        private int position;

        public Box(int weight, int price, int position) {
            this.weight = weight;
            this.price = price;
            this.position = position;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "position=" + position +
                    ", weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}