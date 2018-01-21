public class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        for(int i = 0; i < s.length(); i++){
            helper2(s, i, i);
            helper2(s, i , i + 1);
        }
        return count;
    }
    public void helper2(String s, int i, int j){
        while(i >= 0 && j < s.length()){
            if(s.charAt(i) != s.charAt(j)){
                return;
            }
            count++;
            i--;
            j++;
        }
    }
}