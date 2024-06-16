import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[] dp;
    private int[][] books;
    private int shelfWidth;

    private int minHeightShelvesHandler(int idx) {
        if (idx >= books.length) return 0;

        if (dp[idx] != -1) return dp[idx];

        int currentWidth = 0;
        int currentShelfMaxHeight = 0;
        int result = Integer.MAX_VALUE;

        for (int j = idx; j < books.length; ++j) {
            int width = books[j][0];
            int height = books[j][1];
            currentWidth += width;
            if (currentWidth <= shelfWidth) {
                currentShelfMaxHeight = Math.max(currentShelfMaxHeight, height);
                result = Math.min(result, minHeightShelvesHandler(j + 1) + currentShelfMaxHeight);
            }
        }

        return dp[idx] = result;
    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        this.books = books;
        dp = new int[books.length];
        this.shelfWidth = shelfWidth;

        Arrays.fill(dp, -1);

        return minHeightShelvesHandler(0);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] books = new int[n][2];
            for (int i = 0; i < n; ++i) {
                books[i][0] = sc.nextInt();
                books[i][1] = sc.nextInt();
            }
            int shelfWidth = sc.nextInt();

            System.out.println(new Solution().minHeightShelves(books, shelfWidth));
        }

        sc.close();
    }
}
