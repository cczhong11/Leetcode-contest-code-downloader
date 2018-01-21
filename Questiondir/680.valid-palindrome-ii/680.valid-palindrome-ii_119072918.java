class Solution {
    public boolean validPalindrome(String s) {
        if(s.isEmpty()) return true;
        int head = 0, tail = s.length()-1;
        while(head < tail){
            if(s.charAt(head) == s.charAt(tail)){
                head++;
                tail--;
            }
            else{
                return validPalindromeHelper(s, head+1, tail) || validPalindromeHelper(s, head, tail-1);
            }
        }
        return true;
    }
    
    private boolean validPalindromeHelper(String s, int head, int tail){
        if(head >= tail) return true;
        while(head < tail){
            if(s.charAt(head) == s.charAt(tail)){
                head++;
                tail--;
            }
            else return false;
        }
        return true;
    }
}