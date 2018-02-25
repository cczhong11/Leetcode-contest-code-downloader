class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int min = A[n - 1];
        int p = n - 3;
        while(p >= 0){
            if(A[p] > min){
                //System.out.println("p = " + p);
                return false;
            }
            if(A[p + 1] < min){
                min = A[p + 1];
            }
            p--;
        }
        return true;
    }
}