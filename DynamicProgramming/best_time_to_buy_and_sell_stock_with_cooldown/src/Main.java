import java.util.Scanner;

class Solution {
    private int[][] dp;
    private int[] prices;
    private int n;

    private int maxProfitHandler(int idx, int buyOrSell) {
        if (idx >= n) return 0;

        if (dp[idx][buyOrSell] != Integer.MIN_VALUE) return dp[idx][buyOrSell];

        int result = maxProfitHandler(idx + 1, buyOrSell);

        if (buyOrSell == 0) {
            result = Math.max(result, -1 * prices[idx] + maxProfitHandler(idx + 1, 1));
        } else {
            result = Math.max(result, prices[idx] + maxProfitHandler(idx + 2, 0));
        }

        return dp[idx][buyOrSell] = result;
    }

    public int maxProfit(int[] prices) {
        this.prices = prices;
        n = prices.length;
        dp = new int[n][2];
        for (int i = 0; i < n; ++i) {
            dp[i][0] = dp[i][1] = Integer.MIN_VALUE;
        }

        return maxProfitHandler(0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] prices = new int[n];
            for (int i = 0; i < n; ++i) {
                prices[i] = scanner.nextInt();
            }

            System.out.println(new Solution().maxProfit(prices));
        }

        scanner.close();
    }
}
