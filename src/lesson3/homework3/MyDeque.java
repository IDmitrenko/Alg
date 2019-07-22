package lesson3.homework3;

public class MyDeque<T> extends MyQueue {

    private T[] list;
    private int size = 0;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    private int begin = 0;  // начало очереди (извлечь)
    private int end = 0;    // конец очереди (встать)

    public MyDeque(int capacity) {
        super(capacity);
    }

    public MyDeque() {
        super();
    }

// добавить слева
    public void isertLeft(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
            throw new StackOverflowError();
        }
        if (begin < 0) {
            T[] tempArr = (T[]) new Object[capacity];
            System.arraycopy(list, begin, tempArr, 1, size);
            list = tempArr;
            begin = 0;
        } else {
            begin = prevIndex(begin);
        }
        size++;
        list[begin] = item;
    }

    public void isertRight(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
            throw new StackOverflowError();
        }
        list[size] = item;
        size++;
        end = nextIndex(end);
    }

    public T removeLeft() {
        T value = peekLeft();
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public T peekLeft() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        }
        return list[begin];
    }

    public T removeRight() {
        T value = peekRight();
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size--;
        end = prevIndex(end);
        list[end] = null;
        return value;
    }

    public T peekRight() {
        if (isEmpty()) {
            System.out.println("stack empty");
            return null;
        }
        return list[prevIndex(end)];
    }

    private int prevIndex(int index) {
        return index > 0 ? index - 1 : 0;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        if (size != 0) {
            System.arraycopy(list,begin,tempArr,0,size);
        }
        begin = 0;
        end = size;
        list = tempArr;
    }
}
