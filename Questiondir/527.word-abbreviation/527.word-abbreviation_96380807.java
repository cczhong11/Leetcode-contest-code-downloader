public class Solution {
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> abbrs = new HashMap<>();
        int size = dict.size();
        for (int i = 0; i < size; i++) {
            String word = dict.get(i);
            boolean ok = false;
            String ab = word;
            int s1 = 1;
            while (!ok) {
                ab = getAbbr(word, s1);
                if (!abbrs.containsKey(ab)) {
                    abbrs.put(ab, i);
                    ok = true;
                } else {
                    int j = abbrs.get(ab);
                    if (j == -1) { s1++; } else {
                        String other = dict.get(j);
                        int l = word.length();
                        while (s1 < (l - 2) && word.charAt(s1 - 1) == other.charAt(s1 - 1)) {
                            abbrs.put(getAbbr(word, s1++), -1);
                        }
                        ab = getAbbr(other, s1);
                        ans.set(j, ab);
                        abbrs.put(ab, j);
                        ab = getAbbr(word, s1);
                        abbrs.put(ab, i);
                        ok = true;
                    }
                }
            }
            ans.add(ab);
        }
        return ans;
    }

    private String getAbbr(String word, int i) {
        int len = word.length();
        if (i >= len - 2) return word;
        return word.substring(0, i) + (len - i - 1) + word.charAt(len - 1);
    }
}