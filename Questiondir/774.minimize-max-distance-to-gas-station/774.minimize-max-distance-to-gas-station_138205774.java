class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n=A.length,i=0;
        while (i<n)
        {
            if (A[i]>i+1) return false;
            if (A[i]==i+1)
            {
                if (A[i+1]!=i) return false;
                i++;
            }
            i++;
        }
        return true;
    }
}