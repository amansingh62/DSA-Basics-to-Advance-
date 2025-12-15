class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Step 1: Remove elements out of this window
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }

            // Step 2: Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Step 3: Add current index
            dq.offerLast(i);

            // Step 4: Record result when window is ready
            if (i >= k - 1) {
                result[idx++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
