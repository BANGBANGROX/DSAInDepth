import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private int[] days;
    private int[] costs;
    private int n;

    private int nextDay(int idx, int lastDay) {
        int left = idx + 1;
        int right = n - 1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (days[mid] <= lastDay) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int minCostTicketsHandler(int idx) {
        if (idx >= n) return 0;

        if (dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.min(costs[0] + minCostTicketsHandler(nextDay(idx, days[idx])), Math.min(costs[1] + minCostTicketsHandler(nextDay(idx, days[idx] + 6)), costs[2] + minCostTicketsHandler(nextDay(idx, days[idx] + 29))));
    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        n = days.length;
        dp = new int[n];

        Arrays.fill(dp, -1);

        return minCostTicketsHandler(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] days = new int[n];
            for (int i = 0; i < n; ++i) {
                days[i] = sc.nextInt();
            }
            int[] costs = new int[3];
            for (int i = 0; i < 3; ++i) {
                costs[i] = sc.nextInt();
            }

            System.out.println(new Solution().mincostTickets(days, costs));
        }

        sc.close();
    }
}
