package lesson2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        int[] array = new int[10];
//        String[] stringArray;
//        stringArray = new String[10];
//
//        int[] b = {4, 5, 2, 66, 8};
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 != 0) {
//                array[i] *= 2;
//            }
//        }


//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }

//        System.out.println(Arrays.toString(array));

//        for (int element:array) {
//            System.out.print(element+" ");
//        }

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(16);
        list.add(31);
        list.add(17);
        list.add(1);
        System.out.println(list);
        list.set(1,45);
        System.out.println(list);
//        list.remove(3);
//        System.out.println(list);
//        list.remove((Integer) 45);
//        System.out.println(list);
//        list.sort(Comparator.naturalOrder());
//        list.sort(Comparator.reverseOrder());
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
//        list.sort((x,y)-> x%10-y%10);

        System.out.println(list);

    }
}
