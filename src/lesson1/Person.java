package lesson1;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        return getName().equals(((Person)obj).getName());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
//        int a = 5;
//        int b = 5;
//        Person p = new Person("Ivan");
//        Person p1 = new Person("Ivan");
//
//        if (p.equals(p1) ) {
//            System.out.println("Равны");
//        } else {
//            System.out.println("Неравны");
//        }
//        System.out.println("p  " + p);
//        System.out.println("p1  " +p1);


//        int a = 5;
//        inc(a);
//        System.out.println(a);

        Person p = new Person("Ivan");
        updateName(p);
        System.out.println(p.getName());

    }

    public static void inc(int a){
        a++;
    }

    public static void updateName(Person p){
        p.setName("Super"+ p.getName());
    }
}
