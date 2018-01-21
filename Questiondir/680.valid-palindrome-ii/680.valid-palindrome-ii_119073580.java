class Solution {
    public boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPalin(s,start+1,end)||isPalin(s,start,end-1);
            }
            start++;
            end--;
        }
        return true;
    }
    public boolean isPalin(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}