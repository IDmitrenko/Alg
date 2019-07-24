package lesson4;

public class MyLinkedQueue<T> {
    private MyDoubleLinkedList<T> queue = new MyDoubleLinkedList<>();

    public void enqueue(T value){
        queue.insertFirst(value);
    }

    public T dequeue(){
        return queue.removeLast();
    }

    public T peek(){
        return queue.getLast();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
