package lesson3.homework3;

public class ReadRightToLeft {

    public static void main(String[] args) {

        String textO = ".лобтуф в ларги ятеП а ,умар алым амаМ";
        System.out.println(arabicStyle(textO));

    }

    public static String arabicStyle(String text) {
        if (text.length() <= 0)
            throw new IllegalArgumentException();

        String[] textM = text.split("");
        int j = textM.length;
        StringBuilder sb = new StringBuilder();
        MyStack<String> arab = new MyStack<>(j);
        for (int i = 0; i < j; i++) {
            arab.push(textM[i]);
        }
        for (int i = 0; i < j; i++) {
            sb.append(arab.pop());
        }
        return sb.toString();
    }
}
