public class Solution {
    int[] biao = {0,0,1,3,8,19,43,94,201,423,880,1815,3719,7582,15397,31171,62952,126891,255379,513342,1030865,2068495,4147936,8313583,16655823,33358014,66791053,133703499,267603416,535524643};
    
    public int findIntegers(int num) {
        for (int i = 0; i < 30; i++){
            System.out.print(h((int) Math.pow(2, i))+ ",");
        }
        return num + 1 - f(num);
    }
    
    public int f(int n){
        if (n < 3) return 0;
        if (n < 6) return 1;
        if (n < 7) return 2;
        if (n < 11) return 3;
        int i = 0;
        while(Math.pow(2, i) < n) i++;
        if (((int) Math.pow(2, i)) == n){
            return h(n);
        } 
        int lb = (int) Math.pow(2, i-1);
        int fen = (int) Math.pow(2, i-1) + (int) Math.pow(2, i-2);
        if (n < fen){
            return f(n - lb) + h(lb);
        } else {
            return f(fen - 1) + (n - fen + 1);
        }
    }
    
    public int h(int n){
        if (n <= 2) return 0;
        if (n <= 4) return 1;
        int i = 0;
        while(Math.pow(2, i) < n) i++;
        return (biao[i]);
    }
}