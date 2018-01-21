class Solution {
    public int countPalindromicSubsequences(String S) {
        // condition on the letters of the two ends
        
        TreeSet<Integer>[] pos = (TreeSet<Integer>[])new TreeSet<?>[4]; // store the location of each letter
        int n = S.length();
        
        for (int i = 0; i < 4; ++i) pos[i] = new TreeSet<Integer>();
        
        for (int i = 0; i < n; ++i) {
            
            int ch = S.charAt(i) - 'a';
            pos[ch].add(i);
            
        }
        Integer[][] cache = new Integer[n+1][n+1];
        
        return dp(S, 0, n, pos, cache);
        
        
    }
    
    public int dp(String S, int start, int end, TreeSet<Integer>[] pos, Integer[][] cache) {
        
        // condition on the letters of the two ends
        if (start >= end) return 0;
        if (cache[start][end] == null) {
            
            int tmp = (int)Math.pow(10.0, 9.0) + 7;
            long res = 0;
            
            for (int i = 0; i < 4; ++i) {
                
                Integer start_i = pos[i].ceiling(start);
                Integer end_i = pos[i].lower(end);
                
                if (start_i == null || start_i >= end) continue;
                
                res += 1;
                if (start_i != end_i) res += 1;
                res += dp(S, start_i+1, end_i, pos, cache);
                
            }
            
            cache[start][end] = (int)(res%tmp);
            
        }
        
        return cache[start][end];
        
    }
    
}