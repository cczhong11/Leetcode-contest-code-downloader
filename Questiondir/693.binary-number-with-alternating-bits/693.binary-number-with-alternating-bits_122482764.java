class Solution {
    public boolean hasAlternatingBits(int n) {
        int lsb=(n&1);
        while (n>0){
            n>>=1;
            int nlsb=n&1;
            if (nlsb==lsb)return false;
            lsb=nlsb;
        }
        return true;
    }
}