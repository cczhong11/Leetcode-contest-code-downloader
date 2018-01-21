class Solution {
    public int repeatedStringMatch(String A, String B) {
        int b;
        for (int aStart = 0; aStart < A.length(); aStart++) {
            for (b = 0; b < B.length(); b++) {
                if (B.charAt(b) != A.charAt((aStart + b) % A.length())) break;
            }
            if (b < B.length()) continue;
            return (int) Math.ceil((aStart + B.length()) / (double) A.length());
        }
        return -1;
    }
}