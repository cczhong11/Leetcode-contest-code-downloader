class Solution {
    public int dominantIndex(int[] a) {
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if (idx == -1 || a[i] > a[idx]) {
                idx = i;
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            if (i == idx) continue;
            if (a[i] * 2 > a[idx]) return -1;
        }
        return idx;
    }
}