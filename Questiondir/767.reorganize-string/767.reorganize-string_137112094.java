class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (int i = 0; i < S.length(); ++i) {
        	count[S.charAt(i) - 'a']++;
        }
        char[] res = new char[S.length()];
        for (int i = 0; i < S.length(); ++i) {
        	int k = -1;
        	for (int j = 0; j < 26; ++j) {
        		if (count[j] == 0 || i > 0 && res[i - 1] - 'a' == j) {
        			continue;
        		} 
        		if (k == -1 || count[j] > count[k]) {
        			k = j;
        		}
        	}
        	if (k == -1) return "";
        	res[i] = (char)('a' + k);
        	count[k]--;
        }
        return String.valueOf(res);
    }
}