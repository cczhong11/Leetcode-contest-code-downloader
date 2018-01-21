class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        for (int i = 0; ; ++i) {
            int hi = i * (i + 1) / 2;
            if (hi == target) {
                return i;
            }
            if (hi > target && hi % 2 == target % 2) {
                return i;
            }
        }
    }
}