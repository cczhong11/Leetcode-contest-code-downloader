class Solution {
    public boolean checkValidString(String s) {
        if(s.isEmpty()) return true;
        return checkValidStringHelper(s, 0, 0);
    }
    
    private boolean checkValidStringHelper(String s, int pos, int currentCount){
        if(currentCount < 0) return false;
        if(pos == s.length()){
          if(currentCount == 0) return true;
          else return false;
        } 
        if(s.charAt(pos) == '(') return checkValidStringHelper(s, pos+1,currentCount+1);
        else if(s.charAt(pos) == ')') return checkValidStringHelper(s, pos+1,currentCount-1);
        else return checkValidStringHelper(s, pos+1,currentCount+1) 
                  || checkValidStringHelper(s, pos+1,currentCount) 
                  || checkValidStringHelper(s, pos+1,currentCount-1);
    }
}