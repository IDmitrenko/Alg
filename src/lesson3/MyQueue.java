package lesson3;

public class MyQueue<Item> {
    private Item[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private int begin = 0;
    private int end = 0;

    // 0 1 2 3 4
    //       b
    // e
    // 5     6 9


    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity " + capacity);
        } else {
            list = (Item[]) new Object[capacity];
        }
    }

    public MyQueue() {
        list = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public void insert(Item item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public Item remove() {
        Item value = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public Item peek() {
        if (isEmpty()) {
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

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
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
