package lesson3.homework3;

public class MyDeque<T> {

    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    private int left_begin = 0;  // начало очереди (извлечь)
    private int left_end = 0;    // конец очереди (встать)

    private int right_begin = 0;  // начало реверсной очереди
    private int right_end = 0;    // конец реверсной очереди

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (T[]) new Object[capacity];
            this.capacity = capacity;
        }
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public void isertLeft(T item) {
        if (isFull()) {
//            capacity += DEFAULT_CAPACITY;
//            reCapacity(capacity);
            throw new StackOverflowError();
        }
        size++;
        list[left_end] = item;
        left_end = nextIndex(left_end);
    }

    public boolean isFull() {
        return size == list.length;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }
}
