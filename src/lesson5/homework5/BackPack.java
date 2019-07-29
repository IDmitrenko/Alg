package lesson5.homework5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Задача о рюкзаке (метод динамического программирования)
public class BackPack {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src\\lesson5\\homework5\\Input.txt")))) {
            String[] input = br.readLine().split(" ");
            int number = Integer.valueOf(input[0]);
            int capacity = Integer.valueOf(input[1]);

            List<Box> cb = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                input = br.readLine().split(" ");
                Box box = new Box(Integer.valueOf(input[0]), Integer.valueOf(input[1]));
                cb.add(box);
            }
            List<Box> result = solve(cb, new ArrayList<>(), capacity);
            System.out.println(result);
            System.out.println(result.stream().map(b -> b.getPrice()).reduce((p1, p2) -> p1 + p2).get());
            System.out.println(result.stream().map(b -> b.getWeight()).reduce((p1, p2) -> p1 + p2).get());

        } catch (IOException ex) {
            System.out.println("Не найден файл входных данных Input.txt");
        }


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
        } else {
            return doNotTake;
        }

    }

    public static class Box {
        private int weight;
        private int price;

        public Box(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "weight=" + weight +
                    ", price=" + price +
                    '}';
        }
    }
}
