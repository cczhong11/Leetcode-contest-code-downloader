class Solution {
    public int repeatedStringMatch(String A, String B) {
        for(int i = 0; i < A.length(); ++i) {
            int temp = check(A, B, i);
            if(temp >= 0) return temp;
        }
        return -1;
    }
    
    private int check(String A, String B, int index_A) {
        int count = 0, index_B = 0;
        while(index_B < B.length()) {
            if(B.charAt(index_B) == A.charAt(index_A)) {
                ++index_B;
                ++index_A;
            }
            else return -1;
            if(index_A == A.length()) {
                ++count;
                index_A = 0;
            }
        }
        if(index_A > 0) ++count;
        return count;
    }
}