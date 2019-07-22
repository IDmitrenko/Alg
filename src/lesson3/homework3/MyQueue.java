package lesson3.homework3;

public class MyQueue<T> {
    private T[] list;
    private int size = 0;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;  // начало очереди
    private int end = 0;    // конец очереди

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            this.capacity = capacity;
        }
    }

    public MyQueue() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void insert(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
//            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T remove() {
        T value = peek();
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        if (size < capacity / 10) {
            capacity /= 2;
            reCapacity(capacity);
        }
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        }
        return list[begin];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
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

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        if (size != 0) {
            if (begin >= end) {
                System.arraycopy(list, begin, tempArr, 0, size - begin);
                System.arraycopy(list, 0, tempArr, size - begin, end);
            } else {
                System.arraycopy(list, begin, tempArr, 0, end - begin);
            }
        }
        begin = 0;
        end = size;
        list = tempArr;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }

}