import java.util.Scanner;

class Solution {
    private static class Container {
        private int minX;
        private int maxX;
        private int minY;
        private int maxY;

        Container() {
            minX = Integer.MAX_VALUE;
            maxX = Integer.MIN_VALUE;
            minY = Integer.MAX_VALUE;
            maxY = Integer.MIN_VALUE;
        }

        public void add(int x, int y) {
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }

        public int calculateArea() {
            return (maxX - minX + 1) * (maxY - minY + 1);
        }
    }

    private Container[] initContainers() {
        Container[] containers = new Container[3];
        containers[0] = new Container();
        containers[1] = new Container();
        containers[2] = new Container();

        return containers;
    }

    private int[][] rotate(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[n][m];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[j][i] = grid[i][j];
            }
        }

        for (int[] row : result) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                ++left;
                --right;
            }
        }

        return result;
    }

    private int getAreaSumFor2Case(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = m * n;

        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                Container[] containers = initContainers();
                for (int x = 0; x < m; ++x) {
                    for (int y = 0; y < n; ++y) {
                        if (grid[x][y] == 1) {
                            if (x <= i) {
                                containers[0].add(x, y);
                            } else if (x >= (i + 1) && x <= j) {
                                containers[1].add(x, y);
                            } else {
                                containers[2].add(x, y);
                            }
                        }
                    }
                }
                result = Math.min(result, containers[0].calculateArea() + containers[1].calculateArea() + containers[2].calculateArea());
            }
        }

        return result;
    }

    private int getAreaSumFor4Case(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = m * n;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                Container[] containers = initContainers();
                for (int x = 0; x < m; ++x) {
                    for (int y = 0; y < n; ++y) {
                        if (grid[x][y] == 1) {
                            if (x <= i) {
                                containers[0].add(x, y);
                            } else if (y <= j) {
                                containers[1].add(x, y);
                            } else {
                                containers[2].add(x, y);
                            }
                        }
                    }
                }
                result = Math.min(result, containers[0].calculateArea() + containers[1].calculateArea() + containers[2].calculateArea());
            }
        }

        return result;
    }

    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = m * n;

        int[][] firstRotate = rotate(grid);
        int[][] secondRotate = rotate(firstRotate);
        int[][] thirdRotate = rotate(secondRotate);

        answer = Math.min(answer, getAreaSumFor2Case(grid));
        answer = Math.min(answer, getAreaSumFor2Case(firstRotate));

        answer = Math.min(answer, getAreaSumFor4Case(grid));
        answer = Math.min(answer, getAreaSumFor4Case(firstRotate));
        answer = Math.min(answer, getAreaSumFor4Case(secondRotate));
        answer = Math.min(answer, getAreaSumFor4Case(thirdRotate));

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            System.out.println(new Solution().minimumSum(grid));
        }

        scanner.close();
    }
}
