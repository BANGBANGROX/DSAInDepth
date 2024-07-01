import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] last = new int[26];
        final int MOD = (int) 1e9 + 7;

        Arrays.fill(last, -1);

        dp[0] = 1;

        for (int i = 0; i < n; ++i) {
            dp[i + 1] = (dp[i] * 2) % MOD;
            int idx = s.charAt(i) - 'a';
            if (last[idx] != -1) {
                dp[i + 1] = (dp[i + 1] - dp[last[idx]] + MOD) % MOD;
            }
            last[idx] = i;
        }

        return (dp[n] - 1 + MOD) % MOD;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().distinctSubseqII(scanner.next()));
        }

        scanner.close();
    }
}
