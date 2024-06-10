import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] coins;
    private int[][] dp;
    private int n;

    private int changeHandler(int idx, int amount) {
        if (amount == 0) return 1;

        if (idx >= n) return 0;

        if (dp[idx][amount] != -1) return dp[idx][amount];

        if (coins[idx] <= amount) {
            return dp[idx][amount] = changeHandler(idx + 1, amount) + changeHandler(idx, amount - coins[idx]);
        }

        return dp[idx][amount] = 0;
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);

        this.coins = coins;
        n = coins.length;
        dp = new int[n][amount + 1];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return changeHandler(0, amount);
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
