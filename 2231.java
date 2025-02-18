import java.io.IOException;
import java.util.*;
import java.lang.Math;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = String.valueOf(N).length();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = Math.max(N - (M * 9), 1); i < N - 1; i++) {
            String num = String.valueOf(i);
            int R = i;
            for (int j = 0; j < num.length(); j++) {
                R += num.charAt(j) - '0';
            }
            if (R == N) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(list));
        }

        sc.close();
    }
}