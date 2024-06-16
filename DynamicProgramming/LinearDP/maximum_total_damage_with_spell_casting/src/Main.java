import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> count = new HashMap<>();
        ArrayList<Integer> uniquePowers = new ArrayList<>();

        for (int pow : power) {
            if (!count.containsKey(pow)) {
                uniquePowers.add(pow);
                count.put(pow, 0);
            }
            count.put(pow, count.get(pow) + 1);
        }

        Collections.sort(uniquePowers);

        int n = uniquePowers.size();
        long[] dp = new long[n];

        for (int i = 0; i < n; ++i) {
            long take = 0;
            long notTake = 0;
            for (int j = 1; j < 4; ++j) {
                int idx = i - j;
                if (idx < 0) break;
                if (uniquePowers.get(idx) < uniquePowers.get(i) - 2) {
                    take = Math.max(take, dp[idx]);
                } else {
                    notTake = Math.max(notTake, dp[idx]);
                }
            }
            dp[i] = Math.max(notTake, take + (long) uniquePowers.get(i) * count.get(uniquePowers.get(i)));
        }

        return dp[n - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] power = new int[n];
            for (int i = 0; i < n; ++i) {
                power[i] = sc.nextInt();
            }

            System.out.println(new Solution().maximumTotalDamage(power));
        }

        sc.close();
    }
}
