class Solution {
    
    // if the concatenate of two special string won't generate special strings in between
    // find out all the special substrings
    public String makeLargestSpecial(String S) {
        
        int n = S.length();
        
        List<String>[][] cache = (List<String>[][])new List<?>[n+1][n+1];
        List<String> list = dp(S, 0, n, cache);
        
        return merge(list);
        
    }
    
    private List<String> dp(String s, int start, int end, List<String>[][] cache) {
        
        // check whether it has a special prefix
        if (end <= start) {

            List<String> res = new ArrayList<String>();
            return res;
            
        }
        
        if (cache[start][end] == null) {
        
        int ptr = start;
        int count = 0; // the number of 1
        List<String> res = new ArrayList<String>();
            
        while (ptr < end) {
            
            if (s.charAt(ptr) == '1') ++count;
            else --count;
            
            ++ptr;
            if (count == 0) break; // find a special prefix
            
        }
        
        if (ptr == end) {
            
            // no special prefix
            List<String> mid = dp(s, start+1, end-1, cache);
            res.add("1"+merge(mid)+"0");
            
        }      
        else {
        
            List<String> tmp = dp(s, start, ptr, cache); // 
            res = dp(s, ptr, end, cache);
            res.addAll(tmp);
            
        }
            
    
            cache[start][end] = res;
        }
        
        return cache[start][end];
        
    }
    
    private String merge(List<String> list) {
        
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int n = list.size();
        for (int i = n-1; i >= 0; --i) sb.append(list.get(i));
        
        return sb.toString();
        
    }
    
}