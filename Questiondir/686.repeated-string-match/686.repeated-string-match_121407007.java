class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = A.length();
        while (A.length() < B.length()*2) {
            A = A.concat(A);
        }
        int i = A.indexOf(B);
        if (i == -1) return -1;
        i += B.length();
        System.out.format("%d\n",i);
        
        if (i % n == 0) 
            return i / n; 
        else 
            return 1 + i / n;
    }
}