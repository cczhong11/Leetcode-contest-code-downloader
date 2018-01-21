class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length <= 1) return true;
        int n = bits.length;
        boolean isOneBit = (bits[0] == 0);
        for (int i = 1; i < n - 1; i++) {
        	isOneBit = ((isOneBit && bits[i] == 0) || !isOneBit);
        }
        return isOneBit;
    }
}