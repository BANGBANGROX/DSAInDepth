import java.util.Scanner;

class Solution {
    private int[] jumps;
    private int totalRanges;

    private int minStepsToReachTarget(int target) {
        int currentMaxRange = 0;
        int result = 0;
        int nextMaxRange = 0;

        for (int i = 0; i < totalRanges - 1; ++i) {
            if (i > currentMaxRange) return -1;
            nextMaxRange = Math.max(nextMaxRange, jumps[i] + i);
            if (i == currentMaxRange) {
                currentMaxRange = nextMaxRange;
                ++result;
            }
        }

        return currentMaxRange >= target ? result : -1;
    }

    public int minTaps(int n, int[] ranges) {
        totalRanges = n + 1;
        jumps = new int[totalRanges];

        for (int i = 0; i < totalRanges; ++i) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);
            jumps[left] = Math.max(jumps[left], right - left);
        }

        return minStepsToReachTarget(n);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] ranges = new int[n + 1];
            for (int i = 0; i <= n; ++i) {
                ranges[i] = sc.nextInt();
            }

            System.out.println(new Solution().minTaps(n, ranges));
        }

        sc.close();
    }
}
