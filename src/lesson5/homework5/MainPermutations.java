package lesson5.homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainPermutations {
    public static void main(String[] args) {
        List<BackPack.Box> boxes = new ArrayList<>();
        boxes.add(new BackPack.Box(2, 1));
        boxes.add(new BackPack.Box(24, 76));
        boxes.add(new BackPack.Box(35, 23));
        boxes.add(new BackPack.Box(11, 12));
        boxes.add(new BackPack.Box(14, 8));
        boxes.add(new BackPack.Box(12, 7));
        boxes.add(new BackPack.Box(14, 12));
        boxes.add(new BackPack.Box(25, 32));
        List<BackPack.Box> solve = BackPack.solve(boxes, new ArrayList<>(), 86);
        System.out.println(solve);
        System.out.println(solve.stream().map(b -> b.getPrice()).reduce((p1, p2) -> p1 + p2).get());
        System.out.println(solve.stream().map(b -> b.getWeight()).reduce((p1, p2) -> p1 + p2).get());
//        Integer[] arr = new Integer[]{1, 2, 3, 4};
//        for (int start = 0; start < arr.length; start++) {
//            for (int end = 1; end <= arr.length; end++) {
//                if (start < end) {
//                    Integer[] subArr = subArr(arr, start, end);
//                    permutations(subArr, 0, subArr.length - 1);
//                }
//            }
//        }
    }

    private static Integer[] subArr(Integer[] arr, int start, int end) {
        Integer res[] = new Integer[end - start];
        System.arraycopy(arr, start, res, 0, end - start);
        return res;
    }

    private static void permutations(Integer[] numbers, int l, int r) {
        if (l == r) {
            //check if exist
            System.out.println(Arrays.toString(numbers));
        } else {
            for (int i = l; i <= r; i++) {
                numbers = swap(numbers, l, i);
                permutations(numbers, l + 1, r);
                numbers = swap(numbers, l, i);
            }
        }
    }

    private static Integer[] swap(Integer[] arr, int l, int r) {
        Integer[] newArr = new Integer[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        int tmp = newArr[l];
        newArr[l] = newArr[r];
        newArr[r] = tmp;
        return newArr;
    }
}
