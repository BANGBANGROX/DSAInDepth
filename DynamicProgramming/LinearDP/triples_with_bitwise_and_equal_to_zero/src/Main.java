import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int countTriplets(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (int num : nums) {
            for (int i : nums) {
                int andValue = num & i;
                count.put(andValue, count.getOrDefault(andValue, 0) + 1);
            }
        }

        for (int num : nums) {
            for (int andValue : count.keySet()) {
                if ((num & andValue) == 0) {
                    answer += count.get(andValue);
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            System.out.println(new Solution().countTriplets(nums));
        }

        sc.close();
    }
}
