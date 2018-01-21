class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });

        boolean dp[] = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > 1) break;
            dp[i] = true;
        }

        for (int i = 0; i < words.length; i++) {
            if (dp[i]) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].length() - words[i].length() > 1) break;
                    if (words[j].length() - words[i].length() == 1
                            && words[j].substring(0, words[i].length()).equals(words[i])) {
                        dp[j] = true;
                    }
                }
            }
        }

        String ans = "";
        for (int i = 0; i < words.length; i++) {
            if (dp[i] && (ans.isEmpty() || words[i].length() > ans.length())) {
                ans = words[i];
            }
        }
        return ans;
    }
}