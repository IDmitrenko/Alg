package lesson3.homework3;

public class MainStack {
    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>();
        int j;

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        j = stack.size();
        for (int i = 0; i < j; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("Размерность массива - " + stack.capacity());

        for (int i = 0; i < 15; i++) {
            stack.push(i + 1);
        }
        System.out.println("Размерность массива - " + stack.capacity());

        j = stack.size();
        for (int i = 0; i < j; i++) {
            System.out.println(stack.pop());
        }
        System.out.println("Размерность массива - " + stack.capacity());

        stack.push(5);
        stack.push(6);
        System.out.println("Размерность массива - " + stack.capacity());

        j = stack.size();
        for (int i = 0; i < j; i++) {
            System.out.println(stack.peek());
        }
        System.out.println("Размерность массива - " + stack.capacity());

    }
}
