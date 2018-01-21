class Solution {
    public boolean isOneBitCharacter(int[] bits) {
                boolean[] avail=new boolean[bits.length+1];
        avail[0]=true;
        for (int i=1;i<=bits.length;++i){
               if (bits[i-1]==0&&avail[i-1]){
                   avail[i]=true;
               } else if (i>1&&bits[i-2]==1&&avail[i-2]) {
                   avail[i]=true;
               }
        }
        return avail[bits.length-1];
    }
}