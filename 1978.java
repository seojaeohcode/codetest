import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int N = sc.nextInt();
        boolean[] isPrime = new boolean[1001]; // 1000까지의 소수 여부를 판단하기 위한 배열
        Arrays.fill(isPrime, true); // 모든 수를 소수라고 가정

        // 에라토스테네스의 체 적용 (1000까지 소수 구하기)
        isPrime[0] = isPrime[1] = false; // 0과 1은 소수가 아님
        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false; // i의 배수는 소수가 아님
                }
            }
        }

        // 입력 받은 수들이 소수인지 체크
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int prime_num = sc.nextInt();
            if (prime_num <= 1000 && isPrime[prime_num]) {
                cnt++; // 소수면 카운트 증가
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}