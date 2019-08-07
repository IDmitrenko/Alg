package lesson8;

import java.util.Arrays;

public class LinearProbingHashMap<Key, Value> {
    private int capacity = 97;
    private int size = 0;

    private Key[] keys = (Key[]) new Object[capacity];
    private Value[] values = (Value[]) new Object[capacity];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private boolean isKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("ключ не может быть null");
        }
        return true;
    }

    public void put(Key key, Value value){
        isKeyNotNull(key);
        if(size == capacity - 2){
            throw new ArrayIndexOutOfBoundsException("Хеш таблица заполнена");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i +1) % capacity) {
            if(key.equals(keys[i])){
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key){
        isKeyNotNull(key);
        for (int i = hash(key); keys[i] != null; i = (i +1) % capacity) {
            if(key.equals(keys[i])){
                return values[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(keys);
    }

}
