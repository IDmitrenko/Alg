package lesson3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        MyStack<Integer> stack = new MyStack<>();
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(stack.pop());
//        }

//        Expression e = new Expression("(4+6)-[34+{x*4}]");
//        System.out.println(e.checkBracket());

//        MyQueue<Integer> queue = new MyQueue<>(5);
//        queue.insert(1);
//        queue.insert(2);
//        queue.insert(3);
//        System.out.println(queue);
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        queue.insert(11);
//        queue.insert(12);
//        queue.insert(13);
//        System.out.println(queue);

//        MyPriorityQueue<Integer> mpq = new MyPriorityQueue<>(10, Comparator.reverseOrder());
//        mpq.insert(7);
//        System.out.println(mpq);
//        mpq.insert(1);
//        System.out.println(mpq);
//        mpq.insert(9);
//        System.out.println(mpq);
//        mpq.insert(3);
//        System.out.println(mpq);
//        mpq.insert(4);
//        System.out.println(mpq);
//        mpq.insert(11);
//        System.out.println(mpq);
//
//        System.out.println(mpq.remove());
//        System.out.println(mpq.remove());
//        System.out.println(mpq.remove());
//


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
