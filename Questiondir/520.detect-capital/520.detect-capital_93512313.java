public class Solution {
    public boolean detectCapitalUse(String word) {
        char c=word.charAt(0);
        boolean capital=false;
        if(c>=65&&c<=90)capital=true;
        if(capital&&word.length()>1&&word.charAt(1)>=97){
            for(int i=1;i<word.length();i++){
                if(!(word.charAt(i)>=97))return false;
            }
            return true;
        }
        for(int i=0;i<word.length();i++){
            if(!capital&&word.charAt(i)>=97)continue;
            else if(capital&&word.charAt(i)<=90)continue;
            else return false;
        }
        return true;
    }
}