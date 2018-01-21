public class Solution {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int)Math.sqrt(c);
        for(int a=0;a<=sqrt;a++){
            int b = (int)Math.sqrt(c-a*a);
            if(a*a+b*b==c) return true;
        }
        return false;
    }
}