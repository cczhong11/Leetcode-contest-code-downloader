class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        String ans = "";
        int cur = -1;
        for (int i = 0; i < S.length(); i++) {
            int maxCount = 0;
            int index = -1;
            for (int j = 0; j < 26; j++) {
                if (count[j] > maxCount && j != cur) {
                    maxCount = count[j];
                    index = j;
                }
            }

            if (index < 0) return "";
            ans += (char) (index + 'a');
            count[index]--;
            cur = index;
        }
        
        return ans;
    }
}