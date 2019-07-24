package lesson1;

public class Main {
    public static void main(String[] args) {
        String[] logins = new String[1000000];
        String newLogin = "Ivan";
        boolean uniq = true;
        for (int i = 0; i < logins.length; i++) {
            if(logins[i].equals(newLogin)){
                uniq = false;
                break;
            }
        }
        if(uniq){
            ///
        }else{
            /// ====
        }

    }

    public static void someThink(){
        int n =1000;
        int k =0;
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]){
                    k++;
                }
            }
//            O(n^2 )
        }

    }
}
