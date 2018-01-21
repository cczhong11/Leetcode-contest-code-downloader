class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int pre = 0, last = 0;
        while(last < bits.length) {
            if (bits[last] == 1) {
                pre = last;
                last += 2;
            } else {
                pre = last;
                last++;
            }
        }
        return pre == bits.length-1;
    }
}