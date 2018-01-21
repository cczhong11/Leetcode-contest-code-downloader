class Solution {
    public int cal(String a, String b){
        return Integer.valueOf(a) * 60 + Integer.valueOf(b);
    }
    
    public String nextClosestTime(String time) {
        char [] s = {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        int fir = cal(time.substring(0, 2), time.substring(3)), anss = 24 * 600;
        String ans = "";
        for(char a : s){
            for(char b : s){
                for(char c : s){
                    for(char d : s){
                        String t = "" + a + b + ':' + c + d;
                        int hour = Integer.valueOf(t.substring(0, 2)), min = Integer.valueOf(t.substring(3));
                        if(hour < 0 || hour > 23 || min < 0 || min > 59)
                            continue;
                        int sec = cal(t.substring(0, 2), t.substring(3));
                        int diff = sec > fir ? sec - fir : 24 * 60 - fir + sec;
                        if(diff < anss){
                            anss = diff;
                            ans = t;
                        }
                    }
                }
            }
        }
        return ans;
    }
}