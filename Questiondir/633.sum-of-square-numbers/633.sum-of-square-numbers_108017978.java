public class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> set = new HashSet<>();
        for (long i = 0; i * i <= c; i ++) {
            set.add(i * i);
        }
        
        for (long i = 0; i * i <= c; i ++) {
            long rem = c - i * i;
            if (set.contains(rem)) return true;
        }
        return false;
    }
}