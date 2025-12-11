class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int required = threshold * k;
        int sum = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }

        if(sum >= required) count++;

        for(int i = k; i < arr.length; i++){
            sum += arr[i];
            sum -= arr[i - k];

            if(sum >= required) count++;
        }
        return count;
    }
}