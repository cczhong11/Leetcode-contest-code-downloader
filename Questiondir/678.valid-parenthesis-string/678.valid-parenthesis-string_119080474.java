class Solution {
    public boolean checkValidString(String s) {
        return dfs(s.toCharArray(), 0, 0, 0);
    }
    
    private boolean dfs(char[] s, int index, int left, int right) {
        if(index == s.length) return left == right;
        
        switch(s[index]) {
            case '(': return dfs(s, index+1, left+1, right);
            case ')': return right+1 <= left ? dfs(s, index+1, left, right+1) : false;
            case '*': 
                if(dfs(s, index+1, left, right)) return true;
                else if(dfs(s, index+1, left+1, right)) return true;
                else return right+1 <= left ? dfs(s, index+1, left, right+1) : false;
        }
        return false;
    }
}