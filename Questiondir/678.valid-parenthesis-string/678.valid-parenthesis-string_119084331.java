class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftSt = new Stack<>();
        boolean []flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') leftSt.push(i);
            else if (c == ')') {
                if (!leftSt.isEmpty()) {
                    int leftIndex = leftSt.pop();
                    flag[leftIndex] = flag[i] = true;
                }
            }
        }
        String updatedStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) continue;
            updatedStr = updatedStr + s.charAt(i);
        }
        
        flag = new boolean[updatedStr.length()];
        leftSt = new Stack<>();
        for (int i = 0; i < updatedStr.length(); i++) {
            char c = updatedStr.charAt(i);
            if (c == '*') leftSt.push(i);
            else if (c == ')') {
                if (!leftSt.isEmpty()) {
                    int leftIndex = leftSt.pop();
                    flag[leftIndex] = flag[i] = true;
                }
            }
        }
        String updatedStr2 = "";
        for (int i = 0; i < updatedStr.length(); i++) {
            if (flag[i]) continue;
            updatedStr2 = updatedStr2 + updatedStr.charAt(i);
        }
        
        flag = new boolean[updatedStr2.length()];
        leftSt = new Stack<>();
        for (int i = 0; i < updatedStr2.length(); i++) {
            char c = updatedStr2.charAt(i);
            if (c == '(') leftSt.push(i);
            else if (c == '*') {
                if (!leftSt.isEmpty()) {
                    int leftIndex = leftSt.pop();
                    flag[leftIndex] = flag[i] = true;
                }
            }
        }
        String updatedStr3 = "";
        for (int i = 0; i < updatedStr2.length(); i++) {
            if (flag[i]) continue;
            updatedStr3 = updatedStr3 + updatedStr2.charAt(i);
        }
        
        for (int i = 0; i < updatedStr3.length(); i++) {
            char c = updatedStr3.charAt(i);
            if (c != '*') return false;
        }
        return true;
    }
}