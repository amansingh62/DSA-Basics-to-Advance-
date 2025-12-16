class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {

        Deque<int[]> dq = new ArrayDeque<>();
        // store {x, y_minus_x}

        int ans = Integer.MIN_VALUE;

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            // Step 1: remove elements out of range
            while (!dq.isEmpty() && x - dq.peekFirst()[0] > k) {
                dq.pollFirst();
            }

            // Step 2: compute result using best candidate
            if (!dq.isEmpty()) {
                ans = Math.max(ans, y + x + dq.peekFirst()[1]);
            }

            int currVal = y - x;

            // Step 3: maintain decreasing order of values
            while (!dq.isEmpty() && dq.peekLast()[1] <= currVal) {
                dq.pollLast();
            }

            dq.offerLast(new int[]{x, currVal});
        }

        return ans;
    }
}
