class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(n < k) return false;

        HashSet<String> set = new HashSet<>();
        int target = 1 << k;

        for(int i = 0; i <= n - k; i++){
            String sub = s.substring(i, i + k);
            set.add(sub);

            if(target == set.size()){
            return true;
        }
        }
        return false;
    }
}