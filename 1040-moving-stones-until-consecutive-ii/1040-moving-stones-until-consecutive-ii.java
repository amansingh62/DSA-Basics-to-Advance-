import java.util.*;

class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;

        // -------- Maximum Moves --------
        int maxMove1 = stones[n - 1] - stones[1] - (n - 2);
        int maxMove2 = stones[n - 2] - stones[0] - (n - 2);
        int maxMoves = Math.max(maxMove1, maxMove2);

        // -------- Minimum Moves --------
        int minMoves = n;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (stones[right] - stones[left] + 1 > n) {
                left++;
            }

            int stonesInWindow = right - left + 1;

            // Special case
            if (stonesInWindow == n - 1 &&
                stones[right] - stones[left] == n - 2) {
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - stonesInWindow);
            }
        }

        return new int[]{minMoves, maxMoves};
    }
}
