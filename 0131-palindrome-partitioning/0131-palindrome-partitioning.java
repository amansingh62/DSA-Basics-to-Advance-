class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    };

    private void backtrack(String s, int start, List<String> current, List<List<String>>  result){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < s.length(); i++){
          if(palindrome(s, start, i)){
            current.add(s.substring(start, i + 1));
            backtrack(s, i + 1, current, result);
            current.remove(current.size() - 1);
          }
        }
    }

    private static boolean palindrome(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        };
        return true;
    }

}