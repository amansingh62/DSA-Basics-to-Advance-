class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];

        int p = 0, q = 0;

        for(int num : nums){
            if(num > 0){
                pos[p++] = num;
            } else {
                neg[q++] = num;
            }
        }

        int[] ans = new int[n];
        int i = 0, j = 0, k = 0;
        while(i < pos.length && j < neg.length){
            ans[k++] = pos[i++];
            ans[k++] = neg[j++];
        }
        return ans;
    }
}