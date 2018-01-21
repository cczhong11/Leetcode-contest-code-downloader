public class Solution {
    public String solveEquation(String equation) {
        String[] temp = equation.split("=");
        int[] l = parseEq(temp[0]), r = parseEq(temp[1]);
        //return "" + l[0] + l[1] + r[0] + r[1];
        if(l[0] == r[0]) return l[1] == r[1]? "Infinite solutions": "No solution";
        else return "x=" + String.valueOf((r[1]-l[1])/(l[0]-r[0]));
    }
    
    private int[] parseEq(String s) {
        int[] ans = new int[2];
        boolean pos = true;
        int curr = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 'x') {
                if(i == 0 || s.charAt(i-1) == '+' || s.charAt(i-1) == '-') ans[0] += pos? 1: -1;
                else ans[0] += pos? curr: -curr;
            }
            else if(s.charAt(i) == '+'){
                if(i > 0 && s.charAt(i-1) != 'x') {
                    ans[1] += pos? curr: -curr;
                } 
                pos = true;
                curr = 0;
            }
            else if(s.charAt(i) == '-'){
                if(i > 0 && s.charAt(i-1) != 'x') {
                    ans[1] += pos? curr: -curr;
                } 
                pos = false;
                curr = 0;
            }
            else {
                curr = curr*10 + s.charAt(i) - '0';
            }
        }
        if(s.charAt(s.length()-1) != 'x') ans[1] += pos? curr: -curr;
        return ans;
    }
}