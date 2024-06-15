import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int sum = 1; sum <= n; ++sum) {
            int minValue = Integer.MAX_VALUE;
            for (int num = 1; num * num <= sum; ++num) {
                minValue = Math.min(minValue, dp[sum - num * num]);
            }
            dp[sum] = minValue + 1;
        }

        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
