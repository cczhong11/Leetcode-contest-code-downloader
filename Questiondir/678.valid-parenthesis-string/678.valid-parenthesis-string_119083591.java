class Solution {
    public boolean checkValidString(String s) {
        if(s == null) return true;
        int left = 0, star = 0, rightstar = 0;
        int len = s.length();
        if(len == 0) return true;
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch == '*'){
                star++;
                if(rightstar < left) rightstar++;
            }
            else if(ch == '(') left++;
            else{
                if(left == 0){
                    if(star == 0) return false;
                    else{
                        if(star == rightstar) rightstar--;
                        star--;
                    }
                }else{
                    if(rightstar == left) rightstar--;
                    left--;                  
                }
            }
            System.out.println(i + "-left: " + left + " star: " + star + " rightstar: " + rightstar);
        }
        if(left > rightstar) return false;
        else return true;
    }
}