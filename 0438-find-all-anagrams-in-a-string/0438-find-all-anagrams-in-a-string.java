class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if(s.length() < p.length()) return result;

        int[] window = new int[26];
        int[] need = new int[26];

        for(int ch : p.toCharArray()){
           need[ch - 'a']++;
        }
        int left = 0, k = p.length();

        for(int right = 0; right < s.length(); right++){
            window[s.charAt(right) - 'a']++;

            if(right - left + 1 > k){
                window[s.charAt(left) - 'a']--;
                left++;
            }
            
             if(right - left + 1 == k){
            if(matches(window, need)){
                result.add(left);
            }
        }
        }

        return result;
    }

    private boolean matches(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}