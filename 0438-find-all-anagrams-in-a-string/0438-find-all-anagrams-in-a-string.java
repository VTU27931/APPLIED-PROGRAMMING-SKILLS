import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] freq = new int[26];

        // Frequency of characters in p
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int windowSize = p.length();

        // Sliding window
        for (int i = 0; i < s.length(); i++) {

            // Add current character to the window
            freq[s.charAt(i) - 'a']--;

            // Remove character that is outside the window
            if (i >= windowSize) {
                freq[s.charAt(i - windowSize) - 'a']++;
            }

            // If all frequencies are zero, we found an anagram
            if (i >= windowSize - 1 && allZero(freq)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }

    private boolean allZero(int[] freq) {
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}