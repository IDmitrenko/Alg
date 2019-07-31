package lesson6;

public class Main {
    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(5,"five");
        bst.put(1,"one");
        bst.put(3,"three");
        bst.put(2,"two");
        System.out.println(bst);
        System.out.println(bst.get(3));

        System.out.println(bst.minKey());
        System.out.println(bst.maxKey());

        bst.delete(3);
        System.out.println(bst);

    }
}
