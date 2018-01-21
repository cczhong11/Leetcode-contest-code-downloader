class Solution {
    public boolean hasAlternatingBits(int n) {
        String bitStr = Integer.toBinaryString(n);

        int now = 0;
        for (int i = 1; i < bitStr.length(); i++) {
            if (Integer.parseInt("" + bitStr.charAt(i)) != now) return false;
            now = 1 - now;
        }

        return true;
    }
}