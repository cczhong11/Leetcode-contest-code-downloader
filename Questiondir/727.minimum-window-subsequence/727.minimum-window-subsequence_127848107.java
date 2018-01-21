class Solution {
    public String minWindow(String S, String T) {
        TreeSet<Integer>[] posSet = new TreeSet[26];

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            int index = ch - 'a';
            if (posSet[index] != null) continue;

            posSet[index] = new TreeSet<>();
            for (int j = 0; j < S.length(); j++) {
                if (S.charAt(j) == ch) {
                    posSet[index].add(j);
                }
            }
        }

        int ansLen = S.length();
        int ansStart = -1;
        for (int i = 0; i < S.length(); i++) {
            int e = i-1;
            boolean flag = true;
            for (int k = 0; k < T.length(); k++) {
                int index = T.charAt(k) - 'a';
                Integer pos = posSet[index].higher(e);
                if (pos == null || pos-i+1>=ansLen) {
                    flag = false;
                    break;
                }
                e = pos;
            }

            if (flag) {
                ansLen = e-i+1;
                ansStart = i;
            }
        }

        return ansStart >= 0 ? S.substring(ansStart, ansStart+ansLen) : "";
    }
}