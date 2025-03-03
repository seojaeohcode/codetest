//계수정렬방식. 해당 배열의 인덱스를 범위로 지정해서 풀이하는 방식

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001]; // 입력 값이 10,000 이하이므로 배열 크기 10001

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i] > 0) { // 해당 숫자가 존재하는 개수만큼 출력
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.print(sb); // 한 번에 출력 (속도 최적화)
    }
}
