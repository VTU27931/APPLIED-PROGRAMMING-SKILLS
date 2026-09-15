class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        int[] lps = new int[n];

        // Build LPS array
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Length of the smallest repeating pattern
        int patternLength = n - lps[n - 1];

        return lps[n - 1] > 0 && n % patternLength == 0;
    }
}