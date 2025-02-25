import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int N = sc.nextInt();
        double sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num > max) {
                max = num;
            }
            list.add(num);
        }

        for (int j = 0; j < N; j++) {
            sum += ((double) list.get(j) / max) * 100;
        }

        System.out.println(sum / N);

        sc.close();
    }
}