import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<Integer, String> dp;
    private int[] cost;

    private String getMaxNumber(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        if (m < n) return num2;

        if (m > n) return num1;

        for (int i = 0; i < m; ++i) {
            if (num1.charAt(i) < num2.charAt(i)) return num2;
            else if (num1.charAt(i) > num2.charAt(i)) return num1;
        }

        return num1;
    }

    private String largestNumberHandler(int remainingTarget) {
        if (remainingTarget == 0) {
            return "";
        }

        if (dp.containsKey(remainingTarget)) return dp.get(remainingTarget);

        String result = "0";

        for (int dig = 1; dig < 10; ++dig) {
            if (cost[dig - 1] <= remainingTarget) {
                String next = largestNumberHandler(remainingTarget - cost[dig - 1]);
                if (!next.equals("0")) {
                    result = getMaxNumber(result, "" + dig + next);
                }
            }
        }

        dp.put(remainingTarget, result);

        return result;
    }

    public String largestNumber(int[] cost, int target) {
        this.cost = cost;
        dp = new HashMap<>();

        return largestNumberHandler(target);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int[] cost = new int[9];
            for (int i = 0; i < 9; ++i) {
                cost[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            System.out.println(new Solution().largestNumber(cost, target));
        }

        sc.close();
    }
}
