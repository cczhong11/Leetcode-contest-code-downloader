class Solution {
    public boolean hasAlternatingBits(int n) {
        long i=1;
        while(i<n) {
            if(i%2==1)
                i*=2;
            else
                i=i*2+1;
        }
        return i==n;
    }
}