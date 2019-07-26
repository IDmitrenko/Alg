package lesson4.homework4;

import lesson4.MyDoubleLinkedList;

public class MyLinkedQueue<T> {     // FIFO
    private MyDoubleLinkedList<T> queue = new MyDoubleLinkedList<>();

    public void enqueue(T value){    // добавить в очередь (в начало списка)
        queue.insertFirst(value);
    }

    public T dequeue(){              // извлечь из очереди (из конца списка)
        return queue.removeLast();
    }

    public T peek(){                 // получить значение первого в очереди
        return queue.getLast();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

}
