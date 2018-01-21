class Solution {
    public boolean hasAlternatingBits(int n) {
        int last=-1;
        while (n>0)
        {
            int now=(n&1);
            if (now==last) return false;
            last=now;
            n>>=1;
        }
        return true;
    }
}