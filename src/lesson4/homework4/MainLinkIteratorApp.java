package lesson4.homework4;

import java.util.ListIterator;

public class MainLinkIteratorApp {
    public static void main(String[] args) {
        MyDoubleLinkedList<String> mldl = new MyDoubleLinkedList<>();

        mldl.insertFirst("Maria");
        mldl.insertFirst("Ivan");
        mldl.insertFirst("Petya");
        mldl.insertFirst("Sasha");
        mldl.insert(99,"Fedor");
        mldl.insertLast("Katia");
        mldl.insert(1,"Misha");
        for (String s : mldl ) {
            System.out.print(s+"; ");
        }
        System.out.println();

        int currentIndex;
        ListIterator<String> iterator = mldl.iterator();
        while(iterator.hasNext()){
            if (iterator.next() == "Petya") {
                iterator.set("Petro");
                System.out.println(mldl);
                if (iterator.hasPrevious()) {
                    System.out.println(iterator.previous());
                }
                System.out.println(iterator.nextIndex());
                currentIndex = iterator.previousIndex();
                System.out.println(currentIndex);
                iterator.add("Olga");
                System.out.println(mldl);
            }
            if (iterator.next() == "Maria") {
                iterator.remove();
                System.out.println(mldl);
            }
        }
    }
}
