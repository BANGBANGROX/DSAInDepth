import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int n;

    private int checkRecordHandler(int idx, int totalAbsent, int currentLate) {
        if (idx >= n) return 1;

        if (dp[idx][totalAbsent][currentLate] != -1) return dp[idx][totalAbsent][currentLate];

        int result = checkRecordHandler(idx + 1, totalAbsent, 0);
        final int MOD = (int) 1e9 + 7;

        if (totalAbsent < 1) result = (result + checkRecordHandler(idx + 1, totalAbsent + 1, 0)) % MOD;

        if (currentLate < 2) result = (result + checkRecordHandler(idx + 1, totalAbsent, currentLate + 1)) % MOD;

        return dp[idx][totalAbsent][currentLate] = result;
    }

    public int checkRecord(int n) {
        this.n = n;
        dp = new int[n][2][3];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return checkRecordHandler(0, 0, 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            System.out.println(new Solution().checkRecord(sc.nextInt()));
        }

        sc.close();
    }
}
