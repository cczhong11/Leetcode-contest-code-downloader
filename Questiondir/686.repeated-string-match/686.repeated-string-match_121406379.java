class Solution {
    public int repeatedStringMatch(String A, String B) {
        int repTime = (B.length() - 1) / A.length() + 1;
        StringBuilder newA = new StringBuilder();
        for (int i = 0; i < repTime; i++) newA.append(A);
        if (newA.toString().contains(B)) {
            return repTime;
        }
        newA.append(A);
        if (newA.toString().contains(B)) {
            return repTime + 1;
        }
        return -1;
    }
}