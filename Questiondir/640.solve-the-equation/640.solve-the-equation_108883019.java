public class Solution {
    public class Pair {
        int numOfX;
        int num;
        Pair (int numOfX, int num) {
            this.numOfX = numOfX;
            this.num = num;
        }
    }
    public String solveEquation(String equation) {
        String[] list = equation.split("=");
        String left = list[0];
        String right = list[1];
        Pair p1 = getPair(left);
        Pair p2 = getPair(right);
        if (p1.numOfX == p2.numOfX) {
            if (p1.num == p2.num) {
                return "Infinite solutions";
            }
            else {
                return "No solution";
            }
        }
        else {
            p1.numOfX -= p2.numOfX;
            p2.num -= p1.num;
            return "x=" + p2.num / p1.numOfX;
        }
        
    }
    public Pair getPair(String s) {
        String[] list = s.split("\\+");
        int numOfX = 0;
        int num = 0;
        for (String str : list) {
            if (str.length() == 0) {
                continue;
            }
            int index = 0;
            int formerIndex = 0;
            index = str.indexOf("-");
            while (index >= 0) {
                if (index == 0) {
                    index = str.indexOf("-", index + 1);
                    continue;
                }
                int coe = 0;
                if (str.charAt(index - 1) == 'x') {
                    String t = str.substring(formerIndex, index - 1);
                    if (t.equals("-")) {
                        coe = -1;
                    }
                    else if (t.equals("")) {
                        coe = 1;
                    }
                    else
                    coe = Integer.parseInt(str.substring(formerIndex, index - 1));
                    numOfX += coe;
                }
                else {
                    coe = Integer.parseInt(str.substring(formerIndex, index));
                    num += coe;
                }
                formerIndex = index;
                index = str.indexOf("-", index + 1);
            }
            if (str.charAt(str.length() - 1) == 'x') {
                String temp = str.substring(formerIndex, str.length() - 1);
                if (temp.equals("")) {
                    numOfX += 1;
                }
                else if (temp.equals("-")) {
                    numOfX -= 1;
                }
                else
                numOfX += Integer.parseInt(str.substring(formerIndex, str.length() - 1));
            }
            else {
                num += Integer.parseInt(str.substring(formerIndex));
            }
        }
        return new Pair(numOfX, num);
    }
}