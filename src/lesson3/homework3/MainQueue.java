package lesson3.homework3;

public class MainQueue {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>(5);
        int j;

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

        for (int i = 0; i < 3; i++) {
            queue.insert(i + 4);

        }
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

        for (int i = 0; i < 15; i++) {
            queue.insert(i + 15);
        }
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

        j = queue.size();
        for (int i = 0; i < j; i++) {
            queue.remove();
        }
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

        for (int i = 0; i < 3; i++) {
            queue.insert(i + 25);
        }
        j = queue.size();
        for (int i = 0; i < j; i++) {
            System.out.println(queue.peek());
        }
        System.out.println(queue);
        System.out.println("Размерность массива - " + queue.capacity());

    }
}
