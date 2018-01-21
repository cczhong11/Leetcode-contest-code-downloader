class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A.isEmpty()) {
            return B.isEmpty()? 1:-1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 2*B.length()) {
            sb.append(A);
        }
        int idx = sb.toString().indexOf(B);
        if (idx < 0) {
            return -1;
        } else {
            return (idx+B.length()+A.length()-1)/A.length();
        }
    }
}