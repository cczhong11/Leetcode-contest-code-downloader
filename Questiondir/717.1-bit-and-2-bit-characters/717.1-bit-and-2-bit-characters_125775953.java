class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length == 1) return true;
        boolean[] isOneBit = new boolean[bits.length];
        isOneBit[bits.length - 1] = true;
        isOneBit[bits.length - 2] = (bits[bits.length - 2] == 0);
        for (int i = bits.length - 3; i >= 0; i--) {
            if (bits[i] == 0) isOneBit[i] = isOneBit[i+1];
            else isOneBit[i] = isOneBit[i+2];
        }
        return isOneBit[0];
    }
}