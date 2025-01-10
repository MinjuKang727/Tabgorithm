import java.util.Scanner;

public class SalesPrefixSum {
    public static int[] calculatePrefixSums(int[] sales) {
        // 누적합을 저장할 배열을 0으로 초기화
        int[] prefixSums = new int[sales.length + 1];
        for (int i = 1; i <= sales.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + sales[i - 1];
        }
        return prefixSums;
    }

    public static int querySum(int[] prefixSums, int l, int r) {
        return prefixSums[r] - prefixSums[l - 1];  // 구간 합 계산
    }

    public static void main(String[] args) {
        // System.out.println("[ 오늘의 문제 : 월간 판매 실적 구간 합 계산하기 ]");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 판매 데이터 개수
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = sc.nextInt();
        }

        int[] prefixSums = calculatePrefixSums(sales);

        int Q = sc.nextInt();  // 쿼리 개수
        for (int i = 0; i < Q; i++) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            System.out.println(querySum(prefixSums, L, R));  // 구간합 출력
        }
    }
}