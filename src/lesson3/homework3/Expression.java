package lesson3.homework3;

import lesson3.MyStack;

public class Expression {
    private String exp;

    public Expression(String exp) {
        this.exp = exp;
    }

    public boolean checkBracket() {
        lesson3.MyStack<Character> stack = new MyStack<>(exp.length());
        char ch;
        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Error in " + i + " position");
                    return false;
                }
                char top = stack.pop();
                if (ch == '}' && top != '{' ||
                        ch == ')' && top != '(' ||
                        ch == ']' && top != '[' ){
                    System.out.println("Error in " + i + " position: bracket doesn't match");
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            System.out.println("Error : bracket doesn't match");
            return false;
        }
        return true;
    }

}
