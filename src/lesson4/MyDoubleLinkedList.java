package lesson4;

import java.util.Iterator;

public class MyDoubleLinkedList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int size = 0;

    public MyDoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<Item> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public Item next() {
            current = current.getNext();
            return (Item) current.getValue();
        }

        @Override
        public void remove() {
            if (current == first) {
                removeFirst();
            } else if (current == last) {
                removeLast();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }
    }

    private class Node<Item> {
        private Item value;
        private Node next;
        private Node previous;

        public Node(Item value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(Item value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Item getFirst() {
        return (Item) first.getValue();
    }

    public Item getLast() {
        return (Item) last.getValue();
    }

    public void insertFirst(Item item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (!isEmpty()) {
            first.setPrevious(newNode);
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        size--;
        return (Item) oldFirst.getValue();
    }

    public void insertLast(Item item) {
        Node newNode = new Node(item);
        if (!isEmpty()) {
            newNode.setPrevious(last);
            last.setNext(newNode);
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrevious();
        size--;
        return (Item) oldLast.getValue();
    }


    public int indexOf(Item item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, Item item) {
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index >= size) {
            insertLast(item);
            return;
        }
        Node current = first;
        int i = 0;

        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        newNode.getNext().setPrevious(newNode);
        current.setNext(newNode);
        size++;
    }

    public boolean remove(Item item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null &&
                !current.getValue().equals(item)) {
            current = current.getNext();
        }
        ////////////////////////
        if (current == null) {
            return false;
        }
        ////////////////////////
        if (current == last) {
            removeLast();
            return true;
        }
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.getValue() + " ");
            current = current.getNext();
        }
        return s.toString();
    }
}
