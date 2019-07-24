package lesson4;

public class MyLinkedStack<T> {
    private MyDoubleLinkedList<T> stack = new MyDoubleLinkedList<>();

    public void push(T value){
        stack.insertFirst(value);
    }

    public T pop(){
        return stack.removeFirst();
    }

    public T peek(){
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
