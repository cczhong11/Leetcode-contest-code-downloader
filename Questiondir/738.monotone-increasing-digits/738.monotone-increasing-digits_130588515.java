class Solution {
    public int monotoneIncreasingDigits(int N) {
        
        int n = N;
        int count = 0;
        
        while (n >= 10) {
            n /= 10; // find the first digit
            ++count;
        }
        
        return helper(N, count, 0);
        
    }
    
    public int helper(int N, int m, int min) {
        
        // condition on whether the first digits are equal
        // return -1 if impossible
        int n = N;
        int count = 0;
        
        while (n >= 10) {
            n /= 10; // find the first digit
            ++count;
        }
        
        if (count < m) n = 0;
        
        if (n >= min) {
            
            if (count == 0) return n;
            
            int order = (int)Math.pow(10.0, count);            
            int tmp = helper(N - n*order, m-1, n);
            
            if (tmp == -1) {
                
                // can't use the same first digit
                if (n == min) return -1;
                else {
                    // use n-1
                    return (n-1)*order+order-1;
                    
                }
                
            }
            else {
                
                // can use n
                return tmp+n*order;
                
            }
            
        }
        else return -1;
        
    }
}