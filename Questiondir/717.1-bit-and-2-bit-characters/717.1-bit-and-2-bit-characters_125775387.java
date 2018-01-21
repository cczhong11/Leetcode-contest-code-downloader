class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        return helper(bits, 0);
    }
    boolean helper(int[] bits, int start) {
        if (start == bits.length-1) {
            return true;
        } else if (start > bits.length - 1) {
            return false;
        }
        if (bits[start] == 0) {
            if (helper(bits, start + 1)) {
                return true;
            }
        } else if (bits[start] == 1) {
            if (bits[start + 1] == 0) {
                if (helper(bits, start + 2)) {
                    return true;
                }
            } else if (bits[start + 1] == 1) {
                if (helper(bits, start + 2)) {
                    return true;
                }
            }
        }
        return false;
    }
}