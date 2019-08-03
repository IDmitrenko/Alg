package lesson6.homework6;

import lesson6.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTree {
    private static Random rnd = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        List<BST<Integer, Integer>> lbst = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            BST<Integer, Integer> bst = new BST<>();
            lbst.add(bst);
            createTree(bst);

        }
        int counter = 0;
        for (BST<Integer, Integer> tree : lbst) {
            System.out.println("Дерево имеет " + tree.depth() + " уровней.");
            System.out.println(tree.toString());
            if (!tree.isBalanced()) {
                ++counter;
            }
        }
        System.out.println("Количество несбалансированных деревьев " + counter);
        System.out.println("Процент несбалансированных деревьев - " + Math.round((((double) counter) / 20)* 100) + " %");
    }

    private static void createTree(BST<Integer, Integer> bst) {
        int key = 0;
        while (bst.depth() <= 6) {
            key = rnd.nextInt(100) - rnd.nextInt(100);
            bst.put(key, key);
        }
        bst.delete(key);
    }
}
