package lesson4.homework4;

//import java.util.Iterator;
import java.util.ListIterator;

// Двунаправленный список
public class MyDoubleLinkedList<T> implements Iterable<T> {

    private Node first;   // ссылка на первый элемент
    private Node last;    // ссылка на последний элемент
    private int size = 0; // размер списка

    public MyDoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public ListIterator<T> iterator() {
        return new ListIter();
    }

    private class ListIter implements ListIterator<T> {
        Node current = new Node(null, first, last);  // узел указывающий на первый и последний элементы

        @Override
//возвращает true, если в коллекции имеется следующий элемент, иначе возвращает false
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
//возвращает значение следующего элемента
        public T next() {
            current = current.getNext();
            return (T) current.getValue();
        }

        @Override
//возвращает true, если в коллекции имеется предыдущий элемент, иначе возвращает false
        public boolean hasPrevious() {
            return current.getPrevious() != null;
        }

        @Override
//возвращает значение предыдущего элемента
        public T previous() {
            current = current.getPrevious();
            return (T) current.getValue();
        }

        @Override
//возвращает индекс следующего элемента. Если такого нет, то возвращается число -1
        public int nextIndex() {
            return indexOf(next());
        }

        @Override
//возвращает индекс предыдущего элемента. Если такого нет, то возвращается число -1
        public int previousIndex() {
            return indexOf(previous());
        }

        @Override
//удаляет текущий элемент из списка
        public void remove() {
//            MyDoubleLinkedList.this.remove((T) current.getValue());
            if (current == first) {
                removeFirst();
            } else if (current == last) {
                removeLast();
            } else {
                current.getPrevious().setNext(current.getNext());
                current.getNext().setPrevious(current.getPrevious());
            }
        }

        @Override
//присваивает текущему элементу, выбранному вызовом методов next() или previous(), ссылку на объект item
        public void set(T item) {
            current.setValue(item);
        }

        @Override
//вставляет объект item перед элементом, который должен быть возвращен следующим вызовом next()
        public void add(T item) {
            insert(indexOf((T) current.getValue()), item);
        }

    }

/*
    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {   // есть ли следующий
            return current.getNext() != null;
        }

        @Override
        public T next() {  // получить значение следующего
            current = current.getNext();
            return (T) current.getValue();
        }

        @Override
        public void remove() {  // удаление элемента найденного next
            MyDoubleLinkedList.this.remove((T) current.getValue());
        }
    }
*/

    private class Node<T> {
        private T value;
        private Node next;  // ссылка на следующий элемент
        private Node previous;  // ссылка на предыдущий элемент

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setValue(T value) {
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

    public T getFirst() {        // значение первого элемента
        return (T) first.getValue();
    }

    public T getLast() {         // значение последнего элемента
        return (T) last.getValue();
    }

    public void insertFirst(T item) {   // вставить на место первого
        Node newNode = new Node(item);
        newNode.setNext(first);
        if (!isEmpty()) {
            first.setPrevious(newNode);  // старый первый ссылается на новый как на предыдущий
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {          // получить первый с удалением
        if (isEmpty()) {
            return null;
        }
        Node oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;  // после первого нет элементов
        } else {
            first.setPrevious(null);    // в новом первом обнуляем ссылку на предыдущий
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (!isEmpty()) {
            newNode.setPrevious(last);  // в новый последний пишем ссылку на предыдущий (старый последний)
            last.setNext(newNode);   // в старый последний пишем ссылку на следующий (новый последний)
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node oldLast = last;  // удаляемый последний
        if (last.getPrevious() != null) { // есть ли предыдущий
            last.getPrevious().setNext(null);  // обнуляем у предыдущего ссылку на удаляемый следующий
        } else {
            first = null;
        }
        last = last.getPrevious();
        size--;
        return (T) oldLast.getValue();
    }

    public int indexOf(T item) {   // получить индекс элемента по значению
        Node current = first;   // текущий элемент
        int index = 0;          // индекс текущего элемента
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {  // проверить наличие элемента по значению
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {  // вставить элемент по индексу
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index >= size) {
            insertLast(item);   // добавляем как последний
            return;
        }
        Node current = first;
        int i = 0;

        while (i < index -1) {  // ищем предыдущий элемент
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item);
        newNode.setNext(current.getNext()); // новый ссылается на следующий за текущим
        newNode.setPrevious(current);  // для нового предыдущим является текущий
        newNode.getNext().setPrevious(newNode); // в следующий за новым записываем его как предыдущий
        current.setNext(newNode);      // текущий ссылается на новый как на следующий
        size++;
    }

    public boolean remove(T item) {  // удалить элемент по значению
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) { // проверка на первый
            removeFirst();
            return true;
        }
        Node current = first;
        while (current != null &&
                !current.getValue().equals(item)) {
// проверка на конец списка и поиск удаляемого элемента
            current = current.getNext();
        }
        if (current == null) {
            return false;   // выход по концу списка
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.getPrevious().setNext(current.getNext());
// в предыдущий элемент от удаляемого занесли ссылку на следующий от удаляемого
        current.getNext().setPrevious(current.getPrevious());
// в следующий за удаляемым элемент занесли ссылку на предыдущий (предыдущий от удаляемого)
        size--;
        return true;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.getValue() + " ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
