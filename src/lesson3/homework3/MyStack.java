package lesson3.homework3;

public class MyStack<T> {

    private T[] list;
    private int size = 0;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            this.capacity = capacity;
        }
    }

    public MyStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void push(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
//            throw new StackOverflowError();
        }
        list[size] = item;
        size++;
    }

    public T pop() {
        T temp = peek();
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        list[size] = null;
        if (size < capacity / 10) {
            capacity = capacity / 2;
            reCapacity(capacity);
        }
        return temp;
    }


    public T peek() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void reCapacity( int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list = tempArr;
    }

}
