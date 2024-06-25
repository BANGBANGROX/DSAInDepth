import java.util.Scanner;

class Solution {
    public int countOrders(int n) {
        final int MOD = (int) 1e9 + 7;
        long answer = 1;

        // Let's say we have placed n - 1 pairs already, for placing the nth pair we have in total 2 * n - 1 positions available. For the first one we will have 2 * n - 1 positions and for then next one we will have 2 * n positions. So total arrangements (2 * n - 1) * (2 * n) (PnC AND operation). Since P should come before D everytime, we will have final arrangements as (2 * n - 1) * (2 * i) / 2 = (2 * n - 1) * n. Since the whole operation PnC AND we will multiply all the results.

        for (int i = 2; i <= n; ++i) {
            answer = ((answer * (2L * i - 1)) % MOD * i) % MOD;
        }

        return (int) answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().countOrders(scanner.nextInt()));
        }

        scanner.close();
    }
}
