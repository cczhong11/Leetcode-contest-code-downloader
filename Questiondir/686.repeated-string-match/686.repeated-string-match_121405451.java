class Solution {
    public int repeatedStringMatch(String A, String B) {
        int res = 0;
        int l1 = A.length();
        int l2 = B.length();
        if (l2 == 0) return 0;
        if (l1 == 0) return -1;
        String s = A;
        int l = l1;
        int count = 1;
        while (l < l2) {
            s = s + A;
            l += l1;
            count++;
        }
        if (s.contains(B)) return count;
        if ((s + A).contains(B)) return count + 1;
        return -1;
    }
}