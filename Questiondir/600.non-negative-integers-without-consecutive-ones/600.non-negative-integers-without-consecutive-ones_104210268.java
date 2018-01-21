public class Solution {
    public int myLog (int a) {
        if (a == 1) {
            return 1;
        }
        else {
            return (1 + myLog(a/2));
        }
    }
    
    
    public int fib (int n) {
        if (n == 2) {
            return 2;
        }
        else if (n == 3) {
            return 3;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
    }
    
    public int myPow (int a) {
        if (a == 0) {
            return 1;
        }
        else if (a % 2 == 0) {
            return myPow(a/2) * myPow(a/2);
        }
        else {
            return 2 * myPow(a-1);
        }
    }
    
    public int findIntegers(int num) {
        int a, ans;
        if (num == 0) {
            return 1;
        }
        if (num == 1) {
            return 2;
        }
        else {
            a = myLog(num);
            ans = fib(a);
            num = num - myPow(a-1);
            if (num < myPow(a-2)) {
                return ans + findIntegers(num);
            }
            else {
                return (ans + findIntegers(myPow(a-2) - 1));
                //return (ans + findIntegers(num - myPow(a-2)));
            }
        }
    }
                
        
        
        
        
        /*
        
        if (num == 0) {
            return 1;
        }
        else if (num == 1) {
            return 2;
        }
        else {
            if ((num % 2) == 0) {
                return (findIntegers(num-1) + findIntegers(num / 2) - findIntegers((num / 2) - 1));
            }
            else if ((num % 4) == 1) {
                return (findIntegers(num-1) + findIntegers(num / 4) - findIntegers((num / 4) - 1));
            }
            else {
                return findIntegers(num-1);
            }
        }
        
    }
    */
    
    
            /*
        int[] ans = calcInts(num);
        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i];
        }
        return sum;
        */
        
        
          /*
    public int[] calcInts (int num) {
        int res[] = new int[num+1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < num+1; i++) {
            if ((i % 2) == 0) {
                res[i] = res[i/2];
            }
            else if ((i % 4) == 1) {
                res[i] = res[i/4];
            }
            else {
                res[i] = 0;
            }
        }
        return res;
    }
    */
    
}