class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        if(n<3) return true;
        int max = A[0];
        for(int i=2;i<n;i++) {
            if (A[i]<max) {
                return false;
            }
            if (A[i-1]>max) {
                max = A[i-1];
            }
        }
        return true;
    }
}