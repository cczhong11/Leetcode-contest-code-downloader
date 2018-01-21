public class Solution {
    
    int count(int bits) {
        if (bits == 0) return 2;
        if (bits == 1) return 3;
        int a = 2, b = 3;
        while (bits > 1) {
            int tmp = a + b;
            a = b;
            b = tmp;
            bits--;
        }
        return b;
    }
    
    int countNoMore(int num, int bits) {
        if (bits == 0) return 1 + (num & 1);
        if (bits == 1) {
            switch (num & 3) {
                case 0: return 1;
                case 1: return 2;
                case 2: return 3;
                case 3: return 3;
            }
        }
        if ((num & (1 << bits)) == 0) return countNoMore(num, bits - 1);
        int cnt = count(bits - 1);
        if ((num & (1 << (bits - 1))) == 0) cnt += countNoMore(num, bits - 2);
        else cnt += count(bits - 2);
        return cnt;
    }
    
    public int findIntegers(int num) {
        return countNoMore(num, 31);
    }
}