package lesson3.homework3;

public class MainDeque {
    public static void main(String[] args) {
        MyDeque<String> deque = new MyDeque<>(5);
        int j;

        deque.insertLeft("с");
        deque.insertLeft("о");
        deque.insertLeft("Р");
        System.out.println(deque);
        System.out.println("Размерность массива - " + deque.capacity());

        deque.insertRight("с");
        deque.insertRight("и");
        deque.insertRight("я");
        System.out.println(deque);
        System.out.println("Размерность массива - " + deque.capacity());

        System.out.println("Значение слева = " + deque.peekLeft());
        System.out.println("Значение справа = " + deque.peekRight());

        deque.insertRight(" ");
        deque.insertRight("в");
        deque.insertRight("е");
        deque.insertRight("л");
        deque.insertRight("и");
        deque.insertRight("к");
        deque.insertRight("а");
        deque.insertRight("я");
        deque.insertRight("!");
        System.out.println(deque);
        System.out.println("Размерность массива - " + deque.capacity());

        deque.insertRight("U");
        deque.insertRight("R");
        deque.insertLeft("A");
        System.out.println(deque);
        System.out.println("Размерность массива - " + deque.capacity());

        deque.removeLeft();
        deque.removeRight();
        deque.removeRight();
        System.out.println(deque);
        System.out.println("Размерность массива - " + deque.capacity());
    }
}
