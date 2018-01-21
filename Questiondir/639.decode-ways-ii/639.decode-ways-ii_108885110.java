public class Solution {
    public int numDecodings(String s) {
        long p1 = 1, p2 = 1;
        for(int i = 0; i < s.length(); ++i) {
            long curr = 0;
            if(s.charAt(i) == '*') {
                curr += p2*9;
                if(i > 0) {
                    if(s.charAt(i-1) == '*') curr += p1*15;
                    else if(s.charAt(i-1) == '1') curr += p1*9;
                    else if(s.charAt(i-1) == '2') curr += p1*6;
                }
            }
            else if(s.charAt(i) == '0') {
                if(i > 0) {
                    if(s.charAt(i-1) == '*') curr += p1*2;
                    else if(s.charAt(i-1) == '1') curr += p1;
                    else if(s.charAt(i-1) == '2') curr += p1;
                    else return 0;
                }
                else return 0;
            }
            else {
                curr += p2;
                if(i > 0) {
                    if(s.charAt(i-1) == '*') curr += s.charAt(i) > '6'? p1: 2*p1;
                    else if(s.charAt(i-1) == '1') curr += p1;
                    else if(s.charAt(i-1) == '2') curr += s.charAt(i) > '6'? 0: p1;
                }
            }
            p1 = p2;
            p2 = curr%1000000007;
        }
        return (int)p2;
    }
}