import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        int answer = 1;

        dp[0] = 1;

        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < n; ++i) {
            int currentMax = 0;
            for (int j = 0; j < i; ++j) {
                if (pairs[i][0] > pairs[j][1]) {
                    currentMax = Math.max(currentMax, dp[j]);
                }
            }
            dp[i] = currentMax + 1;
            answer = Math.max(answer, dp[i]);
        }

        return answer;
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
