package lesson5.homework5;

public class MainExponentiation {
    public static void main(String[] args) {

        System.out.println(exponentiation(5, 3));
        System.out.println(recExponentiation(5, 3));
    }

    public static int exponentiation(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public static int recExponentiation(int x, int y) {
        if (y == 1) {
            return x;
        }
        return recExponentiation(x, y - 1) * x;
    }
}
