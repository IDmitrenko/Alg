package lesson4.homework4;

import lesson4.MyDoubleLinkedList;

public class MyLinkedStack<T> {     // LIFO
    private MyDoubleLinkedList<T> stack = new MyDoubleLinkedList<>();

    public void push(T value){     // добавить элемент в стек (первый)
        stack.insertFirst(value);
    }

    public T pop(){               // взять с удалением (первый) элемент из стека
        return stack.removeFirst();
    }

    public T peek(){              // получить значение элемента (первого)
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
