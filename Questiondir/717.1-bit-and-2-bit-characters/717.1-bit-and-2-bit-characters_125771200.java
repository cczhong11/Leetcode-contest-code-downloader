class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 0) return false;
        
        for(int i = 0;i <bits.length; i++){
            if(i==bits.length-1 && bits[i]==0) return true;
            if(bits[i]==1) i++;
        }
        return false;
    }
}