class Solution {
    public int maximumSwap(int num) {
        String val = String.valueOf(num);
        int res = num;
        for (int i = 0; i < val.length(); i++) for (int j = i+1; j < val.length(); j++) {
            String s = val.substring(0, i) + val.charAt(j) + val.substring(i+1, j) + val.charAt(i);
            if (j + 1 < val.length()) {
                s += val.substring(j + 1);
            }
            if (Integer.valueOf(s) > res) {
                res = Integer.valueOf(s);
            }
        }
        return res;
    }
}