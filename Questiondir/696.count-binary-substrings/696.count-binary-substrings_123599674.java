class Solution {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        int lens[] = new int[len];
        lens[len - 1] = s.charAt(len - 1) == '0' ? -1 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                lens[i] = lens[i+1] < 0 ? lens[i+1]-1 : -1;
            } else {
                lens[i] = lens[i+1] > 0 ? lens[i+1]+1 : 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int index = i + Math.abs(lens[i]);
            if (index < len && lens[index] * lens[i] < 0 && Math.abs(lens[index]) >= Math.abs(lens[i])) {
                ans++;
            }
        }
        return ans;
    }
}