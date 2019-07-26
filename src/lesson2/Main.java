package lesson2;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        MyArrayList<Integer> mal = new MyArrayList();
////
//        mal.add(5);
//        mal.add(6);
//        mal.add(7);
//        mal.add(2,88);
//        System.out.println(mal);
////
////        mal.remove(5);
////        System.out.println(mal);
////
//        System.out.println(mal.find(5));

//        MySortedArrayList<Integer> sortedAl = new MySortedArrayList();
//        sortedAl.add(7);
//        sortedAl.add(1);
//        sortedAl.add(2);
//        sortedAl.add(9);
//        sortedAl.add(7);
//
//        System.out.println(sortedAl);
//        System.out.println(sortedAl.binaryFind(79));

        MyArrayList<Integer> mal = new MyArrayList(20);

        for (int i = 0; i < 10; i++) {
            mal.add((int) (Math.random() * 10000));
        }
        System.out.println(mal);

        long beginTime = System.currentTimeMillis();

//        mal.selectionSort();
//        mal.insertionSort();
//        mal.bubbleSort(Comparator.reverseOrder());
        mal.quickSort();
        System.out.println(System.currentTimeMillis() - beginTime);

        System.out.println(mal);


    }
}
