class Solution {

    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = Integer.MAX_VALUE;

        // ✅ 1) Three horizontal strips (two horizontal cuts)
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                int a = area(grid, 0, i, 0, n - 1);
                int b = area(grid, i + 1, j, 0, n - 1);
                int c = area(grid, j + 1, m - 1, 0, n - 1);
                ans = Math.min(ans, a + b + c);
            }
        }

        // ✅ 2) Three vertical strips (two vertical cuts)
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int a = area(grid, 0, m - 1, 0, i);
                int b = area(grid, 0, m - 1, i + 1, j);
                int c = area(grid, 0, m - 1, j + 1, n - 1);
                ans = Math.min(ans, a + b + c);
            }
        }

        // ✅ 3) L-shape splits (one horizontal + one vertical)
        for (int r = 0; r < m - 1; r++) {
            for (int c = 0; c < n - 1; c++) {

                // ┌──
                int a1 = area(grid, 0, r, 0, n - 1);
                int b1 = area(grid, r + 1, m - 1, 0, c);
                int c1 = area(grid, r + 1, m - 1, c + 1, n - 1);
                ans = Math.min(ans, a1 + b1 + c1);

                // └──
                int a2 = area(grid, 0, r, 0, c);
                int b2 = area(grid, 0, r, c + 1, n - 1);
                int c2 = area(grid, r + 1, m - 1, 0, n - 1);
                ans = Math.min(ans, a2 + b2 + c2);

                // ┐│
                int a3 = area(grid, 0, m - 1, 0, c);
                int b3 = area(grid, 0, r, c + 1, n - 1);
                int c3 = area(grid, r + 1, m - 1, c + 1, n - 1);
                ans = Math.min(ans, a3 + b3 + c3);

                // │┘
                int a4 = area(grid, 0, r, 0, c);
                int b4 = area(grid, r + 1, m - 1, 0, c);
                int c4 = area(grid, 0, m - 1, c + 1, n - 1);
                ans = Math.min(ans, a4 + b4 + c4);
            }
        }

        return ans;
    }

    // ✅ Bounding box area of 1s in subgrid
    private int area(int[][] grid, int r1, int r2, int c1, int c2) {
        int minRow = r2 + 1, maxRow = -1;
        int minCol = c2 + 1, maxCol = -1;

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        // ✅ No 1 found
        if (maxRow == -1) return 0;

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}
