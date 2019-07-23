package lesson3.homework3;

import java.util.Comparator;

public class MainPriorityQueue {
    public static void main(String[] args) {
        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(10, Comparator.reverseOrder());
        mpq.insert(7);
        System.out.println(mpq);
        mpq.insert(1);
        System.out.println(mpq);
        mpq.insert(9);
        System.out.println(mpq);
        mpq.insert(3);
        System.out.println(mpq);
        mpq.insert(4);
        System.out.println(mpq);
        mpq.insert(11);
        System.out.println(mpq);

        System.out.println(mpq.remove());
        System.out.println(mpq.remove());
        System.out.println(mpq.remove());

        MyPriorityQueue<String> mpqS =
//                new MyPriorityQueue<>(10,String.CASE_INSENSITIVE_ORDER);
                new MyPriorityQueue<>(10, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return ((String)o1).length() - ((String)o2).length() ;
                    }
                });
        mpqS.insert("A");
        mpqS.insert("a");
        mpqS.insert("bb");
        mpqS.insert("CCC");
        mpqS.insert("abc");
        mpqS.insert("x");
        mpqS.insert("tt");
        mpqS.insert("X");
        System.out.println(mpqS);

    }
}
