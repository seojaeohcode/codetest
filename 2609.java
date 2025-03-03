
//원래 제일 쉬운 방법은 유클리드 호제법
//계수정렬 + 에라토스테네스의 체
import java.io.IOException;
import java.util.*;

class Main {

    public static boolean[] Eratostenes(int n) {
        boolean[] num = new boolean[n + 1];
        Arrays.fill(num, true); // 처음엔 모두 소수로 가정
        if (n >= 0)
            num[0] = false; // 0은 소수 아님
        if (n >= 1)
            num[1] = false; // 1은 소수 아님

        int limit = (int) Math.sqrt(n);

        for (int i = 2; i <= limit; i++) {
            if (num[i]) {
                for (int j = i * i; j <= n; j += i) {
                    num[j] = false;
                }
            }
        }

        return num;
    }

    // factor[index] = index가 소인수로 몇 번 등장하는지 (exponent)
    // (에라토스테네스 결과 isPrime을 활용)
    public static int[] factorizeToArray(int num, boolean[] isPrime) {
        int[] factor = new int[isPrime.length]; // 0~maxVal까지

        int tmp = num;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i])
                continue; // i가 소수가 아니면 skip

            // tmp를 i로 나눌 수 있는 동안 반복
            while (tmp % i == 0) {
                factor[i]++;
                tmp /= i;
            }

            // 최적화: i*i > tmp되면 멈춰도 됨
            if ((long) i * i > tmp) {
                break;
            }
        }

        // 마지막에 tmp가 1보다 크면 그 자체가 소수
        if (tmp > 1) {
            factor[tmp]++;
        }

        return factor;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        // 1. 에라토스테네스의 체로 max(A,B)까지 소수 판별
        int maxVal = Math.max(A, B);
        boolean[] isPrime = Eratostenes(maxVal);

        // 2) A, B 각각에 대한 소인수 지수 배열 구하기
        int[] factorA = factorizeToArray(A, isPrime);
        int[] factorB = factorizeToArray(B, isPrime);

        // 3) GCD, LCM 구하기
        long GCD = 1;
        long LCM = 1;

        // 모든 인덱스(소수 후보)에 대해
        for (int i = 2; i <= maxVal; i++) {
            // A의 i 지수, B의 i 지수
            int expA = factorA[i];
            int expB = factorB[i];
            if (expA == 0 && expB == 0)
                continue; // 둘 다 0이면 건너뜀

            int eMin = Math.min(expA, expB);
            int eMax = Math.max(expA, expB);

            // GCD: 공통 소인수 지수의 최솟값
            if (eMin > 0) {
                GCD *= (long) Math.pow(i, eMin);
            }
            // LCM: 공통 소인수 지수의 최댓값
            if (eMax > 0) {
                LCM *= (long) Math.pow(i, eMax);
            }
        }

        System.out.println(GCD);
        System.out.println(LCM);

        sc.close();
    }
}