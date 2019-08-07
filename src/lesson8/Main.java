package lesson8;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap<Integer, String> hm = new ChainingHashMap<>();
//        hm.put(1,"one");
//        hm.put(2,"two");
//        hm.put(3,"three");
//        hm.put(4,"four");

//        System.out.println(hm.get(3));

//        for (int i = 0; i <99 ; i++) {
//            hm.put((int)(Math.random()*1000),""+i);
//        }
//
//        System.out.println(hm);

        LinearProbingHashMap<Integer, String> lhm = new LinearProbingHashMap<>();
//        lhm.put(1,"one");
//        lhm.put(2,"two");
//        lhm.put(3,"three");
//        lhm.put(4,"four");
//
//        System.out.println(lhm.get(4));

        for (int i = 0; i <50 ; i++) {
            lhm.put((int)(Math.random()*1000),""+i);
        }

        System.out.println(lhm);


    }
}
