class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        return bits.length < 2 || bits[bits.length-2] == 0 || !solve(bits, bits.length-2);
    }
    private boolean solve(int[] bits, int n) {
        if (n == 0) {
            return true;
        } else if (bits[n-1] == 0) {
            return solve(bits, n-1) || (n > 1 && bits[n-2] == 1 && solve(bits, n-2));
        } else {
            return n > 1 && bits[n-2] == 1 && solve(bits, n-2);
        }
    }
}