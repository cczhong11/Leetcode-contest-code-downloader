class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int p=0;
        while(true){
            boolean flag;
            if(bits[p]==1){
                p++;
                flag=false;
            }
            else flag=true;
            p++;
            if(p>=bits.length)return flag;
        }
    }
}