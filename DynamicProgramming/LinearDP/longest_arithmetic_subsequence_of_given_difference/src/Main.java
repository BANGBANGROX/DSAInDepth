import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int answer = 1;

        for (int num : arr) {
            int lastNum = num - difference;
            int result = 1;
            if (dp.containsKey(lastNum)) {
                result = dp.get(lastNum) + 1;
            }
            dp.put(num, Math.max(dp.getOrDefault(num, 0), result));
            answer = Math.max(answer, dp.get(num));
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = scanner.nextInt();
            }
            int difference = scanner.nextInt();

            System.out.println(new Solution().longestSubsequence(arr, difference));
        }
    }
}