package lesson4.homework4;

import java.util.Iterator;

public class MainDoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedList<String> mldl = new MyDoubleLinkedList<>();

        mldl.insertFirst("Maria");
        mldl.insertFirst("Ivan");
        mldl.insertFirst("Petya");
        mldl.insertFirst("Sasha");

        System.out.println(mldl.getFirst());
        System.out.println(mldl.removeFirst());
        System.out.println(mldl.removeFirst());
        System.out.println(mldl.getFirst());
        System.out.println(mldl);
        System.out.println(mldl.remove("Maria"));
        mldl.insert(99,"Fedor");
        System.out.println(mldl);
        mldl.insertLast("Katia");
        System.out.println(mldl);
        System.out.println(mldl.remove("Fedor"));
        System.out.println(mldl);
        mldl.insert(1,"Misha");
        System.out.println(mldl);

        Iterator<String> iterator = mldl.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }

        System.out.println();

        for (String s : mldl ) {
            System.out.print(s+"; ");
        }
    }
}
