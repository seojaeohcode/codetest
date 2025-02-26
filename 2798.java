//브루트포스 완전탐색. for 3번을 쓰더라도 계산을 해야함. 몇번까지 도는지. O^3이여도 괜찮았던 케이스.

import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int maxSum = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num <= M) {
                list.add(num);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = list.get(i) + list.get(j) + list.get(k);

                    if (sum <= M && sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }

        System.out.println(maxSum);

        sc.close();
    }
}