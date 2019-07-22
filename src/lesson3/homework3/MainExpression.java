package lesson3.homework3;

public class MainExpression {
    public static void main(String[] args) {

        Expression et = new Expression("({[Энциклопедия] + [познавательная] + {1} (2) [3] })");
        System.out.println(et.checkBracket());

        Expression ef = new Expression("({[Энциклопедия] + }[познавательная] + {1} (2) [3] })");
        System.out.println(ef.checkBracket());

    }
}
