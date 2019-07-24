package lesson4;

public class MyLinkedList<Item> {
    private Node first;
    private int size = 0;

    public MyLinkedList() {
        this.first = null;
    }

    class Node<Item> {
        private Item value;
        private Node next;

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

    public void insertFirst(Item item) {
        Node newNode = new Node(item);
        newNode.setNext(first);
        first = newNode;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        size--;
        return (Item) oldFirst.getValue();
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
        Node current = first;
        int i = 0;
        if (index > size) {
            index = size;
        }
        while(i < index-1){
            current = current.getNext();
            i++;
        }
        Node newNode= new Node(item);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }

    public boolean remove(Item item){
        if(isEmpty()){
            return false;
        }
        if(first.getValue().equals(item)){
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.getNext()!= null &&
        !current.getNext().getValue().equals(item)){
            current = current.getNext();
        }
        if(current.getNext() == null){
            return false;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder s= new StringBuilder();
        while(current != null){
            s.append(current.getValue()+" ");
            current = current.getNext();
        }
        return s.toString();
    }
}
