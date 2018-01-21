public class Solution {
    public static final long DIV = 1000000007;
    
    public int numDecodings(String s) {
        List<Long> count = new ArrayList<>();
        count.add(1L);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            long num = 0;
            if (c == '*') {
                num = (num + count.get(i) * 9) % DIV;
                if (i > 0) {
                    char pre = s.charAt(i-1);
                    if (pre == '1') {
                        num = (num + count.get(i-1) * 9) % DIV;
                    } else if (pre == '2') {
                        num = (num + count.get(i-1) * 6) % DIV;
                    } else if (pre == '*') {
                        num = (num + count.get(i-1) * 15) % DIV;
                    }
                }
            } else if (c >= '1' && c <= '9'){
                num = (num + count.get(i)) % DIV;
                if (i > 0) {
                    char pre = s.charAt(i-1);
                    if (pre == '1' || pre == '*') {
                        num = (num + count.get(i-1)) % DIV;
                    }
                    if ((pre == '2' || pre == '*') && c <= '6') {
                        num = (num + count.get(i-1)) % DIV;
                    }
                }
            } else if (c == '0') {
                if (i > 0) {
                    char pre = s.charAt(i-1);
                    if (pre == '1' || pre == '*') {
                        num = (num + count.get(i-1)) % DIV;
                    }
                    if ((pre == '2' || pre == '*') && c <= '6') {
                        num = (num + count.get(i-1)) % DIV;
                    }
                }
            }
            count.add(num);
        }
        long x = count.get(s.length());
        return (int) x;
    }
}