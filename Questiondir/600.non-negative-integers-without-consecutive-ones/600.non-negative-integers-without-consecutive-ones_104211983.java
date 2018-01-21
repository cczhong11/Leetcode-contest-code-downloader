public class Solution {
    public int findIntegers(int num) {
        if(num == 0)
            return 1;
        if(num == 1)
            return 2;
        int[] last = new int[2];
        int res = 2;
        last[0] = 0;
        last[1] = 1;
        int t = 2;
        while(t*2 <= num){
            t *= 2;
            int[] tmp = new int[2];
            tmp[0] = last[1] + last[0];
            tmp[1] = last[0];
            last[0] = tmp[0];
            last[1] = tmp[1];
            res += last[0]+last[1];
        }
        if((num - t) >= t / 2)
            return res + findIntegers(t / 2 - 1);
        else
            return res + findIntegers(num - t);
    }
}