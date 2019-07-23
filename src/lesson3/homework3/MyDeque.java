package lesson3.homework3;

public class MyDeque<T> extends MyQueue {

    private int begin;  // начало очереди (извлечь)
    private int end;    // конец очереди (встать)

    public MyDeque(int capacity) {
        super(capacity);
        this.begin = capacity / 2;
        this.end = begin + 1;
    }

    public MyDeque() {
        super();
        this.begin = DEFAULT_CAPACITY / 2;
        this.end = begin + 1;
    }

// добавить слева
    public void insertLeft(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
//            throw new StackOverflowError();
        }
        if (begin < 0) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
        }
        if (size > 0) {
            begin = prevIndex(begin);
        }
        list[begin] = item;
        size++;
    }

    public void insertRight(T item) {
        if (isFull()) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
//            throw new StackOverflowError();
        }
        list[end] = item;
        size++;
        end = nextIndex(end);
        if (end < 0) {
            capacity += DEFAULT_CAPACITY;
            reCapacity(capacity);
        }
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
        return (T) list[begin];
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
        return (T) list[prevIndex(end)];
    }

    private int prevIndex(int index) {
        return index > 0 ? --index : -1;
    }

    private int nextIndex(int index) {
        return ++index == capacity ? -1 : index;
    }

    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        if (size != 0) {
            System.arraycopy(list,begin,tempArr,((newCapacity - size) / 2),size);
        }
        begin = (newCapacity - size) / 2;
        end = begin + size;
        list = tempArr;
    }
}
