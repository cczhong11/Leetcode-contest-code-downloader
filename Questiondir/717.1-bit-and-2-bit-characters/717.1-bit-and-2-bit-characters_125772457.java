class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1 || bits[bits.length - 2] == 0) {
            return true;
        }
        boolean[] valid = new boolean[bits.length - 1];
        valid[0] = true;
        for(int i = 0; i < bits.length - 2; ++ i) {
            if(bits[i] == 1) {
                valid[i+1] = i > 0 && bits[i-1] == 1 && valid[i-1];
            }
            else {
                valid[i+1] = valid[i] || i > 0 && bits[i-1] == 1 && valid[i-1];
            }
        }
        return !valid[valid.length - 1];
    }
}