package lesson8.homework8;

public class MainChaining {
    public static void main(String[] args) {

        ChainingHashMap<Integer, String> hm = new ChainingHashMap<>();
        hm.put(1,"one");
        hm.put(2,"two");
        hm.put(3,"three");
        hm.put(4,"four");
        hm.put(5,"five");
        hm.put(6,"six");
        hm.put(7,"seven");
        hm.put(8,"eight");

        System.out.println(hm);
        System.out.println(hm.get(3));

        System.out.println(hm.remove(8));

        System.out.println(hm);

        hm.put(8,"eight");
        System.out.println(hm);
    }
}
