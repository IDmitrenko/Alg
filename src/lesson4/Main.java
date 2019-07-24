package lesson4;

import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyDoubleLinkedList<String> mll = new MyDoubleLinkedList<>();

        mll.insertFirst("Maria");
        mll.insertFirst("Ivan");
        mll.insertFirst("Petya");
        mll.insertFirst("Sasha");

//        System.out.println(mll.getFirst());
//        System.out.println(mll.removeFirst());
//        System.out.println(mll.removeFirst());
//        System.out.println(mll.getFirst());
        System.out.println(mll);
//        System.out.println(mll.remove("Maria"));
        mll.insert(99,"Fedor");
        System.out.println(mll);
        mll.insertLast("Katia");
        System.out.println(mll);
        System.out.println(mll.remove("Fedor"));
        System.out.println(mll);
        mll.insert(1,"Misha");
        System.out.println(mll);

//        Iterator<String> iterator = mll.iterator();
//        while(iterator.hasNext()){
//            System.out.print(iterator.next() + ", ");
//        }

        for (String s:mll ) {
            System.out.print(s+"; ");
        }


    }
}
