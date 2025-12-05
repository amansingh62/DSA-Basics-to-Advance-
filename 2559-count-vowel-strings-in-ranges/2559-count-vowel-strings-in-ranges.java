class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];
        //Building prefixSum of vowels
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + (StartAndEndWithVowels(words[i]) ? 1 : 0);
        }

        int m = queries.length;
        int[] ans = new int[m];
        for(int q = 0; q < m; q++){
            int l = queries[q][0];
            int r = queries[q][1];
            ans[q] = prefix[r + 1] - prefix[l];
        }
        return ans;
    }

    // Method for checking for vowels at char first and last
    private boolean StartAndEndWithVowels(String s){
      char a = s.charAt(0);
      char b = s.charAt(s.length() - 1);
      return isVowel(a) && isVowel(b);
    }

    //Method to return vowel
    private boolean isVowel(char c){
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}