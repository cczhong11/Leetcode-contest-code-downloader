class Solution {
    public boolean hasAlternatingBits(int n) {
        int expected = n&1;
        while(n!=0) {
            if (expected!=(n&1))return false;
            n>>=1;
            expected=1-expected;
        }
        return true;
    }
}