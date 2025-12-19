class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int windowLen = wordLen * totalWords;

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) {
            need.put(w, need.getOrDefault(w, 0) + 1);
        }

        // Try all word-aligned starting positions
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (need.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // Too many occurrences → shrink
                    while (window.get(word) > need.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Found valid window
                    if (count == totalWords) {
                        result.add(left);
                    }

                } else {
                    // Reset window
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}
