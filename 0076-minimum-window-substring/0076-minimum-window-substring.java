class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] need = new int[128];
        for(char ch : t.toCharArray()){
            need[ch]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();
        int start = 0;

        while(right < s.length()){
            char c = s.charAt(right);

            if(need[c] > 0){
                required--;
            }
            
            need[c]--;
            right++;

            while(required == 0){
                if(minLen > right - left){
                   minLen = right - left;
                   start = left;
                }

            char leftChar = s.charAt(left);
            need[leftChar]++;
            if(need[leftChar] > 0){
                required++;
            }
            left++;
        }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}