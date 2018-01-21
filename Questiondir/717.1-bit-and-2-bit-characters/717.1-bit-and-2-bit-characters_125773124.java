class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, m = 0;
        if(n<2) return true;
        
        for(int i = n-2; i>=0 && bits[i]==1; i--) m++;
        return ((m%2)==0);
    }
}