class Solution {
    public int repeatedStringMatch(String A, String B) {
        int i=0, j = 0, res = 0, m = A.length(), n = B.length();
        for (int k=0;k<A.length();k++){
            if (A.charAt(k)==B.charAt(0)){
                res = 1;
                i = k;
                j = 0;
                while(A.charAt(i)==B.charAt(j)){
                    i++;j++;
                    if (j==n) return res;
                    if (i==m){
                        i = 0;
                        res++;
                    }
                }
            }
        }
        return -1;
    }
}