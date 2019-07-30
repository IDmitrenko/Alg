package lesson6;

public class MainTree {

    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(Person person) {
        Node node = new Node();
        node.person = person;
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    /**
     * алгоритм симметричного обхода по действиям:
     * ему необходимо  вызвать самого себя для обхода левой стороны дерева,
     * посетить узел и вызвать самого себя для обхода правой стороны.
     * @param rootNode - корневой элемент
     */
    private void inOrder(Node rootNode) {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    /*
    Для прямого обхода выполняется:
     Посещение узла.
     Вызов самого себя для обхода левой стороны.
     Вызов самого себя для обхода правой стороны.
     */
    private void directOrder(Node rootNode) {
        if (rootNode != null) {
            rootNode.display();
            directOrder(rootNode.leftChild);
            directOrder(rootNode.rightChild);
        }
    }

    /*
    Для обратного обхода:
     Вызов самого себя для обхода левой стороны.
     Вызов самого себя для обхода правой стороны.
     Посещение узла.
     */
    private void reverseOrder(Node rootNode) {
        if (rootNode != null) {
            reverseOrder(rootNode.leftChild);
            reverseOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    public Node min() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    /*
     Ситуации, которые могут возникать при удалении узла.
     1) Удаляемый узел является листом (не имеет потомков).
     2) Удаляемый узел имеет одного потомка.
     3) Удаляемый узел имеет двух потомков.
     */
    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.person.id != id) {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        /*
        Когда удаляемый узел найден, проверяем, что он действительно не имеет потомков, и удаляем его.
        Если он является корневым, изменяем значение поля root на null.
        */
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        /*
        Если удаляемый узел имеет одного потомка, необходимо соединить родителя удаляемого узла с его потомком.
        */
        // Если нет правого потомка
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        // Если нет левого потомка
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        /*
        Если удаляемый элемент имеет двух потомков, нельзя просто выбрать одного из них и поставить на место родителя.
        Рассмотрим пример, в котором вместо удаляемого узла устанавливается правый потомок.
        Если удаляемый элемент имеет двух потомков, нельзя просто выбрать одного из них и поставить на место родителя.
        Рассмотрим пример, в котором вместо удаляемого узла устанавливается правый потомок.
        Сначала выбирается правый потомок, ключ которого больше удаляемого узла.
        Потом — левый потомок правого узла, далее — к левому потомку левого потомка правого узла,
        и так вниз по цепочке левых потомков, пока не будет найден последним. Он и будет преемником.
        Фактически мы применяем алгоритм нахождения минимума для правого поддерева удаляемого элемента.
        У правого потомка удаляемого элемента может не быть левого потомка.
        Тогда первый правый потомок удаляемого элемента будет его преемником.

        Если преемник является правым потомком удаляемого элемента, переносим все поддерево на один уровень вверх,
        где преемник становится на освободившееся место.

        Если преемник является левым потомком правого потомка удаляемого элемента, удаление производится следующим образом.
        Сначала сохраняется ссылка на правого потомка преемника в поле leftChild родителя преемника.
        Далее сохраняется ссылка на правого потомка удаляемого элемента в поле rightChild преемника.
        Убирается current из поля rightChild его родителя и в нем же сохраняется ссылка на преемника successor.
        Так же убирается ссылка на левого потомка current из объекта current и сохраняется в поле leftChild объекта Successor.
        */
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public void displayTree() {

    }

    // Метод поиска преемника
    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }
}
