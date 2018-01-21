class Solution {
    int minInterval;
    String res;
    
    public String nextClosestTime(String time) {
        Set<Character> set = new HashSet<>();
        for (int i=0; i<time.length();i++)
            if (time.charAt(i)!=':')
            set.add(time.charAt(i));
        
        minInterval = Integer.MAX_VALUE;
        res = "";
        search("",set,time);
        
        return res;
    }
    
    private void search(String str, Set<Character> set, String time){
        if (str.length()==5){
            if (valid(str) && lengthOfTime(time, str) < minInterval){
                minInterval = lengthOfTime(time, str);
                res = str;
            }
            
            return;
        }
        
        if (str.length()==2)
            str+=":";
        
        for (Character c: set){
            search(str+c, set, time);
        }
    }
    
    private int lengthOfTime(String t1, String t2){
        int num1 = getMin(t1);
        int num2 = getMin(t2);
        
        if (num1>=num2)
            return num2 + 24 * 60 - num1;
        else
            return num2 - num1;
    }
    
    private int getMin(String time){
        String[] strs = time.split(":");
        return Integer.valueOf(strs[0]) * 60 + Integer.valueOf(strs[1]);
    }
    
    private boolean valid(String time){
        String[] strs = time.split(":");
        return Integer.valueOf(strs[0])<24 && Integer.valueOf(strs[1])<60;
    }
}