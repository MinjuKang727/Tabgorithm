package Q2_MaxTriangles;

import java.util.*;

public class MaxTriangles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = scanner.nextInt();
        }

        System.out.println(maxTriangles(sticks));
    }

    public static int maxTriangles(int[] sticks) {
        Arrays.sort(sticks);  // 막대기의 길이를 오름차순 정렬
        System.out.println(Arrays.toString(sticks));
        int count = 0;

        for (int i = sticks.length - 1; i >= 2; i--) {
            int c = sticks[i];
            int a = 0, b = i - 1;

            while (a < b) {
                System.out.printf("a: sticks[%d] >> %d, b: sticks[%d] >> %d, c: sticks[%d] >> %d, ", a, sticks[a], b, sticks[b], i, c);
                if (sticks[a] + sticks[b] > c) {
                    count += b - a;
                    b--;
                } else {
                    a++;
                }
                System.out.printf("count: %d\n", count);
            }
        }

        return count;
    }
}